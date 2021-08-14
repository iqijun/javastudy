package com.fullstacker.study.course.reflect;

import java.util.List;
import java.util.Map;

/**
 * 反射示例实体类
 *
 * @author xingguishuai
 * @create 2017-11-08-16:14
 **/
public class ReflectPo {

    private String name;

    private Long id;

    private List<String> friendsName;

    private Map<String, ReflectPo> map;

    private static String testStatic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getFriendsName() {
        return friendsName;
    }

    public void setFriendsName(List<String> friendsName) {
        this.friendsName = friendsName;
    }

    public Map<String, ReflectPo> getMap() {
        return map;
    }

    public void setMap(Map<String, ReflectPo> map) {
        this.map = map;
    }

    public static String getTestStatic() {
        return testStatic;
    }

    public static void setTestStatic(String testStatic) {
        ReflectPo.testStatic = testStatic;
    }
}
