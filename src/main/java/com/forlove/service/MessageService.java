package com.forlove.service;

import java.util.List;

import com.forlove.dao.MessageDAO;
import com.forlove.model.Message;

public class MessageService {
	private MessageDAO messageDAO = new MessageDAO();
	public List<Message> queryMessageList(String command, String description) {
		return messageDAO.queryMessageList(command, description);
	}
	
	public void deleteOne(String id) {
		messageDAO.deleteOne(id);
	}
}
