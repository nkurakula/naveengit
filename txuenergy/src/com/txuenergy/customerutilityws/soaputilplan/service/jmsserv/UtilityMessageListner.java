package com.txuenergy.customerutilityws.soaputilplan.service.jmsserv;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.txuenergy.customerutilityws.soaputilplan.dao.customer.CustomerDAO;

@Service
public class UtilityMessageListner implements MessageListener {

	@Override
	public void onMessage(Message m) {

		TextMessage message = (TextMessage) m;
		try {
		String msg = message.getText();
		
		String[] input= msg.split(" ");
		int sId	 = Integer.parseInt(input[0]);
		int cid = Integer.parseInt(input[1]);
		
		CustomerDAO.updateCustomerDetails(cid,sId);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
