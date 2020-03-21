package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.entity.User;
import com.jdbcutils.UtilJDBC;

/**
 * userDao接口的实现类
 * @author Administrator
 *
 */
public class UserDaoimpl implements UserDao{
	
	List<User> list = new ArrayList<>();
	
	@Override
	public List<User> querryAllUser() {
		User user;
		String sql = "select id,name,age,gender from tb_test1";
		ResultSet set;
		try {
			Connection connection = UtilJDBC.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			set = statement.executeQuery();
			while(set.next()) {
				user = new User();
				user.setIdsInteger(set.getInt("id"));
				user.setNameString(set.getString("name"));
				user.setAgeInteger(set.getInt("age"));
				user.setGenderString(set.getString("gender"));
				list.add(user);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
