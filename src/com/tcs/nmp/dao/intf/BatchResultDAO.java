package com.tcs.nmp.dao.intf;

import java.sql.Timestamp;

import javax.sql.DataSource;

public interface BatchResultDAO {
	
	public void setDataSource(DataSource ds);
	
	public void insert(Timestamp lastbatchRunTime , String status);
	
	public void getBatchResult(Integer id);	
}
