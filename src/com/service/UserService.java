package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	
	/**
	 * 查询所有用户
	 * @return 返回装有所有用户的list
	 */
	public List<User> seleUsers();

}
