package com.fullstacker.study.course.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

/**
 * @program: biz-es
 * @description:
 * @author: xgs
 * @create: 2019-02-28 17:18
 */
@Component("collectionNameProvider")
public class CollectionNameProvider {
    public static final String DEFAULT_COLLECTION_NAME = "default_collection";
    private static ThreadLocal<String> typeThreadLocal = new ThreadLocal<>();

    public static void setType(String type) {
        typeThreadLocal.set(type);
    }

    public String getCollectionName(Object obj) {

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");
        String name = (String) exp.getValue(obj);
        return "collectTest_";
    }

    private String doMapper(String type) {
        //TODO 这里自定义通过Type映射至Mapper的逻辑
        return "TestMongoCollection_1";
    }
}
