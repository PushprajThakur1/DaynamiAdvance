<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "Header.jsp" %>

	<form action= "FirstCtl "method="post">

		<table>

			<tr>
				<th>First Name :</th>
				<td><input type="text" name="First Name "></td>


			</tr>


			<tr>
				<th>Last Name :</th>
				<td><input type="text" name="Last Name "></td>

			</tr>


			<tr>
				<th>Login Id :</th>
				<td><input type="text" name="Login Id "></td>

			</tr>


			<tr>
				<th>Password :</th>
				<td><input type="password" name="password"></td>

			</tr>

			<tr>
				<th>Address :</th>
				<td><input type="text" name="Address"></td>

			</tr>

			<tr>
				<th></th>
				<td><input type="submit" value="Registration"></td>
			</tr>

		</table>
	</form>

</body>
</html>