package com.tcs.nmp.dao.intf;

import javax.sql.DataSource;

import com.tcs.nmp.dao.beans.PredictionResultBean;

public interface PredictionMessageDAOIntf {
	
	public void insert(PredictionResultBean predictionResultBean);

	void setDataSource(DataSource ds);

	PredictionResultBean getLastActionMessage(String conversationId);;

}
