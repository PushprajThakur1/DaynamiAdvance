<%@page import="in.com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<form action="UserCtl.do" method="post">
		<td><input type="hidden" name="Id" value=<%=bean.getId()%>></td>
		<table>
			<tr>
				<th>first Name</th>
				<td><input type="text" name="firstName"
					value="<%=bean.getFirstname()%>"></td>
			</tr>

			<tr>
				<th>last Name</th>
				<td><input type="text" name="lastName"
					value="<%bean.getLastname();%>"></td>
			</tr>

			<tr>
				<th>Login Id</th>
				<td><input type="text" name="loginId"
					value="<%=bean.getLoginid()%>"></td>
			</tr>

			<tr>
				<th>password</th>
				<td><input type="password" name="password"
					value="<%=bean.getPassword()%>"></td>
			</tr>

			<tr>
				<th>address</th>
				<td><input type="text" name="address"
					value="<%=bean.getAddress()%>"></td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" name="Opertion" value="Update"></td>
			</tr>

		</table>
</body>
</html>