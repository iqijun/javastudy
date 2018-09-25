package com.fullstacker.study.course.JAVASE.string;

/**
 * @author xingguishuai
 * @create 2018-09-15-11:35
 **/
public class StringInternTest {


    /****
     * @param args
     */
    public static void main(String[] args){

        /***
         *
         * String.intern()注释信息
         *
         *Returns a canonical representation for the string object.
         * <p>
         *
         *  一个初始时为空的字符串池，它由类 String 私有地维护。
         * A pool of strings, initially empty, is maintained privately by the
         * class <code>String</code>.
         * <p>
         *
         * 当调用intern方法时，如果常量池中包含一个和该字符串equal的值时，返回常量池中的对象，
         * 否则将字符串添加到常量池中，并且返回该字符串对象引用。
         *
         * When the intern method is invoked, if the pool already contains a
         * string equal to this <code>String</code> object as determined by
         * the {@link #equals(Object)} method, then the string from the pool is
         * returned. Otherwise, this <code>String</code> object is added to the
         * pool and a reference to this <code>String</code> object is returned.
         * <p>
         *     当且仅当 s.equals(t)时 才会有 s.intern() == t.intern()
         * It follows that for any two strings <code>s</code> and <code>t</code>,
         * <code>s.intern()&nbsp;==&nbsp;t.intern()</code> is <code>true</code>
         * if and only if <code>s.equals(t)</code> is <code>true</code>.
         * <p>
         * All literal strings and string-valued constant expressions are
         * interned. String literals are defined in section 3.10.5 of the
         * <cite>The Java&trade; Language Specification</cite>.
         *
         * @return  a string that has the same contents as this string, but is
         *          guaranteed to be from a pool of unique strings.
         *
         *
         */


        /**
         *在定义String变量的时候赋值
         * 1. 如果赋值的是静态的字符串，就会执行进入字符串池的操作,如果池中含有该字符串，则返回引用；
         * 2. 如果赋值的时候有变量（如变量f，其中有变量e）,则直接new 一个新的字符串
         *
         *
         */



        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;

        System.out.println(b.intern() == a);  //false
        System.out.println(b.intern() == c);  //true
        System.out.println(b.intern() == d);  //true
        System.out.println(b.intern() == f);  //false
        System.out.println(b.intern() == a.intern());//true
        System.out.println(b.intern() == f.intern()); //true

        System.out.println("=======================================");


        String string1 = "abc";
        String string2 = "a"+"bc";
        String string3 = "a"+"b"+"c";
        String string4 = "ab"+"c";

        String  tmp = "ab";
        String  string5 = tmp+"c";

        System.out.println(string1 == string2);//true
        System.out.println(string1 == string3);//true
        System.out.println(string1 == string4);//true
        System.out.println(string1 == string5);//false
        System.out.println(string1.intern() == string2.intern());//true
        System.out.println(string1.intern() == string3.intern());//true
        System.out.println(string1.intern() == string4.intern());//true
        System.out.println(string1.intern() == string5.intern());//true


        System.out.println("=======================================");



        StringBuffer sb1 = new StringBuffer();
        sb1.append("计算机").append("软件");
        String str1 = sb1.toString(); //相当于
        System.out.println("str1:"+(str1.intern() == str1)); // jdk7 true

        /****
         *  常量池中为什么会有“java”这个字符串呢？
         * 原因是这样的，并没有java字符串常量池中，有默认字符串常量这样的机制。而是其实jvm从启动，
         * 到执行main里面的第一条代码，要经历很多的，比如加载rt.jar里面所有的Class，加载一个class肯定要执行static{}中内容
         * ，况且rt.jar中的jdk的类里面有很多xxx.startWith("java")或者其他用到"java"的代码，
         * jvm启动的时候直接按照常量加载进来了丢到internmap里面了
         *
         * StringBuffer.toString()方法会new一个新的字符串
         *
         */
        StringBuffer sb2 = new StringBuffer();
        sb2.append("ja").append("va");
        String str2 = sb2.toString(); //相当于new String("java")
        System.out.println("str2:"+(str2.intern() == str2)); // jdk7 false

        System.out.println("===========================");

        //在创建abc1时，创建了一个堆中的对象，和一个常量池中的对象
        String abc1 = new String("abc");
        //在创建abc2时只创建了一个堆中的对象，不再创建常量池中的对象
        String abc2 = new String("abc");
        System.out.println("1233:"+(abc1 == abc2) );
        System.out.println(abc1.intern() == abc1);
        System.out.println(abc1.intern() == abc2);
        System.out.println(abc1.intern() == abc2.intern());

        System.out.println("===========================");
    }
}
