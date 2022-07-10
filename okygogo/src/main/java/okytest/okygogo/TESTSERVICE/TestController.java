//package com.oky.demo.controller;
package okytest.okygogo.TESTSERVICE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.conversions.Bson;

@Controller

public class TestController {
    //public static void main(String[] args){
    String mongoUri = 
// MongoDB Connection
        "mongodb+srv://m001-student:m001-mongodb-basics@sandbox.mwg8w.mongodb.net/sample_training?retryWrites=true&w=majority";
    MongoDatabase sample = MongoClients.create(mongoUri).getDatabase("sample_mflix");
    MongoCollection<Document> card = sample.getCollection("movies");
    Document myDoc = card.find().limit(1).iterator().next();
    //System.out.println(myDoc.toJson());
    @GetMapping(value = "/mongodb")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public HashMap<String,Object> mongoInfo(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("id", myDoc.toJson());
        return map;
    }

    @GetMapping(value = "/userInfo")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public HashMap<String,Object> userInfo(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("id", "okymillion");
        map.put("email", "okymillion@github.com");
        map.put("address", "korea");
        return map;
    }
    @GetMapping(value = "/appinfo")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public HashMap<String,Object> appInfo(){
        HashMap<String,Object> map = new HashMap<>();
        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("version", "1.0.0");
        map2.put("inMaintenance", false);
        map.put("data", map2);
        return map;
    }

    /*
    GetMapping(value = "/videos")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public HashMap<String,Object> appInfo(){
        HashMap<String,Object> map = new HashMap<>();
        HashMap<String,Object> map2 = new HashMap<>();
        HashMap<String,Object> map3 = new HashMap<>();
        map2.put("id", "okymillion");
        map2.put("inventory", "okyinven");
        map2.put("ratingAverage", 4.5);
        map2.put("ratingQuantity", 3);
        map2.put("price", "35000");
        map2.put("discountedPrice", "30000");
        map2.put("category", 4);
        map2.put("name", "okyname");
        map2.put("nameInEng", "okynameen");
        map2.put("price", "35000");
        map2.put("location", "koreancity");
        map2.put("descriptionImgPath", "/okyimage1");
        map2.put("thumbnailPath", "/okyimage2");
        ArrayList detailpath = new ArrayList();
        detailpath.add("eimage1");
        detailpath.add("eimage2");
        map2.put("detailImgPath", detailpath);
        map2.put("weight", 180);

        map3.put("createdAt","2021-12-10 20:18:04")
        map3.put("review","I really liked this!")
        map3.put("rating",5.0)
        map3.put("userName","tk1star2")
        map3.put("id","okymillion")

        map2.put("review", map3);

        map.put("data", map2);

        return map;
    }
    */
}
