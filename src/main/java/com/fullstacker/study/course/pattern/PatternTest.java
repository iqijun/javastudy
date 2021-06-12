package com.fullstacker.study.course.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: course
 * @description: 正则表达式测试
 * @author: xingguishuai
 * @create: 2019-10-12 13:28
 */
public class PatternTest {

    public static  void main(String[] args){
        String answeredQuestions = "<textarea>adfa fa</textarea><TEXTAREA>afa fa</textarea><textarea></textarea>";
//        Pattern.CASE_INSENSITIVE 指定忽略大小写
        Pattern pattern = Pattern.compile("\\<\\/?textarea.*?\\>",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(answeredQuestions);
        answeredQuestions= matcher.replaceAll("");
        System.out.println(answeredQuestions);
    }
}
