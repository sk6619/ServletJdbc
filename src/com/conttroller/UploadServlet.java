package com.conttroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 上传文件
 * @author Administrator
 *
 */
@WebServlet("/upload.do")
@MultipartConfig  //使用MultipartConfig注解标注改servlet能够接受文件上传的请求
public class UploadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//part:接受post提交的enctype=multipart/form-data属性的表单
		//part对象里本身并没有存储上传文件的名称，
		//我们需要从请求头信息里去获取文件名，
		//浏览器发送上传文件请求时将文件名存储在Request Head里的Content-Disposition里，
		//但Content-Disposition得值里除了文件名信息还有一些其他信息，
		//所以只能通过字符串截取的方式获取文件的后缀名。
		//Content-Disposition：form-data; name="file"; filename="test.txt"
		Part part  = req.getPart("myfile");
		//上传的文件名
		String name = part.getSubmittedFileName();
		System.out.println(name);
		//获取part里面的文件流
		InputStream inputStream = part.getInputStream();
		//创建服务器存放图片的路径
		String path =req.getServletContext().getRealPath("upload")+"/"+name;
		System.out.println(path);
		//创建输出流
		OutputStream outputStream = new FileOutputStream(path);
		byte[] by = new byte[1024];
		while(inputStream.read(by)!=-1) {
			outputStream.write(by);
			outputStream.flush();
		}
		inputStream.close();
		outputStream.close();
		
	}

}
