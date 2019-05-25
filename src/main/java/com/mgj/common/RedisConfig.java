package com.mgj.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Configuration  
@EnableAutoConfiguration  
public class RedisConfig {
 
    @Value("${spring.redis.host}")
    private String host;
 
    @Value("${spring.redis.port}")
    private int port;
 
    @Value("${spring.redis.timeout}")
    private int timeout;
 
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
 
    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;
 
    @Value("${spring.redis.password}")
    private String password;
      
    @Bean  
    public JedisPoolConfig getRedisConfig(){  
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        return config;
    }  
      
    @SuppressWarnings("deprecation")
	@Bean  
    public JedisConnectionFactory getConnectionFactory(){  
        JedisConnectionFactory factory = new JedisConnectionFactory();  
        JedisPoolConfig config = getRedisConfig();  
        factory.setPassword(password);
        factory.setHostName(host);
        factory.setPassword(password);
        factory.setTimeout(timeout);
        log.info("JedisConnectionFactory bean init success.");  
        return factory;  
    }  
      
      
    @Bean  
    public RedisTemplate<?, ?> getRedisTemplate(){
        return new StringRedisTemplate(getConnectionFactory());
    }
}
