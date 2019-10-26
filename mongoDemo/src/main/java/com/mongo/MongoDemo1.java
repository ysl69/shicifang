package com.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @Author ysl
 * @Date 2019/10/26 16:24
 * @Description:
 **/


public class MongoDemo1 {
    public static void main(String[] args) {
        MongoClient client=new MongoClient("192.168.25.143");//创建连接
        MongoDatabase spitdb = client.getDatabase("spitdb");//打开数据库
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合
        BasicDBObject bson=new BasicDBObject("userid","1013");// 构建查询条件
        FindIterable<Document> documents = spit.find(bson);//查询记录获取结果集合
        for(Document document:documents){ //
            System.out.println("内容："+  document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));
        }
        client.close();//关闭连接
    }
}
