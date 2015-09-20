
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>DK Stock Photos</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/shared.css"/>" rel="stylesheet"
	type="text/css" />
<style>
.container-fluid {
	background: url("resources/pictures/indexBack.jpg");
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp"%>
	<div class="container-fluid container">
		<%@ include file="/WEB-INF/views/alerts.jsp"%>
	</div>



</body>
</html>