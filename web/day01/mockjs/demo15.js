/ 使用 Mock
let Mock = require('mockjs')
let data = Mock.mock({
    'list|10': [{
        'id|+1': 1,
        'name':'@string',
        'point':'@integer',
        'birthday':'@date',
        'pic':'@image'
    }]
})
// 输出结果
console.log(JSON.stringify(data,null,2))