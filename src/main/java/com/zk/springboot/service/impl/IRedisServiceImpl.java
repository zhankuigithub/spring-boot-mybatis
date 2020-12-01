package com.zk.springboot.service.impl;

import com.zk.springboot.service.IRedisService;
import org.springframework.stereotype.Component;

@Component
public class IRedisServiceImpl implements IRedisService {

//    @Resource
//    private RedisTemplate redisTemplate;


    @Override
    public boolean set(String key, Object obj, int expire) {
       // return redisTemplate.opsForValue().setIfAbsent(key, obj, expire, TimeUnit.SECONDS);
        return false;
    }

    @Override
    public <T> T get(String key) {
       // redisTemplate.opsForValue().get(key);
        return null;
    }
}
