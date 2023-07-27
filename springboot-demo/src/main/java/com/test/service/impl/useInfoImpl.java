package com.test.service.impl;

import com.test.dao.useInfoMapper;
import com.test.pojo.useInfo;
import com.test.service.useInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.util.concurrent.TimeUnit;

@Service
public class useInfoImpl implements useInfoService {
    @Autowired
    private useInfoMapper useInfoMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void add(useInfo useInfo) {
        useInfoMapper.add(useInfo);
    }

    @Override
    public void delete(Integer id) {
        useInfoMapper.delete(id);
    }

    @Override
    public void update(useInfo useInfo) {
        useInfoMapper.update(useInfo);
    }

    @Override
    public useInfo queryById(Integer id) {
        // 从缓存中获取城市信息
        String key ="city_" +id;
        ValueOperations<String, useInfo> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            useInfo useInfo = operations.get(key);
            System.out.println("useInfoMapper.queryById(id) : 从缓存中获取了城市 >> " + useInfo.toString());
            return useInfo;
        }
        // 从 DB 中获取城市信息
        useInfo useInfo = useInfoMapper.queryById(id);
        // 插入缓存
        operations.set(key, useInfo, 1000, TimeUnit.SECONDS);
        System.out.println("useInfoMapper.queryById(id) : 城市插入缓存 >> " + useInfo.toString());
        return useInfo;
    }

    @Override
    public List<useInfo> queryAll() {
        return useInfoMapper.queryAll();
    }
}
