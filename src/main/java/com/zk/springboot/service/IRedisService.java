package com.zk.springboot.service;

public interface IRedisService {

    boolean set(String key, Object obj, int expire);

    <T> T get(String key);

}
