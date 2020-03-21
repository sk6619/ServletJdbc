package com.dao;

import java.util.List;

import com.entity.User;

/**
 * 操作user对象的接口
 * @author Administrator
 *
 */
public interface UserDao {
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> querryAllUser();
	

}
