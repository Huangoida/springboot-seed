/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.oida.framework.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 缓存工具类
 */
@Slf4j
@Component
public class CacheUtil {

    private static RedisTemplate<String,Object> redisTemplate;

    @Resource
    private RedisTemplate<String,Object> autoredisTemplate;


    @PostConstruct
    public void init(){
        redisTemplate= autoredisTemplate;
    }

    public static void put(String cacheName, Object key, Object value) {
        String redisKey = cacheName+"."+key;
        redisTemplate.opsForValue().set(redisKey,value);
    }

    /**
     * @param timeToIdleSeconds 缓存自创建日期起至失效时的间隔时间
     * @param timeToLiveSeconds 缓存创建以后，最后一次访问缓存的日期至失效之时的时间间隔
     */
    public static void put(String cacheName, String key, Object value, int timeToIdleSeconds, int timeToLiveSeconds) {
        String redisKey = cacheName+"."+key;
        log.info(redisKey);
        redisTemplate.opsForValue().set(redisKey,value,timeToIdleSeconds, TimeUnit.SECONDS);
    }

    @SuppressWarnings("all")
    public static <T> T get(String cacheName, Object key) {
        String redisKey = cacheName+"."+key;
        Object keys= redisTemplate.opsForValue().get(redisKey);
        return (T) keys;
    }

    public static void remove(String cacheName, Object key) {
        redisTemplate.delete(cacheName+"."+key);
    }

}


