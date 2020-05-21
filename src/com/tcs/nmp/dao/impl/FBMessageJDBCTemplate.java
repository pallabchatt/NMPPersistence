package com.tcs.nmp.dao.impl;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tcs.nmp.dao.intf.FBMessageDAO;


public class FBMessageJDBCTemplate implements FBMessageDAO{
	
	private static final Logger LOGGER = LogManager.getLogger(FBMessageJDBCTemplate.class);
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);		
	}

	@Override
	public void insert(String convId, String msgId, String fromId, String toId,
			String fromName, String toName, Timestamp createdTime) {
		final String SQL = "insert into T_FBMSG_TRACKER_MST (TFTM_CONV_ID , TFTM_MSG_ID, TFTM_FROM_ID, TFTM_TO_ID, TFTM_FROM_NAME, TFTM_TO_NAME, TFTM_CREATED_TS) values (?, ?, ?, ?, ?, ?, ?)";

		try {
			jdbcTemplateObject.update(SQL, convId, msgId, fromId,toId, fromName, toName, createdTime);
		} catch (DataAccessException e) {
			LOGGER.error(e);
		}		
	}

	@Override
	public Integer getMessageCount(String conversationId, String messageId) {
		final String SQL ="SELECT COUNT(*) FROM T_FBMSG_TRACKER_MST WHERE TFTM_CONV_ID = ? AND TFTM_MSG_ID = ?";
		int count = 0;
		try {
			count = jdbcTemplateObject.queryForObject(SQL, new Object[]{ conversationId, messageId}, Integer.class);
		} catch (DataAccessException e) {
			LOGGER.error(e);
		}
		return count;
		
	}

}
