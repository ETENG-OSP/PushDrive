package com.eteng.mobile;

import java.util.Map;

public interface IMessage {
	
	int DEFAULT_TTL = 3600;
	Type DEFAUTL_TYPE = Type.TYPE_SMS;
	String DEFAULT_TITLE = "Notification";
	String DEFAULT_TEXT = "TEXT";
	
	void setType(Type type);
	void setTitle(String title);
	void setText(String text);
	void setExtra(Map<String, Object> extra);
	void setExpire(int ttl);
	
	enum Type {
		TYPE_SMS,
		TYPE_APP
	}

}
