<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addEmp">
<input type="text" name="ename" value="${emp.ename}">
<input type="hidden" name="eid" value="${emp.eid}"> 
<select name="dept.did">
<option value="">请选择:</option>
<c:forEach items="${dl}" var="dept">
<option ${emp.dept.did==dept.did?"selected":""} value="${dept.did}">${dept.dname}</option>
</c:forEach>
</select>
<input type="submit" value="确认修改">
</form>
</body>
</html>