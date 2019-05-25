package com.mgj.test;


import com.alibaba.fastjson.JSON;
import com.mgj.common.RedisClient;
import com.mgj.dao.MicroBlogDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test1 {
	 @Autowired
	 private RedisClient redisClinet;
	@Autowired
    private MicroBlogDao microBlogDao;
    @Test
	public void  get(){
        List<String> strings = microBlogDao.queryAllMicroBlogTitle();
        System.out.println(strings);
    }
	@Test
    public void getLearn() throws Exception{
		 try {
             redisClinet.set("room", JSON.toJSONString("DDD"));
     } catch (Exception e) {
         e.printStackTrace();
     }
     log.info(redisClinet.get("room"));//打印info级别的日志
    }
	
	
	
	
}
