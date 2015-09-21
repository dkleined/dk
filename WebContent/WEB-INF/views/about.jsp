
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>About DK</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/shared.css"/>" rel="stylesheet"
	type="text/css" />

</head>
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp"%>
	<div class="container-fluid container">

		<div class="row-fluid">
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				<ul class="list-group">
					<li class="list-group-item">Take an amazing picture</li>
					<li class="list-group-item">Upload it to DK for free</li>
					<li class="list-group-item">We pay the hosting fees and
						advertise for free</li>
					<li class="list-group-item">Somebody purchases the rights to your photo</li>
					<li class="list-group-item">You get paid.</li>
				</ul>
			</div>
			<div class="col-xs-4"></div>
		</div>
	</div>

</body>
</html>