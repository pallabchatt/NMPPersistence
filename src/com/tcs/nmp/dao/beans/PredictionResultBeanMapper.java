package com.tcs.nmp.dao.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

public class PredictionResultBeanMapper implements RowMapper<PredictionResultBean>{

	@Override
	public PredictionResultBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		PredictionResultBean predictionResultBean = new PredictionResultBean();
		//predictionResultBean.setId(rs.getInt(0));
		predictionResultBean.setConversationId(rs.getString(1));
		predictionResultBean.setMessage(rs.getString(2));
		predictionResultBean.setType(rs.getString(3));
		predictionResultBean.setLabel(rs.getString(4));
		predictionResultBean.setCreatedTS(Timestamp.valueOf(rs.getString(5)));
		predictionResultBean.setSentimentMagnitde(rs.getString(6));
		predictionResultBean.setSentimentPolarity(rs.getString(7));
		return predictionResultBean;
	}

}
