package com.mgj.utils;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.File;  
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.sun.mail.util.MailSSLSocketFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtils {
	
	/**
	 * @param filename 邮件附件
	 * @param message
	 */
	public static void writeMessage(String filename, String message) {
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  		    
	        /* 写入Txt文件 */ 
			FileWriter fw = null;
			try {
				//如果文件存在，则追加内容；如果文件不存在，则创建文件
				File writename = new File(filename);
				fw = new FileWriter(writename, true);
			} catch (IOException e) {
				e.printStackTrace();
			}	      
			PrintWriter pw = new PrintWriter(fw);
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			String dateFormat = date.format(now);
			pw.println(dateFormat+" :   "+message);
			fw.flush(); // 把缓存区内容压入文件  
			fw.close(); // 最后记得关闭文件  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }
	}
	/**
	 * @param acceptEmail 收件人
	 * @param sendEmail   发件人
	 * @param filename    邮件附件
	 * @param mailHost    邮件主机
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public static void SendMail(String filename,String acceptEmail, String sendEmail, String mailHost,String authorizationCode,String theme,String mailMessage) throws GeneralSecurityException, UnsupportedEncodingException{
		// 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", mailHost);
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(sendEmail,authorizationCode); //发件人邮件用户名、密码
            }
        });
        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(sendEmail));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(acceptEmail));
            // Set Subject: 主题文字
            String subject = MimeUtility.encodeWord(theme, "UTF-8", "Q");
            message.setSubject(subject);
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            // 消息
            messageBodyPart.setText(mailMessage);
            // 创建多重消息
            Multipart multipart = new MimeMultipart();
            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);
            // 附件部分
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            String[] split = filename.split("\\\\");
            for (int i = 0; i < split.length; i++) {
            	messageBodyPart.setFileName(split[split.length-1]);
			}
            multipart.addBodyPart(messageBodyPart);
            // 发送完整消息
            message.setContent(multipart );
            //   发送消息
            Transport.send(message);
           log.info("邮件发送成功");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}
}
