// 使用 Mock
let Mock = require('mockjs')
let data = Mock.mock({
    'list|10': [{
        'id|+1': 1,
        'name':'@cname',
        'ename':'@last',
        'cfirst':'@cfirst',
        'point':'@integer',
        'birthday':'@date',
        'pic':'@image',
        'title':'@title',
        'content':'@cword(100)',
        'url':"@url",
        'ip':"@ip",
        'email':"@email",
        'area':'@region',
        'address':'@county(true)'
    }]
})
// 输出结果
console.log(JSON.stringify(data,null,2))