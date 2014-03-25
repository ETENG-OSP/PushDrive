package com.eteng.mobile;

public interface IPushDriver {

	void initialize(String appId, String privateKey);
	void pushAll(IMessage message);
	IMessage createMessage();

}
