<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
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
	<c:url var="deleteAction" value="/deletePicture"></c:url>
	<c:url var="logoutAction" value="/logout"></c:url>
	<%@ include file="/WEB-INF/views/navbar.jsp"%>
	<div class="container-fluid container">
		<%@ include file="/WEB-INF/views/alerts.jsp"%>


		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-6">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Account Details</h3>
						</div>

						<div class="panel-body">
							<div class="panel panel-default">
								<div class="panel-body">
									<table class="table">
										<tr>
											<td>Username:</td>
											<td>${user.username}</td>
										</tr>
										<tr>
											<td>Name:</td>
											<td>${user.firstName}&nbsp;${user.lastName}</td>
										</tr>
										<tr>
											<td>Email:</td>
											<td>${user.email}</td>
										</tr>
										<tr>
											<td><a href="${logoutAction}"> <input type="submit"
													class="btn btn-primary" value="Logout" />
											</a></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-md-7"
					style="font-size: 12pt; line-height: 2em;"></div>
				<div class="row"></div>
				<div class="col-xs-12 col-md-6"
					style="font-size: 12pt; line-height: 2em;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Pictures Uploaded</h3>
						</div>

						<div class="panel-body">

							<display:table name="uploadedPictures" id="picture" pagesize="10"
								cellspacing="10" requestURI="/account" class="display-table"
								style="width:100%">
								<display:column property="fileName" title="File Name" />
								<display:column title="Price">$${picture.price} </display:column>
								<display:column>
									<a href="${deleteAction}?id=${picture.id}"> <input
										type="submit" class="btn btn-primary" value="Delete" />
									</a>
								</display:column>
							</display:table>


						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-6"
					style="font-size: 12pt; line-height: 2em;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Pictures Purchased</h3>
						</div>

						<div class="panel-body">

							<display:table name="orders" id="order" pagesize="10"
								cellspacing="10" requestURI="/account" class="display-table"
								style="width:100%">
								<display:column title="File Name">${picture.fileName}</display:column>
								<display:column>
									<img src="picture/${picture.id}/fullsize" width="214"
										height="138" />
								</display:column>

							</display:table>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>