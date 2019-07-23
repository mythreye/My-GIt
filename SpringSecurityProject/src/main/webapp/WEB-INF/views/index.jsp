<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>SpotLight</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>First Smile</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div style="min-height: 620px">
		<c:if test="${indexPage}">
			<jsp:include page="slider.jsp" />
		</c:if>
		<c:if test="${aboutusPage}">
			<jsp:include page="aboutus.jsp" />
		</c:if>
		<c:if test="${loginPage}">
			<jsp:include page="login.jsp" />
		</c:if>
		<c:if test="${contactusPage}">
			<jsp:include page="contactus.jsp" />
		</c:if>
		<c:if test="${registerPage}">
			<jsp:include page="register.jsp" />
		</c:if>
		<c:if test="${addjob}">
			<jsp:include page="addjob.jsp" />
		</c:if>
		<c:if test="${viewjob}">
			<jsp:include page="viewAllJob.jsp" />
		</c:if>
		<c:if test="${viewonejob}">
		<jsp:include page="viewoneJob.jsp"></jsp:include>
		</c:if>
		
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>