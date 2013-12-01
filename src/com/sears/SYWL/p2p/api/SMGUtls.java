package com.sears.SYWL.p2p.api;

import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;
import com.twilio.sdk.resource.list.SmsList;

public class SMGUtls {
	public static final String ACCOUNT_SID="AC1aa594d3c7d73455520a46dd25cc1e4f";
	public static final String AUTH_TOKEN="0ff4c935cb3af32421a8f4169645da1c";
	public static final String FROM_NUMBER="+17247848027";
	
	public static void sendMessage(String to, String body) throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		 
	    // Build a filter for the SmsList
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("Body", body);
	    params.put("To", to);
	    params.put("From", FROM_NUMBER);
	 
	    SmsFactory messageFactory = client.getAccount().getSmsFactory();
	    Sms message = messageFactory.create(params);
	    System.out.println(message.getSid());
	}
	
	public static void main(String[] args) throws TwilioRestException {
		sendMessage("+14128011600", "Cao ni ma");
	}
}
