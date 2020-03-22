package com.jdbcutils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UtilJDBC {

	// 数据库用户名
	private static String user;
	// 数据库连接地址
	private static String url;
	// 数据库驱动
	private static String driverClass;
	// 数据库密码
	private static String password;
	private static Connection connection;

	/**
	 * 加载驱动获取用户密码等
	 */
	static {
		try {
			Properties pro = new Properties();
			String pathString = UtilJDBC.class.getClassLoader().
					getResource("jdbc.properties").getPath();
			//读取数据库配置文件
			FileInputStream inStream = new FileInputStream(pathString);
			pro.load(inStream);
			inStream.close();
			user = pro.getProperty("user");
			url = pro.getProperty("url");
			driverClass = pro.getProperty("driver");
			password = pro.getProperty("password");
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取连接
	public  static Connection getConnection() throws SQLException {
		if(connection==null) {
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
	
}
