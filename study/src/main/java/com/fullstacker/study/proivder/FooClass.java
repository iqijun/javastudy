package com.fullstacker.study.proivder;

/**
 * @program: course
 * @description:
 * @author: xgs
 * @create: 2021-04-05 16:15
 */
public class FooClass implements Cloneable {
    
    private String name;
    
    private Integer age;
    
    private int sex;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public int getSex() {
        return sex;
    }
    
    public void setSex(int sex) {
        this.sex = sex;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
