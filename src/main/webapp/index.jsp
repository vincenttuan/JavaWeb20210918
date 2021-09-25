<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	現在時刻: <%=new Date() %>
	<hr />
	<ol>
		<li><a href="./servlet/bmi?h=170&w=60">BmiServlet</a></li>
		<li><a href="./servlet/cycle?r=10">CycleServlet</a></li>
		<li><a href="./servlet/random?n=5">RandomServlet</a></li>
		<li><a href="./servlet/lotto">LottoHttpServlet</a></li>
		<li><a href="./form/bmi_form.jsp">bmi_form.jsp</a></li>
		<li><a href="./servlet/circlecalc">CircleCalcHttpServlet</a></li>
		<li><a href="./servlet/drink">DrinkHttpServlet</a></li>
	</ol>
</body>
</html>