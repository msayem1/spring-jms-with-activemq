package com.msayem.jms.receiver;

import java.util.Map;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.msayem.jms.entity.SampleOrder;

@Service("messageReceiverBean")
public class MessageReceiver {

	@JmsListener(destination="amqMessageQueue")
	public void messageReceived(Map<String, Object> message) throws Exception {

		int orderId = (Integer) message.get("orderId");
		int customerId = (Integer) message.get("customerId");
		double price = (Double) message.get("price");
		String bankAccountNumber = (String) message.get("bankAccountNumber");

		SampleOrder customer = new SampleOrder(orderId, customerId, price, bankAccountNumber);

		System.out.println("MESSAGE RECEIVED - Order Id: " + orderId 
			+ ", Customer Id: "+ customerId 
			+ ", Price: "+ price);
	}
}