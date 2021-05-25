<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="formStyle1" action="${pageContext.request.contextPath}/AdController" method="post" enctype="multipart/form-data">
		<input type="file" name="file" >
		<button class="Btn">confirm</button>
	</form>
</body>
</html>