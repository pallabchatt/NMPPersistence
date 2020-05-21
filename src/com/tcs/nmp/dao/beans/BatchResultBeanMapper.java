package com.tcs.nmp.dao.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;


public class BatchResultBeanMapper implements RowMapper<BatchResultBean>{

	public BatchResultBean mapRow(ResultSet rs, int rowNum) throws SQLException {
	      BatchResultBean batchResult = new BatchResultBean();
	      //batchResult.setId(rs.getInt(0));
	      batchResult.setBatchRunTime(Timestamp.valueOf(rs.getString(1)));
	      batchResult.setStatus(rs.getString(2));
	      return batchResult;
	   }
}
