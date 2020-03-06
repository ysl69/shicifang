let Mock=require('mockjs')
let data=Mock.mock({
    'list|5':[
        {
            'id':1,
            'name':'测试'
        }
    ]
})
console.log(JSON.stringify(data,null,2 ))