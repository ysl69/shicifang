var http = require('http');
//createServer 创建一个Web服务，回调函数为参数，request为请求的消息，response为响应请求
http.createServer(function (request, response) {
    // 发送 HTTP 头部 
    // HTTP 状态值: 200 : OK
    // 内容类型: text/plain
    response.writeHead(200, {'Content-Type': 'text/plain'});
    // 发送响应数据 "Hello World"
    response.end('Hello World\n');
}).listen(8888);//服务监听的端口
// 
console.log('Server running at http://127.0.0.1:8888/');