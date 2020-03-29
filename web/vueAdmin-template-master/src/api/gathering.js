import request from "@/utils/request"
const group_name = 'gathering'
const api_name = 'gathering'
export default {
    getList(){
        return request({
            url: `/${group_name}/${api_name}`,
            method:'get'
        })
    },
    // 活动管理-分页查询
    search(page,size,searchMap) {
        return request({
            url: `/${group_name}/${api_name}/search/${page}/${size}`,
            method: 'post',
            data: searchMap
        })
    },
    // 活动管理-表单提交
    add(pojo) {
        return request({
            url: `/${group_name}/${api_name}`,
            method: 'post',
            data: pojo
        })
    },
    // 活动管理-修改
    findById(id) {
        return request({
            url: `/${group_name}/${api_name}/${id}`,
            method: 'get'
        })
    },
    //保存修改
    update(id,pojo) {
        return request({
            url: `/${group_name}/${api_name}/${id}`,
            method: 'put',
            data: pojo
        })
    },
    //删除数据
    deleteById(id) {
        return request({
            url: `/${group_name}/${api_name}/${id}`,
            method: 'delete'
        })
    }
}