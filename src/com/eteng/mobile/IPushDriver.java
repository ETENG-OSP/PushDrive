package com.eteng.mobile;

import com.eteng.exception.PushException;

public interface IPushDriver {

	void initialize(String appId, String privateKey);
	void pushAll(IMessage message) throws PushException;
	void pushAccount(String account, IMessage message) throws PushException;
	IMessage createMessage();

}
