<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Form</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">
	<!-- 
	1、enctype="application/x-www-form-urlencoded"
	2、enctype="multipart/form-data"
	3、enctype="text/plain"
	-->
	<form class="pure-form" enctype="multipart/form-data" method="post"
		action="${pageContext.request.contextPath}/servlet/car_upload">
		<fieldset>
			<legend>Car 輸入表單</legend>
			Name: <input type="text" placeholder="請輸入 name" name="car_name">
			<p />
			CC: <input type="number" placeholder="請輸入 cc" name="car_cc">
			<p />
			Photo: <input type="file" name="car_photo">
			<p />
			<button type="submit" class="pure-button pure-button-primary">傳送</button>
			<button type="reset" class="pure-button pure-button-primary">清除</button>
		</fieldset>
	</form>
	<p />
	Car 下載
	<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<th>index</th>
				<th>file name</th>
				<th>download</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<% if(request.getAttribute("fileNames") != null) { %>
			
				<% String[] fileNames = (String[])request.getAttribute("fileNames"); %>
			
				<% for(int i=0;i<fileNames.length;i++) { %>
				<tr>
					<td><%=i %></td>
					<td><%=fileNames[i] %></td>
					<td>
						<button type="button"
								onclick="location.href='${pageContext.request.contextPath}/servlet/car_download?car_photo=<%=fileNames[i] %>';" 
								class="pure-button">下載</button>
					</td>
					<td>
						<button type="button"
								onclick="" 
								class="pure-button">刪除</button>
					</td>
				</tr>
				<% } %>
				
			<% } %>
		</tbody>
	</table>

</body>
</html>