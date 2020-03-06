// 使用 Mock
let Mock = require('mockjs')
let data = Mock.mock({
    'list|5': [{
        'id|+1': 1,
        'name|2-3':'测试',
        'phone|11':'1',
        'point|122-500':0,
        'money|3000-8000.2':0,
        'status|1':true,
        'default|1-3':true,
        'detail|2-3':{'id':1,'date':'2005-01-01','content':'记录'}
    }]
})
// 输出结果
console.log(JSON.stringify(data,null,2))