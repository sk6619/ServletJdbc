
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isELIgnored="false"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<table>
	<tr>
		<td>用户id</td>
		<td>用户姓名</td>
		<td>用户年龄</td>
		<td>用户性别</td>
	</tr>
	<!-- 为什么没在requst域 ？-->
	<c:forEach items="${list}" var="user">
		<tr>
			<td>${user.idsInteger}</td>
			<td>${user.nameString}</td>
			<td>${user.ageInteger}</td>
			<td>${user.genderString}</td>
		</tr>
	</c:forEach>

</table>
<br>
<a href="user">直接输出到浏览器</a>
</html>