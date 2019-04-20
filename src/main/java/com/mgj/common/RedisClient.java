package com.mgj.common;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Component
public class RedisClient {
	@Autowired  
    private JedisPool jedisPool;  
      
    public void set(String key, String value) throws Exception {  
        Jedis jedis = null;  
        try {  
            jedis = jedisPool.getResource();  
            jedis.set(key, value);  
        } finally {  
            //返还到连接池  
            jedis.close();  
        }  
    }  
      
    public String get(String key) throws Exception  {  
  
        Jedis jedis = null;  
        try {  
            jedis = jedisPool.getResource();  
            return jedis.get(key);  
        } finally {  
            //返还到连接池  
            jedis.close();  
        }  
    }  
      
    public void setobj(String key, Object value) throws Exception {  
        Jedis jedis = null;  
        try {  
            Set<Object> set = new HashSet<Object>();
            set.add(value);
            jedis = jedisPool.getResource();  
            jedis.sadd(key, String.valueOf(set));
        } finally {  
            //返还到连接池  
            jedis.close();  
        }  
        
    }
    /**
     * 设置有效期
     * @param key
     * @param exTime
     * @return
     */
    public Long expire(String key,int exTime){
        Jedis jedis = null;
        try {
        	jedis = jedisPool.getResource();  
        	return jedis.expire(key,exTime);
        }finally {  
            //返还到连接池  
            jedis.close();  
        }  
    }
    //exTime的单位是秒
    public String setEx(String key,String value,int exTime){
        Jedis jedis = null;
        try {
        	jedis = jedisPool.getResource();  
        	return jedis.setex(key,exTime,value);
        }finally {  
            //返还到连接池  
            jedis.close();  
        }  
    }
    public Long del(String key){
        Jedis jedis = null;
        try {
        	jedis = jedisPool.getResource();  
        	return jedis.del(key);
        }finally {  
            //返还到连接池  
            jedis.close();  
        }  
    }
}
