package com.tcs.nmp.dao.impl;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.tcs.nmp.dao.intf.BatchResultDAO;

@Component
public class BatchJDBCTemplate implements BatchResultDAO {
	
	private static final Logger LOGGER = LogManager.getLogger(BatchJDBCTemplate.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

	@Override
	public void insert(Timestamp lastbatchRunTime, String status) {
		final String SQL = "insert into T_BATCH_MST (TBM_LAST_RUN_TS, TBM_STATUS) values (?, ?)";

		try {
			jdbcTemplateObject.update(SQL, lastbatchRunTime, status);
		} catch (DataAccessException e) {
			LOGGER.error(e);
		}
		return;

	}

	@Override
	public void getBatchResult(Integer id) {

	}

}
