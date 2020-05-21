package com.tcs.nmp.dao.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProcessingLogResultBeanMapper implements RowMapper<ProcessingLogResultBean> {

	@Override
	public ProcessingLogResultBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProcessingLogResultBean processingLogResultBean = new ProcessingLogResultBean();
		processingLogResultBean.setId(rs.getInt(1));
		processingLogResultBean.setConversationID(rs.getString(2));
		processingLogResultBean.setFormID(rs.getString(3));
		processingLogResultBean.setCurrentInstruction(rs.getString(4));
		processingLogResultBean.setExpectedInstruction(rs.getString(5));
		processingLogResultBean.setTransIND(rs.getString(6));
		processingLogResultBean.setMessage(rs.getString(7));
		processingLogResultBean.setProcessIND(rs.getString(8));
		return processingLogResultBean;
	}

}
