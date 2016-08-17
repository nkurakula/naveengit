package com.reliant.electricityservice.service.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UtilityMessageSender {
	
	
	@Autowired
	private JmsTemplate jmsTemplate;	
	
	public void sendMessage(final String message) {
		
	    jmsTemplate.send(new MessageCreator(){  

			@Override
			public Message createMessage(Session session) throws JMSException {
				
				return session.createTextMessage(message);  
			}  
	    });  
	}

}
