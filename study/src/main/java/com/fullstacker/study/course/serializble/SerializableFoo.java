package com.fullstacker.study.course.serializble;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class SerializableFoo implements Serializable {
    
    Object obje = new Object();
    
    //    ObjectOutput
    
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("", "");
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        objectObjectHashtable.put("", "");
        ConcurrentHashMap<Object, Object> cc = new ConcurrentHashMap<>();
        cc.put("", "");
    }
}
