<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI Result</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">
	
	<form class="pure-form">
		<fieldset>
			<legend>BMI 計算結果</legend>
			<!-- 顯示 bmi 變數資料 -->
			${ bmi }
			<p />
			<button type="button"
					onclick="location.href='${pageContext.request.contextPath}/form/bmi_form.jsp';" 
					class="pure-button pure-button-primary">返回</button>
		</fieldset>
	</form>
	
</body>
</html>