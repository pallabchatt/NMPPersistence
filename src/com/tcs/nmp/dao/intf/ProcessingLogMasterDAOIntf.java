package com.tcs.nmp.dao.intf;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;

import com.tcs.nmp.dao.beans.ProcessingLogResultBean;

public interface ProcessingLogMasterDAOIntf {
	
	public void setDataSource(DataSource ds);
	
	public List<ProcessingLogResultBean> getPrevInstruction(String convId) throws DataAccessException;

	public void insert(ProcessingLogResultBean processingLogResultBean) throws DataAccessException;
	
	public void updateProcessLog(ProcessingLogResultBean processingLogResultBean) throws DataAccessException;

}
