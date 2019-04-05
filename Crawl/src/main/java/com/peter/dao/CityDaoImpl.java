package com.peter.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.peter.bean.City;

import cn.itcast.jdbc.TxQueryRunner;

public class CityDaoImpl {
	private TxQueryRunner runner=new TxQueryRunner();
	public int insert(City city)
	{
		final String sql="insert into city values(null,?,?,?,?,?)";
		Object[] params= {city.getName(),city.getUrl(),city.getLetter(),city.getJobType(),city.getProvince()};
		try {
			return runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<City> findAll()
	{
		final String sql="select * from city";
		try {
			return runner.query(sql, new BeanListHandler<City>(City.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
