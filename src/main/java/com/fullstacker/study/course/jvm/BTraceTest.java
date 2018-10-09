package com.fullstacker.study.course.jvm;


public  class BTraceTest{

    public static void main(String[] args){
            while (true){
                try {
                    Thread.sleep(5000);
                    System.out.println(add((int) (Math.random()*100),(int) (Math.random()*100)));
                    doNothing("no","thing");
                    System.out.println("=======================================");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    private static int add(int a, int b){
        return  a+b;
    }

    private  static void doNothing(String no,String thing){
        System.out.println(no);
        System.out.println(thing);
    }

}