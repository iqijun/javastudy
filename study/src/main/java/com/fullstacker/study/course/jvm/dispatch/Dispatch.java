package com.fullstacker.study.course.jvm.dispatch;

/**
 * @program: course
 * @description: 单分派与多分派
 * @author: xgs
 * @create: 2021-07-18 22:45
 */
public class Dispatch {

    static class  QQ{}
    static class _360{}
    public static class Father{
        public void hardChoice(QQ qq){
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 _360arg){
            System.out.println("father choose 360");
        }
    }
    public static class Son extends Father{
        public void hardChoice(QQ qq){
            System.out.println("Son choose qq");
        }

        public void hardChoice(_360 _360arg){
            System.out.println("Son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        // 使用javap命令查看编译后字节码
        //Method com/fullstacker/study/course/jvm/dispatch/Dispatch$Father.hardChoice:(Lcom/fullstacker/study/course/jvm/dispatch/Dispatch$QQ;)
        // 编译期已确定要调用参数是qq的方法 --> 静态分派根据静态类型+方法参数两个宗量确定 --> 静态分派是多分派
        father.hardChoice(new QQ());
        //Method com/fullstacker/study/course/jvm/dispatch/Dispatch$Father.hardChoice:(Lcom/fullstacker/study/course/jvm/dispatch/Dispatch$_360;)
        // 运行时调用的是son类中的hardchoice(360)方法 --> 静态分派只根据实际类型进行分派 --> 动态分派是单分派
        son.hardChoice(new _360());
    }
}
