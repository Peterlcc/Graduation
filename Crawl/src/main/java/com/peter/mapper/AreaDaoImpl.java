package com.peter.dao;

import java.sql.SQLException;

import com.peter.bean.Area;

import cn.itcast.jdbc.TxQueryRunner;

public class AreaDaoImpl {
	private TxQueryRunner runner=new TxQueryRunner();
	public int insert(Area area)
	{
		final String sql="insert into area values(null,?,?,?,?)";
		Object[] params= {area.getUrl(),area.getName(),area.getJobType(),area.getCity().getId()};
		try {
			return runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
