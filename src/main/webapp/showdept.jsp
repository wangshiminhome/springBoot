<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>部门地址</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${list }" var="d">
			<tr>
				<td>${d.deptno }</td>
				<td>${d.dname }</td>
				<td>${d.loc }</td>
				<td><a href="preupdatedept.do?deptno=${d.deptno }">修改</a></td>
				<td><a href="deletedept.do?deptno=${d.deptno }">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				<c:if test="${info.isFirstPage==true }">
					首页上一页
				</c:if>
				<c:if test="${info.isFirstPage!=true }">
					<a href="findalldept.do?pagenow=${info.firstPage }">首页</a>
					<a href="findalldept.do?pagenow=${info.prePage }">上一页</a>
				</c:if>
				<c:if test="${info.isLastPage==true }">
					下一页尾页
				</c:if>
				<c:if test="${info.isLastPage!=true }">
					<a href="findalldept.do?pagenow=${info.nextPage }">下一页</a>
					<a href="findalldept.do?pagenow=${info.lastPage }">尾页</a>
				</c:if>
			</td>
		</tr>
	</table>
	<a href="savedept.jsp">添加部门</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="findallemp.do">职员信息管理</a>
</body>
</html>