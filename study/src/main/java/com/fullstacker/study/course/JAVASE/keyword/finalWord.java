package com.fullstacker.study.course.JAVASE.keyword;

public class finalWord {
    
    public static final void main(String[] args) {
        
        String s1 = "finalStr";
        final String s2 = "final";
        String s3 = "final";
        String s2Join = s2 + "Str";
        String s3Join = s3 + "Str";
        System.out.println("s2Join:" + s2Join);
        System.out.println("s3Join:" + s3Join);
        System.out.println(s1 == s2Join);
        System.out.println(s1 == s3Join);
    }
}
