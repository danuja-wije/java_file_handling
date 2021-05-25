<%@page import="netflix.model.AdModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
	<style type="text/css">
	
	body{
	background-image: url("styles/images/bg.jpg");
	background-repeat: no-repeat;
  	background-attachment: fixed;
  	background-size: cover;
}
	
	</style>
	
</head>
<body class="container">
<%
	AdModel ad = (AdModel)request.getAttribute("ad");
	
%>

	<div class="card mb-3">
  <video class="card-img-top"  controls>
  	 <source src='Uploads/<%=ad.getPath()%>' type="video/mp4">
  </video>
  <div class="card-body">
    <h5 class="card-title"><%=ad.getAdName() %></h5>
    <p class="card-text">
    <form action="${pageContext.request.contextPath}/AdController?action=UPDATE" method="post" enctype="multipart/form-data">
    	 <input type="text" name="adname" id="adname" placeholder="<%=ad.getAdName() %>" class="form-control"><br>
        <select name="category" class="form-control">
        	<option value="<%=ad.getCategory() %>"><%=ad.getCategory() %></option>
            <option value="education">education</option>
            <option value="entertainment">entertainment</option>
            <option value="health">health care</option>
            <option value="foods">foods</option>
            <option value="others">others</option>
        </select><br>
        <select name="period" class="form-control">
        	<option value="<%=ad.getPeriod() %>"><%=ad.getPeriod() %></option>
            <option value="day">1 day</option>
            <option value="week">7 days</option>
            <option value="two-weeks">14 days</option>
            <option value="month">28 days</option>
        </select><br>
        <input type="file" name="thumbFile" id="name" accept="image/*"><br>
        <input type="file" name="file" id="name"><br>
       <center> <button type="submit" class="btn btn-dark">Update</button></center>
        <input type="text" name="id" value="<%=ad.getId()%>" hidden>
    </form>
    </p>
    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
  </div>
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