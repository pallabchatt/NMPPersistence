package com.tcs.nmp.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tcs.nmp.dao.beans.ProcessingLogResultBean;
import com.tcs.nmp.dao.beans.ProcessingLogResultBeanMapper;
import com.tcs.nmp.dao.intf.ProcessingLogMasterDAOIntf;

public class ProcessingLogJDBCTemplate implements ProcessingLogMasterDAOIntf {
	
	private static final Logger LOGGER = LogManager.getLogger(ProcessingLogJDBCTemplate.class);

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}


	@Override
	public List<ProcessingLogResultBean> getPrevInstruction(String convId) throws DataAccessException{
		final String sql = "SELECT COUNT(*) FROM t_processing_log_mst WHERE TAPLM_CONV_ID = ?  AND TAPLM_PROCESS_IND = 'N'";
		final String sqlQuery = "SELECT * FROM t_processing_log_mst WHERE TAPLM_CONV_ID = ?  AND TAPLM_PROCESS_IND = 'N'";
		List<ProcessingLogResultBean> processingLogResultBeanList = null;
		try {
			int totalRow = jdbcTemplateObject.queryForObject(sql, new Object[] {convId}, Integer.class);
			if(totalRow>0){
				processingLogResultBeanList = (List<ProcessingLogResultBean>) jdbcTemplateObject.query(
														sqlQuery, new Object[] {convId}, new ProcessingLogResultBeanMapper());
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return processingLogResultBeanList;
	}

	@Override
	public void insert(ProcessingLogResultBean processingLogResultBean)
			throws DataAccessException {
		try {
			String sqlQuery = "INSERT INTO t_processing_log_mst (TAPLM_CONV_ID, TAPLM_FROM_ID, TAPLM_CURR_INSTRUCTION, TAPLM_EXPT_INSTRUCTION, TAPLM_TRNS_IND, TAPLM_MSG, TAPLM_PROCESS_IND) values (?,?,?,?,?,?,?)";
			jdbcTemplateObject.update(sqlQuery,
					processingLogResultBean.getConversationID(),
					processingLogResultBean.getFormID(),
					processingLogResultBean.getCurrentInstruction(),
					processingLogResultBean.getExpectedInstruction(),
					processingLogResultBean.getTransIND(),
					processingLogResultBean.getMessage(),
					processingLogResultBean.getProcessIND());
		} catch (Exception de) {
			LOGGER.error(de);
		}
		
	}


	@Override
	public void updateProcessLog(ProcessingLogResultBean processingLogResultBean)
			throws DataAccessException {
		
		try {
			String sqlQuery = "UPDATE t_processing_log_mst SET  TAPLM_PROCESS_IND = 'Y' WHERE TAPLM_CONV_ID = ? AND TAPLM_ID = ?";
			jdbcTemplateObject.update(sqlQuery,
					processingLogResultBean.getConversationID(),
					processingLogResultBean.getId());
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
	}

}
