package com.eteng.mobile;

public class MessageBuilder {
	
	IMessage message;
	String title;
	String text;
	
	MessageBuilder(IMessage message) {
		this.message = message;
	}
	
	public MessageBuilder setTitle(String title) {
		message.setTitle(title);
		return this;
	}
	
	public MessageBuilder setText(String text) {
		message.setText(text);
		return this;
	}
	
	public IMessage build() {
		return message;
	}

}
