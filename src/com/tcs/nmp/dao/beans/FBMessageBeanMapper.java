package com.tcs.nmp.dao.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FBMessageBeanMapper implements RowMapper<FBMessageBean>{

	@Override
	public FBMessageBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		FBMessageBean fbMessageBean = new FBMessageBean();
		//fbMessageBean.setId(rs.getInt(0));
		fbMessageBean.setConversationId(rs.getString(1));
		fbMessageBean.setMessageId(rs.getString(2));
		return fbMessageBean;
	}

}
