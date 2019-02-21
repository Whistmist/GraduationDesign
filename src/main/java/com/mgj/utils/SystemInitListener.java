package com.mgj.utils;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class SystemInitListener  implements ServletContextListener
{
	@Value("${filename}")  
	private String filename; 
	@Value("${acceptEmail}")  
	private String acceptEmail;
	@Value("${sendEmail}")  
	private String sendEmail;
	@Value("${mailHost}")  
	private String mailHost;
	@Value("${authorizationCode}")  
	private String authorizationCode;
	@Value("${theme}")  
	private String theme;
	@Value("${mailMessage}")  
	private String mailMessage;
    /**
     * 销毁函数
     */
    public void contextDestroyed(ServletContextEvent contextEvent)
    {
    	try {
    		CommonUtils.writeMessage(filename, "服务停止!");
			CommonUtils.SendMail(filename,acceptEmail, sendEmail, mailHost, authorizationCode, theme, mailMessage);
		} catch (Exception e) {			
			e.printStackTrace();
			log.info("服务出错!");
		}
    	log.info("服务停止!");
    }

    /**
     * 初始化加载
     */
    public void contextInitialized(ServletContextEvent contextEvent)
    {
    	CommonUtils.writeMessage(filename, "启动服务!");
        log.info("启动服务!");
    }
}
