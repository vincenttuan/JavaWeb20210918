<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COVID Form</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">
	
	<form class="pure-form" method="post" action="${pageContext.request.contextPath}/servlet/covid/append">
		<fieldset>
			<legend>COVID 意願表單</legend>
			證號: <input type="text" placeholder="請輸入身分證號" name="id"><p />
			疫苗: <input type="text" placeholder="請輸入疫苗簡稱" name="vaccine"><p />
			<button type="submit" class="pure-button pure-button-primary">傳送</button>
			<button type="button" class="pure-button pure-button-primary">查詢</button>
		</fieldset>
	</form>
	
</body>
</html>