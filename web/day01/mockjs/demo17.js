// 使用 Mock
let Mock = require('mockjs')
let data = Mock.mock({
    'list|10': [{
        // 属性 id 是一个自增数，起始值为 1，每次增 1
        'id|+1': 1,
        'name':'@cname',
        'ename':'@last',
        'cfirst':'@cfirst',
        'point':'@integer',
        'birthday':'@date',
        'pic':'@image',
        'title':'@title',
        'content':'@cword(100)'
    }]
})
// 输出结果
console.log(JSON.stringify(data,null,2))