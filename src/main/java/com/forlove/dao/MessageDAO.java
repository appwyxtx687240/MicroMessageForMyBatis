package com.forlove.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.forlove.model.Message;

public class MessageDAO {
	public List<Message> queryMessageList(String command, String description) {
		List<Message> messageList = new ArrayList<Message>();
		try {
			Reader reader = Resources.getResourceAsReader("com/forlove/config/config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			messageList = sqlSession.selectList("Message.queryMessageList", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return messageList;
	}
//	public List<Message> queryMessageList(String command, String description) {
//		List<Message> messageList = new ArrayList<Message>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql:///mybatis?useSSL=false&characterEncoding=utf-8&useEncoding=utf-8", "root", "root");
//			StringBuilder sql = new StringBuilder("select ID, COMMAND, DESCRIPTION, CONTENT from message where 1=1");
//
//			List<String> params = new ArrayList<String>();
//			if (command != null && !"".equals(command.trim())) {
//				sql.append(" and COMMAND=?");
//				params.add(command);
//			}
//			
//			if (description != null && !"".equals(description.trim())) {
//				sql.append(" and description like '%' ? '%'");
//				params.add(description);
//			}
//			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
//
//			if (params != null && params.size()>0) {
//				for (int i = 0; i < params.size(); i++) {
//					preparedStatement.setString(i+1, params.get(i));
//				}
//			}
//			
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while(resultSet.next()){
//				Message message = new Message();
//				message.setId(resultSet.getInt("ID"));
//				message.setCommand(resultSet.getString("COMMAND"));
//				message.setDescription(resultSet.getString("DESCRIPTION"));
//				message.setContent(resultSet.getString("CONTENT"));
//				messageList.add(message);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return messageList;
//	}
}
