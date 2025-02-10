<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.box{
		display:felx;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		top:10px;
		left:50px;
	}
</style>
<body>

<form action="/addcus" method="post" enctype="multipart/form-data">
	<div class="box">
		Enter product name:<input type="text" name="pname"><br>
		Enter product price:<input type="number" name="price"><br>
		<input type="file" name="file"><br>
		<input type="submit" value =submit>
	</div>
</form>

</body>
</html>