// 使用 Mock
let Mock = require('mockjs')
let data = Mock.mock({
    'list|5': [{
        'id|+1': 1,
        'name|2-3':'测试',
        'phone|11':'1',
        'point|122-500':0,
        'money|3000-8000.2':0,
        'money2|1000-5000.2-4':0,
    }]
})
// 输出结果
console.log(JSON.stringify(data,null,2))