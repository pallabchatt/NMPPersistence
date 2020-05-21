package com.tcs.nmp.dao.beans;

import java.sql.Timestamp;

public class BatchResultBean {
	
	private Integer id;
	
	private Timestamp batchRunTime;
	
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getBatchRunTime() {
		return batchRunTime;
	}

	public void setBatchRunTime(Timestamp batchRunTime) {
		this.batchRunTime = batchRunTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
