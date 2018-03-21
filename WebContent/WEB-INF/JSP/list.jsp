<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="add" style="display: none">
		<form action="addEmp">
			姓名:<input type="text" name="ename"> 部门：<select
				name="dept.did">
				<option value="">请选择:</option>
				<c:forEach items="${dl}" var="dept" varStatus="s">
					<option value="${dept['did']}">${dept.dname}--${s.index}</option>
				</c:forEach>
			</select> <input type="submit" value="添加">
		</form>
	</div>

	<form action="list">
		<select name="dept.did">
			<option value="">请选择:</option>
			<c:forEach items="${dl}" var="dept" varStatus="s">
				<option ${empBack.dept.did==dept.did?"selected":""}
					value="${dept['did']}">${dept.dname}--${s.index}</option>
			</c:forEach>
		</select> <input type="text" value="${empBack.ename}" name="ename"> 姓名<input
			type="submit" value="选择">
	</form>
	
	<button onclick="getElementById('add').style.display='block'">
		添加</button>
		<table border="1px">
			<c:forEach items="${el}" var="emp">
				<tr>
					<td>${emp.eid}</td>
					<td>${emp.ename}</td>
					<td>${emp.dept.dname}</td>
					<td><a href="upEmp?eid=${emp.eid}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	

</body>
</html>