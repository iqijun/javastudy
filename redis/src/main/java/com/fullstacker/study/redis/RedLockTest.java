package com.fullstacker.study.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @program: course
 * @description: redlock
 * @author: xgs
 * @create: 2021-09-04 17:15
 */
public class RedLockTest {

    public static void main(String[] args) {
        Config config = new Config();
        RedissonClient redisson =  Redisson.create(config);
        RLock lock = redisson.getLock("");
        lock.tryLock();
    }
}
