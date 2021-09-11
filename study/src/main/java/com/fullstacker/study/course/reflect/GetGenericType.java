package com.fullstacker.study.course.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @program: course
 * @description: ͨ�������ȡ������Ϣ
 * @author: xgs
 * @create: 2021-07-28 16:15
 */
public class GetGenericType {
    public static void main(String[] args) throws NoSuchFieldException {
        ReflectPo reflectPo = new ReflectPo();
        Class<? extends ReflectPo> aClass = reflectPo.getClass();
//        list ���͵�friendsName  map���͵�map
        Field friendsName = aClass.getDeclaredField("map");
        Type genericType = friendsName.getGenericType();
        String typeName = genericType.getTypeName();
        System.out.println(typeName);

        if(genericType instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType)genericType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }

        }

    }
}
