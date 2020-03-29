<template>
<div>
    <el-form :inline="true" :model="searchMap" class="demo-form-inline">
    <el-form-item label="活动名称">
      	<el-input v-model="searchMap.name" placeholder="请输入活动名称"></el-input>
    </el-form-item>
    <el-form-item label="活动时间">
        <el-date-picker v-model="searchMap.starttime" type="date" placeholder="请选择活动开始日期">
        </el-date-picker>
        <el-date-picker v-model="searchMap.endtime" type="date" placeholder="请选择活动结束日期">
        </el-date-picker>
    </el-form-item>
    <el-form-item>
      	<el-button type="primary" @click="fetchData">查 询</el-button>
        <el-button type="primary" @click="dialogFormVisible = true">新增</el-button>
    </el-form-item>
</el-form>

    <el-table :data="list" border style="width: 100%">
    <el-table-column  prop="id"  label="活动ID"></el-table-column>
    <el-table-column  prop="name"  label="活动名称"></el-table-column>
    <el-table-column  prop="sponsor"  label="主办方"></el-table-column>
    <el-table-column  prop="address"  label="活动地址"></el-table-column>
    <el-table-column  prop="starttime"  label="开始日期"></el-table-column>
    <el-table-column  prop="endtime"   label="结束日期"></el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
  <template slot-scope="scope">
  <el-button @click="handleEdit(scope.row.id)" type="text" size="small">修改</el-button>
  <el-button @click="handleDelete(scope.row.id)" type="text" size="small">删除</el-button>
  </template>
</el-table-column>
  </el-table>
  <el-pagination
      @size-change="pageSizeChange"
      @current-change="pageNoChange"
      :current-page="page"
      :page-sizes="[5, 10, 20]"
      :page-size="size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
  </el-pagination>

   <el-dialog title="编辑" :visible.sync="dialogFormVisible">
    <el-form label-width="80px">
      <el-form-item label="活动名称">
          <el-input v-model="pojo.name" placeholder="活动名称"></el-input>
      </el-form-item>
      <el-form-item label="城市">
  <el-select v-model="pojo.city" placeholder="请选择">
    <el-option
       v-for="item in cityList"
       :key="item.id"
       :label="item.name"
       :value="item.id">
    </el-option>
  </el-select>
</el-form-item>
      <el-form-item label="开始日期">
          <el-date-picker type="date" v-model="pojo.starttime" placeholder="开始日期"></el-date-picker>
      </el-form-item>
      <el-form-item label="截至日期">
          <el-date-picker type="date" v-model="pojo.endtime" placeholder="截至日期"></el-date-picker>
      </el-form-item>
      <el-form-item label="报名截止">
          <el-date-picker type="date" v-model="pojo.enrolltime" placeholder="报名截止"></el-date-picker>
      </el-form-item>
      <el-form-item label="活动详情">
         <el-input v-model="pojo.detail" placeholder="活动详情" type="textarea" :rows="2"></el-input>
      </el-form-item>
       <el-form-item label="是否可见">
         <el-switch active-value="1" inactive-value="0" v-model="pojo.state"></el-switch>
      </el-form-item>
      <el-form-item>
       <el-button type="primary" @click="handleSave()">保存</el-button>
        <el-button @click="dialogFormVisible = false" >关闭</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
  </div>
</template>
<script>
import gatheringApi from '@/api/gathering';
import cityApi from '@/api/city';
export default {
    data(){
      return {
          pojo:{},
          list:[],
         total:0,//总记录数
         page:1,//当前页
         size:10,//每页大小
         searchMap: {},//查询表单绑定变量
        dialogFormVisible: false, //对话框是否显示
        cityList:[],
        id:'' //当前编辑的ID
      }  
    },
    created(){
        this.fetchData();
         cityApi.getList().then(res =>{
        this.cityList = res.data
    })
    },
    methods:{
        fetchData(){
           gatheringApi.search(this.currentPage,this.pageSize,this.searchMap).then( res =>{
               this.list=res.data.rows
               this.total=res.data.total
           })
       },
     // 每页显示记录数变化时，刷新
      pageSizeChange(_sizeChange){
          this.pageSize = _sizeChange
          this.fetchData()
      },
      // 页码发生变化时，刷新
      pageNoChange(_pageNoChange){
          this.currentPage = _pageNoChange
          this.fetchData()
      },
      handleSave(){
    if(this.id){//修改
        gatheringApi.update(this.id,this.pojo).then(res =>{
            alert(res.message)
            if(res.flag){//如果成功
                this.dialogFormVisible=false//关闭窗口
              	this.fetchData()//刷新列表
            }           
        })
    }else{//新增
        gatheringApi.add(this.pojo).then(res=>{
            alert(res.message)
            if(res.flag){//如果成功
                this.dialogFormVisible=false//关闭窗口
                this.fetchData()//刷新列表
            }
        })
    }
},
    // 活动管理-修改
    handleEdit(id){
        this.id=id
        //清空表单
        this.pojo={}
    this.dialogFormVisible=true//打开窗口 
    if(id){      
    //调用查询
    gatheringApi.findById(id).then( res => {
        if(res.flag){
          	this.pojo=response.data
        }
    })
    }
    },
    handleDelete(_id) {
    this.$confirm('此操作将永久删除该记录, 是否继续? 一旦删除将无法恢复', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
    }).then(() => {
        // 点击确定
        // 删除
        gatheringApi.deleteById(_id).then(res => {
            // 提示结果
            this.$message({
                showClose: true,
                message: res.message,
                type: res.flag ? 'success' : 'error'
            });
            // 成功时要刷新列表
            if(res.flag){
                this.fetchData()
            }
        })
    }).catch(() => {
        // 点击取消
    });
}
    }
}
</script>