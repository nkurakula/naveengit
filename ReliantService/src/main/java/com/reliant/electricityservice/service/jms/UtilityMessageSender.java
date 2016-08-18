package com.reliant.electricityservice.service.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Bootcamp User 017
 * Process the message to the ActiveMQ queue
 */
@Service
public class UtilityMessageSender {
	
	
	@Autowired
	private JmsTemplate jmsTemplate;	
	
	/**
	 * Sends the message to the queue
	 * @param message
	 */
	public void sendMessage(final String message) throws JMSException {
		
	    jmsTemplate.send(new MessageCreator(){  

			@Override
			public Message createMessage(Session session) throws JMSException {
				
				return session.createTextMessage(message);  
			}  
	    });  
	}

}
