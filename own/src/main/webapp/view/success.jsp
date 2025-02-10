<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.val {
	margin-top: -700px;
	margin-left: 650px;
	display: flex;
	flex-direction: column;
}
</style>
<body>
	<img src="http://localhost:8081/img/${pp.getId() }" width=600
		height=700>
	<div class="val">
		<h1>Your details are :</h1>
		<h3>Product Id :</h3>
		<strong th:text="${pp.id}"></strong><br>
		<h3>Product Name :</h3>
		${pp.getPname()}<br>
		<h3>Product Price :</h3>
		${pp.getPrice()}<br>
	</div>
</body>
</html>