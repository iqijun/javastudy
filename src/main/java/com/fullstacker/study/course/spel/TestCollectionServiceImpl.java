package com.fullstacker.study.course.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: biz-es
 * @description:
 * @author: xingguishuai
 * @create: 2019-02-28 17:31
 */
@Service
public class TestCollectionServiceImpl implements TestCollectionService {

    @Autowired(required = false)
    private MongoTemplate mongoTemplate;

    @Override
    public TestMongoCollection save(TestMongoCollection po) {
        mongoTemplate.save(po);
        return po;
    }
}
