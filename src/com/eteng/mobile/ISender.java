package com.eteng.mobile;

import com.eteng.exception.PushException;

public interface ISender {

	void pushAll() throws PushException;
	void pushAccount(String account) throws PushException;
	void pushGroup(String group) throws PushException;

}
