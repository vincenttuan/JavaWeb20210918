<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Circle Result</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">
	
	<form class="pure-form">
		<fieldset>
			<legend>Circle 計算結果</legend>
			${ result }
			<p />
			<button type="button"
					onclick="location.href='${pageContext.request.contextPath}/servlet/circlecalc';" 
					class="pure-button pure-button-primary">返回</button>
		</fieldset>
	</form>
	
</body>
</html>