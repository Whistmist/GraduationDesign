package com.mgj.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class SystemInitListener  implements ServletContextListener
{
    /**
     * 销毁函数
     */
    public void contextDestroyed(ServletContextEvent contextEvent)
    {
    	log.info("服务停止!");
    }

    /**
     * 初始化加载
     */
    public void contextInitialized(ServletContextEvent contextEvent)
    {
        log.info("启动服务!");
    }
}
