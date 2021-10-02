<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Form</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">
	<!-- 
	1、enctype="application/x-www-form-urlencoded"
	2、enctype="multipart/form-data"
	3、enctype="text/plain"
	-->
	<form class="pure-form"
		  enctype="application/x-www-form-urlencoded"
		  method="post" 
		  action="${pageContext.request.contextPath}/servlet/car">
		<fieldset>
			<legend>Car 輸入表單</legend>
			Name: <input type="text" placeholder="請輸入 name" name="car_name"><p />
			CC: <input type="number" placeholder="請輸入 cc" name="car_cc"><p />
			<button type="submit" class="pure-button pure-button-primary">傳送</button>
			<button type="reset" class="pure-button pure-button-primary">清除</button>
		</fieldset>
	</form>
	
</body>
</html>