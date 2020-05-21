package com.tcs.nmp.dao.intf;

import java.sql.Timestamp;

import javax.sql.DataSource;

public interface FBMessageDAO {

	public void setDataSource(DataSource ds);

	public void insert(String convId, String msgId, String fromId, String toId,
			String fromName, String toName, Timestamp createdTime);

	public Integer getMessageCount(String conversationId, String messageId);

}
