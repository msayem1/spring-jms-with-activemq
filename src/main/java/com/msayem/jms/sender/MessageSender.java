package com.msayem.jms.sender;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.msayem.jms.entity.SampleOrder;

@Service("messageSenderBean")
public class MessageSender {

	static int orderSequence = 1;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendSampleOrder(int customerId, double price) {

		SampleOrder order = new SampleOrder(orderSequence, 2, price, "ordercd"+ orderSequence++);
		sendMessage(order);
	}

	public void sendMessage(final SampleOrder order) {

		jmsTemplate.send(

			new MessageCreator() {

				public Message createMessage(Session session) throws JMSException {

					MapMessage mapMessage = session.createMapMessage();

					mapMessage.setInt("orderId", order.getOrderId());
					mapMessage.setInt("customerId", order.getCustomerId());
					mapMessage.setDouble("price", order.getPrice());
					mapMessage.setString("bankAccountNumber", order.getBankAccountNumber());

					return mapMessage;
				}
			}
		);
		System.out.println("MESSAGE SENT - Order Id: "+ order.getOrderId());
	}
}