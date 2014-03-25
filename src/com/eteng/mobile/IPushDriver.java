package com.eteng.mobile;

public interface IPushDriver {

	void pushAll(Object message);
	MessageBuilder createBuilder();
	void initialize(String appId, String privateKey);

}
