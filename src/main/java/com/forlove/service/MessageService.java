package com.forlove.service;

import java.util.List;

import com.forlove.dao.MessageDAO;
import com.forlove.model.Message;

public class MessageService {
	public List<Message> queryMessageList(String command, String description) {
		MessageDAO messageDAO = new MessageDAO();
		return messageDAO.queryMessageList(command, description);
	}
}
