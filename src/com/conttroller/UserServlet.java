package com.conttroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.entity.User;
import com.service.UserService;
import com.service.UserServiceImple;

@WebServlet("/user")
public class UserServlet extends HttpServlet{
	
	UserService userService = new UserServiceImple();

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//建立一个list接收数据库返回的数据
		List<User> list = new ArrayList<>();
		list = userService.seleUsers();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getIdsInteger());
		}
		req.setAttribute("userlist", list);
		req.getRequestDispatcher("/WEB-INF/user.html").forward(req, resp);
	}
	
}
