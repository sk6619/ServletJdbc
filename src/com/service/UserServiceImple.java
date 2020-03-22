package com.service;

import java.util.List;

import com.dao.UserDao;
import com.dao.UserDaoimpl;
import com.entity.User;

public class UserServiceImple  implements UserService{

	//注册一个userdao
	UserDao userdao = new UserDaoimpl();
	
	@Override
	public List<User> seleUsers() {
		
		
		return userdao.querryAllUser();
	}

}
