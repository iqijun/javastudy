package com.fullstacker.study.course.spel;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: biz-es
 * @description:
 * @author: xgs
 * @create: 2019-02-28 17:19
 */
@Document(collection = "#{@collectionNameProvider.getCollectionName(#root)}")
public class TestMongoCollection {
    
    private String id;
    
    private String name;
    
    private int age;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
