package com.conttroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 11L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 浏览器发送上传文件请求时将文件名存储在Request Head里的Content-Disposition里，
		// 但Content-Disposition得值里除了文件名信息还有一些其他信息，
		// 所以只能通过字符串截取的方式获取文件的后缀名。
		// "Content-Disposition","attachment;filename="+filename+""
		// 获取文件名
		String filename = req.getParameter("filename");
		if (filename == "") {
			req.setAttribute("msg", "输入文件名+后缀");
			req.getRequestDispatcher("defaultError.jsp").forward(req, resp);
		}
		// 更具文件名去查找对应的文件，此处略
		// 假设文件存在
		File file = new File(req.getServletContext().getRealPath("upload"), filename);
		// 创建文件流读取文件
		InputStream inputStream = new FileInputStream(file);
		// 创建数组存储流读出来的数据
		byte[] b = new byte[1024];
		//解决中文文件名下载后乱码的问题  
		String filename1 = URLEncoder.encode(filename, "utf-8");
		// 设置Content-Disposition让浏览器自己处理下载路径
		resp.setHeader("Content-Disposition", "attachment;filename="+filename1+"");
		// 创建输出流写到下载路径
		OutputStream outputStream = resp.getOutputStream();
		while (inputStream.read(b) != -1) {
			outputStream.write(b);
			outputStream.flush();
		}
		inputStream.close();
		outputStream.close();

	}

}
