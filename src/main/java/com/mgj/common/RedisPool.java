package com.mgj.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisPool {
    
    @Bean( "jedis.pool")  
    @Autowired  
    public JedisPool jedisPool(@Qualifier("jedis.pool.config") JedisPoolConfig config,   
                @Value("${spring.redis.host}")String host,   
                @Value("${spring.redis.port}")int port) {  
        return new JedisPool(config, host, port);  
    }  
      
    @Bean("jedis.pool.config")  
    public JedisPoolConfig jedisPoolConfig (@Value("${spring.redis.jedis.pool.max-active}")int maxTotal,  
                                @Value("${spring.redis.jedis.pool.max-idle}")int maxIdle) {  
        JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxTotal(maxTotal);  
        config.setMaxIdle(maxIdle);  
        return config;  
    }
    
    
}
