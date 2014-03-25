package com.eteng.driver.xgpush;

import java.util.Map;

import com.eteng.mobile.IMessage;
import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.Style;

public class XGMessage implements IMessage {
	
	Message message;
	
	XGMessage() {
		message = new Message();
		message.setStyle(new Style(0, 1, 1, 1, 0));
		message.setAction(new ClickAction());
	}
	
	@Override
	public void setType(Type type) {
		switch (type) {
		case TYPE_APP:
			message.setType(Message.TYPE_MESSAGE);
			break;
			
		case TYPE_SMS:
			message.setType(Message.TYPE_NOTIFICATION);
			break;
		}
	}

	@Override
	public void setTitle(String title) {
		message.setTitle(title);
	}

	@Override
	public void setText(String text) {
		message.setContent(text);
	}
	
	@Override
	public void setExtra(Map<String, Object> extra) {
		message.setCustom(extra);
	}
	
	@Override
	public void setExpire(int ttl) {
		message.setExpireTime(ttl);
	}

	@Override
	public Object getRaw() {
		return message;
	}

}