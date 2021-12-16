package com.app.mix;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageService {

	@Autowired
	private MessageDAO messageDAO;

	@Override
	public String toString() {
		return "MessageService [messageDAO=" + messageDAO + "]";
	}

}
