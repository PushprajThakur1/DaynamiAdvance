<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<centre> <%
 	String fname = (String) session.getAttribute("fname");
 %> 
 <%
 	if (fname != null) {
 %>

	<h3>
		Hii,
		<%=fname%>
	</h3>
	<a href="UserListCtl.do"> User List </a>|| <a
		href="LoginCtl?operation=Logout">Logout</a>
	<hr>



	<%
		} else {
	%>
	<h3>Hii, Guest</h3>
	<hr></hr>
	<%
		}
	%>
	
</body>
</html>