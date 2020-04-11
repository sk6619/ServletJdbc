package com.conttroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet{

	private static final long serialVersionUID = 11L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//接受传过来的下载路径
		String downpath = req.getParameter("downpath");
		//获取文件名
		String filename = req.getParameter("filename");
		//更具文件名去查找对应的文件，此处略
		//假设文件存在
		File file = new File(req.getServletContext().getRealPath("upload")+"/"+filename);
		//创建文件流读取文件
		InputStream inputStream = new FileInputStream(file);
		//创建数组存储流读出来的数据
		byte[] b = new byte[1024];
		//创建输出流写到下载路径
		OutputStream outputStream = new FileOutputStream(downpath+"/"+filename);
		while(inputStream.read(b)!=-1) {
			outputStream.write(b);
			outputStream.flush();
		}
		inputStream.close();
		outputStream.close();
		
	}

}
