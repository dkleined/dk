<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<title>Gallery DK</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/shared.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/dataTables.min.css.css"/>"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp"%>
	<c:url var="buyAction" value="buy"></c:url>
	<div class="container-fluid">
		<div class="center-horizontal-align panel">

			<display:table name="pictures" id="picture" pagesize="10"
				cellspacing="10" requestURI="/gallery" class="display-table">
				<display:column property="fileName" title="File Name" />
				<display:column>
					<img src="picture/${picture.id}/thumb" width="214" height="138" />
				</display:column>
				<display:column title="Price">$${picture.price} </display:column>
				<display:column>
					<a href="${buyAction}?id=${picture.id}"> <input type="submit"
						class="btn btn-primary" value="Buy" />
					</a>
				</display:column>
			</display:table>
		</div>
	</div>
</body>
</html>