package com.xyk.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {
	@Autowired
	JavaMailSenderImpl mailSender;

	@Test
	public void contextLoads() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage ();

		simpleMailMessage.setSubject ("通知-今晚开会");
		simpleMailMessage.setText ("今晚7:30开会");

		simpleMailMessage.setTo ("m15618975413@163.com");
		simpleMailMessage.setFrom ("a1016086297@qq.com");
		mailSender.send (simpleMailMessage);
	}

	@Test
	public void test02() throws Exception{
		//1.c创建一个复杂的消息邮件
		MimeMessage mimeMessage = mailSender.createMimeMessage ();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper (mimeMessage, true);

		//标题 内容
		mimeMessageHelper.setSubject ("通知-哈哈哈");
		mimeMessageHelper.setText ("<b style='color:red'>今晚7:30开会</b>",true);
		//接收方  发送方
		mimeMessageHelper.setTo ("m15618975413@163.com");
		mimeMessageHelper.setFrom ("a1016086297@qq.com");

		//上传文件
		mimeMessageHelper.addAttachment ("1.jpg",new File ("D:\\1.jpg"));
		mimeMessageHelper.addAttachment ("2.jpg",new File ("D:\\2.jpg"));

		mailSender.send (mimeMessage);
	}

}
