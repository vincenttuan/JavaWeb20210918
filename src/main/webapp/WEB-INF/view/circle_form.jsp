<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Circle Form</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">
	
	<form class="pure-form" method="post" action="${pageContext.request.contextPath}/servlet/circlecalc">
		<fieldset>
			<legend>Circle 計算表單</legend>
			半徑: <input type="number" placeholder="請輸入半徑" name="radius"><p />
			<input type="checkbox" name="item" value="A"> 直徑 <br />
			<input type="checkbox" name="item" value="B"> 圓周 <br />
			<input type="checkbox" name="item" value="C"> 面積 <br />
			<input type="checkbox" name="item" value="D"> 體積 <p />
			<button type="submit" class="pure-button pure-button-primary">計算</button>
			<button type="reset" class="pure-button pure-button-primary">清除</button>
		</fieldset>
	</form>
	
	
	
</body>
</html>