<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Principle</th>
			<th>Intrest</th>
			<th>Emi</th>
		</tr>
		<c:foreach item="${detail}" var="a">
		<tr>
		<td>${a.princple}</td>
				<td>${a.intrest}</td>
						<td>${a.emi}</td>
		</tr>
		</c:foreach>
	</table>
</body>
</html>