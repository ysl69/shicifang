package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @Author ysl
 * @Date 2019/10/26 14:44
 * @Description:MongoDb入门小demo
 **/


public class MongoDemo {

    public static void main(String[] args) {
        //创建连接
        MongoClient client = new MongoClient("192.168.25.143");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //查询记录获取文档集合
        FindIterable<Document> documents = spit.find();
        for (Document document : documents) {
            System.out.println("内容："+  document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));
        }
        client.close();

    }
}
