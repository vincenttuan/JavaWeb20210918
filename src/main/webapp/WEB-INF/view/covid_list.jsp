<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Covid List 列表</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">

	<form class="pure-form">
		<fieldset>
			<legend>Covid List 列表</legend>

			<table class="pure-table pure-table-bordered">
				<thead>
					<th>ID</th>
					<th>Vaccine</th>
				</thead>
				<tbody>
					<td colspan="2"> ${ covids } </td>
				</tbody>
			</table>

		</fieldset>
	</form>

</body>
</html>