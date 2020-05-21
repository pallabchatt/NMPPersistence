package com.tcs.nmp.dao.beans;

import java.sql.Timestamp;

public class PredictionResultBean {
	
	private Integer id;
	
	private String conversationId;
	
	private String message;
	
	private String label;
	
	private String type;
	
	private Timestamp createdTS;
	
	private String sentimentMagnitde;
	
	private String sentimentPolarity;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}

	public String getSentimentMagnitde() {
		return sentimentMagnitde;
	}

	public void setSentimentMagnitde(String sentimentMagnitde) {
		this.sentimentMagnitde = sentimentMagnitde;
	}

	public String getSentimentPolarity() {
		return sentimentPolarity;
	}

	public void setSentimentPolarity(String sentimentPolarity) {
		this.sentimentPolarity = sentimentPolarity;
	}
	
	

}
