package com.fullstacker.study.course.other;

/**
 * 方法传值测试
 */

public class TransValueTest {
    
    public void transValue(int baseType, Integer objType) {
        Integer integer = new Integer(10);
        baseType = integer;
        objType = integer;
    }
    
    public static void main(String[] args) {
        TransValueTest transValueTest = new TransValueTest();
        int baseType = 1;
        Integer objType = 12;
        transValueTest.transValue(baseType, objType);
        //        System.out.println("baseT:"+baseType);
        //        System.out.println("objType:"+objType);
        //        String s = null + "str";
        //        System.out.println(s);
        //        System.out.println(null +"str");
        
        //        ArrayList<Object> list = Lists.newArrayList();
        //        list.add(1);
        //        list.add(2);
        //        list.add(3);
        //        list.add(4);
        //       System.out.println(StringUtils.join(list.toArray(), "_"));
        
        boolean equals = Integer.valueOf(Integer.MAX_VALUE).equals(null);
        System.out.println(equals);
        //        Calendar calendar = Calendar.getInstance();
        //        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    }
}
