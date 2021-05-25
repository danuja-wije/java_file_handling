<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="netflix.service.AdServiceImpl"%>
<%@page import="netflix.service.AdService"%>
<%@page
	import="java.io.*,java.util.*,javax.servlet.*,netflix.model.AdModel"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Insert title here</title>

<style type="text/css">
.row {
	display: flex;
	flex-wrap: wrap;
	width: 100%;
}

.column {
	flex: 33.3%;
	overflow: hidden;
	padding: 4px 4px;
	height: 100%;
}

.imgGrid img {
	width: 100%;
	height: 100%;
	max-height: 300px;
	object-fit: cover;
	min-height: 300px;
}

.details {
	position: relative;
	background: black;
	color: white;
	width: 100%;
	height: 100%;
	min-height: 200px;
	text-align: center;
	max-height: 300px;
}
.btn-box{
	display: flex;
	justify-content: center;
}
.btn-box button{
	margin: 2px 4px;
}
.btn-box button a{
	text-decoration: none;
	color: white;
}
body{
	background-image: url("styles/images/bg.jpg");
	background-repeat: no-repeat;
  	background-attachment: fixed;
  	background-size: cover;
}
</style>
</head>
<body>
	<%
		AdService adService = new AdServiceImpl();
	List<AdModel> list = new ArrayList<AdModel>();
	list = adService.allAds();
	final String thumbPath = "WebContent/Uploads/Thumbs/";
	final String path = "WebContent/Uploads/";
	%>
	<div class="container">
		<%
			int i = 0;
		while (i < list.size()) {
		%>



		<div class="row">
			<%
				if (list.size() >= i) {
			%>
			<div class="column">

				<div class="text-center imgGrid">
					<img src='Uploads/Thumbs/<%=list.get(i).getThumb()%>'
						class="rounded" alt="thumbnail">
					<div class="details">
					<h3><%=list.get(i).getAdName()%></h3>
						<%=list.get(i).getUserName()%>
						<br>
						<%=list.get(i).getCategory()%><br>
						<%=list.get(i).getPeriod()%>
						<div class="btn-box">
					<button type="button" class="btn btn-primary" ><a href="${pageContext.request.contextPath}/AdController?action=EDIT&ID=<%=list.get(i).getId()%>">Edit</a></button>
					<button type="button" class="btn btn-danger"> <a href="${pageContext.request.contextPath}/AdController?action=DELETE&ID=<%=list.get(i).getId()%>">Delete</a> </button>
					</div>
					</div>
					
				</div>
			</div>
			<%
				}
			%>
			<%
				if (list.size() > (i + 1)) {
				i++;
			%>
			<div class="column">

				<div class="text-center imgGrid">
					<img src='Uploads/Thumbs/<%=list.get(i).getThumb()%>'
						class="rounded" alt="thumbnail">
					<div class="details">
					<h3><%=list.get(i).getAdName()%></h3>
						<%=list.get(i).getUserName()%>
						<br>
						<%=list.get(i).getCategory()%><br>
						<%=list.get(i).getPeriod()%>
						<div class="btn-box">
					<button type="button" class="btn btn-primary"><a href="${pageContext.request.contextPath}/AdController?action=EDIT&ID=<%=list.get(i).getId()%>">Edit</a></button>
					<button type="button" class="btn btn-danger"><a href="${pageContext.request.contextPath}/AdController?action=DELETE&ID=<%=list.get(i).getId()%>">Delete</a></button>
					</div>
					</div>
				</div>

			</div>
			<%
				}
			%>
			<%
				if (list.size() > (i + 1)) {
				i++;
			%>
			<div class="column">

				<div class="text-center imgGrid">
					<img src='Uploads/Thumbs/<%=list.get(i).getThumb()%>'
						class="rounded" alt="thumbnail">
					<div class="details">
						<h3><%=list.get(i).getAdName()%></h3>
						<%=list.get(i).getUserName()%>
						<br>
						
						<%=list.get(i).getCategory()%><br>
						<%=list.get(i).getPeriod()%>
						<div class="btn-box">
					<button type="button" class="btn btn-primary"><a href="${pageContext.request.contextPath}/AdController?action=EDIT&ID=<%=list.get(i).getId()%>">Edit</a></button>
					<button type="button" class="btn btn-danger"><a href="${pageContext.request.contextPath}/AdController?action=DELETE&ID=<%=list.get(i).getId()%>">Delete</a></button>
					</div>
					</div>
				</div>

			</div>
			<%
				}
			;
			i++;
			%>
		</div>

		<%
			}
		%>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>