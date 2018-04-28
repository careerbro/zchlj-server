package com.main.careerbro.common.redis;

import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class RedisServiceImpl extends AbstractRedisService<Object> {

    @Override
    protected String getRedisKey() {
        return "CSP_REDIS_KEY";
    }
}