<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet上传文件</title>
</head>
<body>
<form action="upload.do" method="post" enctype="multipart/form-data">
	<input type="file" name="myfile"/>
	<input type="submit" value="点击上传文件"/>
</form>
<br><br>
<form action="download" method="post">
	文件存储路径：<input type="text" name="downpath"/>
	文件名：<input type="text" name="filename"/>
	<input type="submit" value="点击下载文件到指定的文件夹"/>
</form>
</body>
</html>