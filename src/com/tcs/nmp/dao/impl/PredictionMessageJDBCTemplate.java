package com.tcs.nmp.dao.impl;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tcs.nmp.dao.beans.PredictionResultBean;
import com.tcs.nmp.dao.intf.PredictionMessageDAOIntf;


public class PredictionMessageJDBCTemplate implements PredictionMessageDAOIntf{
	private static final Logger LOGGER = LogManager.getLogger(PredictionMessageJDBCTemplate.class);
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);		
	}

	

	@Override
	public PredictionResultBean getLastActionMessage(String conversationId) {
		final String sql ="select * from T_PREDICTION_LOG_MST  WHERE  TPLM_CONV_ID = ? AND TPLM_TYPE = 'A' ORDER BY TPLM_CREATED_TS desc LIMIT 1";
		PredictionResultBean predictionResultBean = null;
		try {
			predictionResultBean = jdbcTemplateObject.queryForObject(sql, new Object[]{ conversationId}, PredictionResultBean.class);
		} catch (DataAccessException e) {
			LOGGER.error(e);
		}
		return predictionResultBean;
		
	}

	@Override
	public void insert(PredictionResultBean predictionResultBean) {
		String sql = "insert into T_PREDICTION_LOG_MST (TPLM_CONV_ID , TPLM_MSG, TPLM_TYPE, TPLM_LABEL, TPLM_CREATED_TS, TPLM_MSG_SENTIMENT_MAGN, TPLM_MSG_SENTIMENT_POLARITY) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			jdbcTemplateObject.update(sql, predictionResultBean.getConversationId(), predictionResultBean.getMessage(), predictionResultBean.getType(), predictionResultBean.getLabel(), predictionResultBean.getCreatedTS(), predictionResultBean.getSentimentMagnitde(), predictionResultBean.getSentimentPolarity());
		} catch (DataAccessException e) {
			LOGGER.error(e);
		}	
		
	}

}
