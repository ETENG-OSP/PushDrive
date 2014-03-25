package com.eteng.mobile;

public abstract class PushDriver implements IMessage, ISender {
	
	protected abstract void initialize(String appId, String privateKey);
	
	void reset() {
		setTitle(IMessage.DEFAULT_TITLE);
		setText(IMessage.DEFAULT_TEXT);
		setExpire(IMessage.DEFAULT_TTL);
		setType(IMessage.DEFAUTL_TYPE);
	}
}