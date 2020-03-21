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
	 * @return 返回一个装有所有用户的list
	 */
	public List<User> querryAllUser();
	

}
