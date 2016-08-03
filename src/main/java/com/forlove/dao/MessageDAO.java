package com.forlove.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.forlove.db.DBAccess;
import com.forlove.model.Message;

public class MessageDAO {
	public List<Message> queryMessageList(String command, String description) {
		List<Message> messageList = new ArrayList<Message>();
		DBAccess dbAccess = new DBAccess();
		
		try {
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			
			SqlSession sqlSession = dbAccess.getSqlSession();
			messageList = sqlSession.selectList("Message.queryMessageList", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return messageList;
	}
	
	public void deleteOne(String id) {
		DBAccess dbAccess = new DBAccess();
		
		try {
			SqlSession sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBatch(List<String> ids) {
		DBAccess dbAccess = new DBAccess();
		
		try {
			SqlSession sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch", ids);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
