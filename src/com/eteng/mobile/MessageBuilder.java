package com.eteng.mobile;

import com.eteng.mobile.IMessage.Type;

public class MessageBuilder {
	
	IMessage message;
	
	MessageBuilder(IMessage message) {
		this.message = message;
		reset();
	}
	
	private void reset() {
		setTitle(IMessage.DEFAULT_TITLE);
		setText(IMessage.DEFAULT_TEXT);
		setExpire(IMessage.DEFAULT_TTL);
		setType(IMessage.DEFAUTL_TYPE);
	}
	
	public MessageBuilder setType(Type type) {
		message.setType(type);
		return this;
	}

	public MessageBuilder setTitle(String title) {
		message.setTitle(title);
		return this;
	}
	
	public MessageBuilder setText(String text) {
		message.setText(text);
		return this;
	}
	
	public MessageBuilder setExpire(int ttl) {
		message.setExpire(ttl);
		return this;
	}
	
	public IMessage build() {
		return message;
	}

}
