<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Form</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">

	<form class="pure-form" 
		  method="get" 
		  action="${pageContext.request.contextPath}/rest/book/">
		<fieldset>
			<legend>Book Get</legend>
			<button type="submit" 
			        class="pure-button pure-button-primary">傳送</button>
		</fieldset>
	</form>
	
	<form class="pure-form" 
		  method="post" 
		  action="${pageContext.request.contextPath}/rest/book/">
		<fieldset>
			<legend>Book Post</legend>
			書號: <input type="number" name="id"><p />
			書名: <input type="text" name="name"><p />
			<button type="submit" 
			        class="pure-button pure-button-primary">傳送</button>
		</fieldset>
	</form>
	
	<form class="pure-form" 
		  method="post" 
		  action="${pageContext.request.contextPath}/rest/book/">
		<fieldset>
			<legend>Book Put</legend>
			書號: <input type="number" name="id"><p />
			書名: <input type="text" name="name"> (輸入欲修改的書名)<p />
			<input type="hidden" name="_method" value="PUT" />
			<button type="submit" 
			        class="pure-button pure-button-primary">傳送</button>
		</fieldset>
	</form>
	
	<form class="pure-form" 
		  method="post" 
		  action="${pageContext.request.contextPath}/rest/book/">
		<fieldset>
			<legend>Book Delete</legend>
			書號: <input type="number" name="id"><p />
			<input type="hidden" name="_method" value="DELETE" />
			<button type="submit" 
			        class="pure-button pure-button-primary">傳送</button>
		</fieldset>
	</form>
	
	
	
</body>
</html>