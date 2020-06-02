package com.demo.study.cache.utils;

import cn.hutool.Hutool;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public final class RedisUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private RedisUtils() {
    }

    //**common**

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间（秒）
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 根据key 来获取过期时间
     *
     * @param key 不能为null
     * @return 时间(秒) 返回0代表永久有效
     */
    public long getExpire(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("传入的key不能为空值");
        }
        return this.redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key值是否存在
     *
     * @param key 键
     * @return true 存在 false 不存在
     */
    public boolean hasKey(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("传入的key不能为空值");
        }
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 删除缓存
     *
     * @param key 可以传入一个，或者多个
     */
    public void del(String... key) {
        if (StrUtil.hasBlank(key)) {
            throw new RuntimeException("传入的key不能为空值");
        }
        if (key.length == 1) {
            this.redisTemplate.delete(key[0]);
        } else {
            this.redisTemplate.delete(Arrays.asList(key));
        }
    }
    //=======String=========

    /**
     * String类型的缓存获取
     *
     * @param key
     * @return
     */
    public Object getString(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("传入的key不能为空值");
        }
        return this.redisTemplate.opsForValue().get(key);
    }

    /**
     * String类型的缓存存入
     *
     * @param key   健
     * @param value 值
     * @return true-成功，false-失败，默认是true
     */
    public boolean setString(String key, Object value) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("传入的key不能为空值");
        }
        if (StringUtils.isEmpty(value)) {
            throw new RuntimeException("传入的value不能为空值");
        }
        try {
            this.redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * String类型的缓存存入,并设置缓存时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) 默认time>0 若是time<=0,则存入时间为无限期
     * @return true-成功，false-失败，默认是true
     */
    public boolean setString(String key, Object value, long time) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("传入的key不能为空值");
        }
        if (StringUtils.isEmpty(value)) {
            throw new RuntimeException("传入的value不能为空值");
        }
        try {
            if (time > 0) {
                this.redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                setString(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加及（大于0）
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return this.redisTemplate.opsForValue().increment(key, delta);
    }

    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return this.redisTemplate.opsForValue().decrement(key, delta);
    }

    //=======Map=========



}
