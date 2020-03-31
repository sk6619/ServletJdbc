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


@WebServlet("/index")
public class UserJspServlet extends HttpServlet{
	
	UserService uService = new UserServiceImple();

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list = new ArrayList<>();
		list = uService.seleUsers();
		req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
