package com.bootcampjava.electricityservice.services.jms;

public class JmsSender {
	
	public static void send(){
		
		UtilityMessageSender msgsender = new UtilityMessageSender();
		
		System.out.println("Inside JMS Send");
		
		msgsender.sendMessage("hello jms3");

	}
}
