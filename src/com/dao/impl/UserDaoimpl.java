package com.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.dao.UserDao;
import com.entity.User;
import com.jdbcutils.UtilJDBC;
import com.mysql.cj.protocol.Resultset;

/**
 * userDao接口的实现类
 * @author Administrator
 *
 */
public class UserDaoimpl implements UserDao{
	
	User user = new User();

	@Override
	public Resultset querryAllUser() {
		try {
			Connection connection = UtilJDBC.getConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
