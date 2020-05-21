package com.tcs.nmp.dao.beans;

public class ProcessingLogResultBean {
	
	private Integer id;
	
	private String conversationID;
	
	private String formID;
	
	private String currentInstruction;
	
	private String expectedInstruction;
	
	private String transIND;
	
	private String message;
	
	private String processIND;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConversationID() {
		return conversationID;
	}

	public void setConversationID(String conversationID) {
		this.conversationID = conversationID;
	}

	public String getFormID() {
		return formID;
	}

	public void setFormID(String formID) {
		this.formID = formID;
	}

	public String getCurrentInstruction() {
		return currentInstruction;
	}

	public void setCurrentInstruction(String currentInstruction) {
		this.currentInstruction = currentInstruction;
	}

	public String getExpectedInstruction() {
		return expectedInstruction;
	}

	public void setExpectedInstruction(String expectedInstruction) {
		this.expectedInstruction = expectedInstruction;
	}

	public String getTransIND() {
		return transIND;
	}

	public void setTransIND(String transIND) {
		this.transIND = transIND;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getProcessIND() {
		return processIND;
	}

	public void setProcessIND(String processIND) {
		this.processIND = processIND;
	}
	
	

}
