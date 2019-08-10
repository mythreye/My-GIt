<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="MyCalServlet" method="post">
		<table>
			<tr>
				<td><label>Principle</label></td>
				<td><input type="text" name="principle" id="principle"></td>
			</tr>
			<tr>
				<td><labele>Months</label></td>
				<td><input type="text" name="months" id="months"></td>
			</tr>
			<tr>
				<td><label>Type of loan</label></td>
				<td><select name="rate" id="rate">
						<option value="11">Home</option>
						<option value="8">Education</option>
						<option value="9">Vechile</option>
						<option value="8">Gold</option>

				</select>
			</tr>
			<tr>
				<td colspan="2"><input type="Submit"></td>
			</tr>

		</table>


	</form>
</body>
</html>