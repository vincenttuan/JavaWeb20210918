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
			<button type="submit" 
			        class="pure-button pure-button-primary">傳送</button>
		</fieldset>
	</form>
	
	<form class="pure-form" 
		  method="post" 
		  action="${pageContext.request.contextPath}/rest/book/">
		<fieldset>
			<legend>Book Put</legend>
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
			<input type="hidden" name="_method" value="DELETE" />
			<button type="submit" 
			        class="pure-button pure-button-primary">傳送</button>
		</fieldset>
	</form>
	
	
	
</body>
</html>