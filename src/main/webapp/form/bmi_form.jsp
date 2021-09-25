<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI Form</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">
	
	<form class="pure-form" method="post" action="${pageContext.request.contextPath}/servlet/bmicalc">
		<fieldset>
			<legend>BMI 輸入表單</legend>
			身高: <input type="number" placeholder="請輸入身高" name="height"><p />
			體重: <input type="number" placeholder="請輸入體重" name="weight"><p />
			<button type="submit" class="pure-button pure-button-primary">傳送</button>
			<button type="reset" class="pure-button pure-button-primary">清除</button>
		</fieldset>
	</form>
	
</body>
</html>