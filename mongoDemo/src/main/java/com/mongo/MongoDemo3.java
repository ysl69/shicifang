package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ysl
 * @Date 2019/10/26 16:30
 * @Description:
 **/


public class MongoDemo3 {
    public static void main(String[] args) {
        MongoClient client=new MongoClient("192.168.25.143");//创建连接
        MongoDatabase spitdb = client.getDatabase("spitdb");//打开数据库
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合

        Map<String,Object> map=new HashMap();
        map.put("content","我要吐槽");
        map.put("userid","9999");
        map.put("visits",123);
        map.put("publishtime",new Date());
        Document document=new Document(map);

        spit.insertOne(document);//插入数据
        client.close();
    }
}
