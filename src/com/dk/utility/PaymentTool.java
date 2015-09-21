package com.dk.utility;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.dk.model.CreditCard;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PaymentTool implements Serializable {

	private static final long serialVersionUID = 671099495053888450L;

	final private String HOST_NAME = "localhost";
	final private String IP = "8443";
	final private String APP_KEY = "testKey";
	final private String APP_SECRET = "testsecret";
	
	public static enum TRANSACTION_TYPE {
		AUTH, SALE, REFUND
	}
	
	
	public String processRequest(TRANSACTION_TYPE type, CreditCard cc, double total) {
		return "success";
	}

}
