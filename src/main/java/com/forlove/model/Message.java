package com.forlove.model;

public class Message {

	/**
	 * 消息id
	 */
	private Integer id;
	/**
	 * 消息指令
	 */
	private String command;
	/**
	 * 消息描述
	 */
	private String description;
	/**
	 * 消息内容
	 */
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
