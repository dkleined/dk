<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Account DK</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/shared.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/dataTables.min.css.css"/>"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<c:url var="uploadAction" value="/upload"></c:url>
	<%@ include file="/WEB-INF/views/navbar.jsp"%>
	<div class="container-fluid container">
		<%@ include file="/WEB-INF/views/alerts.jsp"%>


		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-5"></div>
				<div class="col-xs-12 col-md-7"
					style="font-size: 12pt; line-height: 2em;"></div>

			</div>

		</div>



	</div>

</body>
</html>