package com.eteng.driver.xgpush;


import com.eteng.mobile.MessageBuilder;
import com.tencent.xinge.Message;

public class XGMessageBuilder extends MessageBuilder {

	@Override
	public Object build() {
		Message message = new Message();
		message.setTitle(this.getTitle());
		message.setContent(this.getText());
		return message;
	}

}
