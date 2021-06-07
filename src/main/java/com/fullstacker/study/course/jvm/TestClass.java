package com.fullstacker.study.course.jvm;

/**
 * 这是深入理解java虚拟机中第6章的例子，用于测试class文件结构
 *
 * @author xingguishuai
 * @create 2018-10-09-16:48
 **/
public class TestClass {

    private int m;

    public int inc() {
        return m + 1;
    }

}


/**
 * javap命令查看字节码指令
 * C:\Users\xingguishuai\Desktop>javap -v TestClass.class
 * Classfile /C:/Users/xingguishuai/Desktop/TestClass.class
 * Last modified 2018-10-9; size 419 bytes
 * MD5 checksum c6020a839b8c79ad1302ed73f260b32b
 * Compiled from "TestClass.java"
 * public class com.fullstacker.study.course.jvm.TestClass
 * SourceFile: "TestClass.java"
 * minor version: 0
 * major version: 51
 * flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 * #1 = Methodref          #4.#18         //  java/lang/Object."<init>":()V
 * #2 = Fieldref           #3.#19         //  com/fullstacker/study/course/jvm/TestClass.m:I
 * #3 = Class              #20            //  com/fullstacker/study/course/jvm/TestClass
 * #4 = Class              #21            //  java/lang/Object
 * #5 = Utf8               m
 * #6 = Utf8               I
 * #7 = Utf8               <init>
 * #8 = Utf8               ()V
 * #9 = Utf8               Code
 * #10 = Utf8               LineNumberTable
 * #11 = Utf8               LocalVariableTable
 * #12 = Utf8               this
 * #13 = Utf8               Lcom/fullstacker/study/course/jvm/TestClass;
 * #14 = Utf8               inc
 * #15 = Utf8               ()I
 * #16 = Utf8               SourceFile
 * #17 = Utf8               TestClass.java
 * #18 = NameAndType        #7:#8          //  "<init>":()V
 * #19 = NameAndType        #5:#6          //  m:I
 * #20 = Utf8               com/fullstacker/study/course/jvm/TestClass
 * #21 = Utf8               java/lang/Object
 * {
 * public com.fullstacker.study.course.jvm.TestClass();
 * flags: ACC_PUBLIC
 * Code:
 * stack=1, locals=1, args_size=1
 * 0: aload_0
 * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 * 4: return
 * LineNumberTable:
 * line 8: 0
 * LocalVariableTable:
 * Start  Length  Slot  Name   Signature
 * 0       5     0  this   Lcom/fullstacker/study/course/jvm/TestClass;
 * <p>
 * public int inc();
 * flags: ACC_PUBLIC
 * Code:
 * stack=2, locals=1, args_size=1   // inc方法没有参数，但locals,args_size的值都为1，是因为java中把“this”关键字转变为一个不同的方法参数，所以在实例方法中至少有一个指向当前对象实例的局部变量；
 * //局部变量表中也会预留第一个slot位来存放对象实例的引用。如果方法被声明为静态方法则不存在这个问题
 * 0: aload_0
 * 1: getfield      #2                  // Field m:I
 * 4: iconst_1
 * 5: iadd
 * 6: ireturn
 * LineNumberTable:
 * line 12: 0
 * LocalVariableTable:
 * Start  Length  Slot  Name   Signature
 * 0       7     0  this   Lcom/fullstacker/study/course/jvm/TestClass;
 * }
 **/

