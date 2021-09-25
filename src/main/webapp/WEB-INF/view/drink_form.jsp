<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drink Form</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">
	
	<form class="pure-form" method="post" action="${pageContext.request.contextPath}/servlet/drink">
		<fieldset>
			<legend>Drink 訂單</legend>
			品名: 
			<select name="id">
				<option id="1">珍奶</option>
				<option id="2">咖啡</option>
				<option id="3">綠茶</option>
			</select>
			<p />
			數量: 
			<input type="number" name="amount"><p />
			<button type="submit" class="pure-button pure-button-primary">訂購</button>
			<button type="reset" class="pure-button pure-button-primary">清除</button>
		</fieldset>
	</form>
	
	${ result }
	
	
</body>
</html>