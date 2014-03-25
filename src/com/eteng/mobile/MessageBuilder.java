package com.eteng.mobile;

public abstract class MessageBuilder {
	
	String title;
	String text;

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}
	
	public MessageBuilder setTitle(String title) {
		return this;
	}
	
	public MessageBuilder setText(String text) {
		return this;
	}
	
	public abstract Object build();

}
