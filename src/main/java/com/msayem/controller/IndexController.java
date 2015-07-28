package com.msayem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msayem.jms.sender.MessageSender;

/**
 * Handles requests for the application.
 * 
 * @author MSAYEM
 * 
 */
@Controller
public class IndexController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexController() {

		logger.info("spring-jms-with-activemq: index.jsp has been executed...");
		return "index";
	}

	@RequestMapping(value = "/messageSender", method = RequestMethod.GET)
	public String jmsMessageSenderController() {

		ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/message-sender-context.xml");
		MessageSender sendMessage = (MessageSender) context.getBean("messageSenderBean");

		for(int i =1; i<=5; i++) {

			sendMessage.sendSampleOrder(i+1, i*100.00D);
		}

		((ClassPathXmlApplicationContext)context).close();

		logger.info("spring-jms-with-activemq: /messageSender has been executed...");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/messageReceiver", method = RequestMethod.GET)
	public String jmsMessageListenerController() {

		ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/message-receiver-context.xml");
		
		logger.info("spring-jms-with-activemq: /messageReceiver has been executed...");
		return "redirect:/";
	}
}