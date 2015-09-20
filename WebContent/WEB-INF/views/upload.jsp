<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Upload DK</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/shared.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<c:url var="uploadAction" value="/upload"></c:url>
	<%@ include file="/WEB-INF/views/navbar.jsp"%>
	<div class="container-fluid container">
		<%@ include file="/WEB-INF/views/alerts.jsp"%>


		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-5">

					<div class="panel panel-default" style="width: auto">
						<div class="panel-heading">
							<h3 class="panel-title">Photo Details</h3>
						</div>
						<div class="panel-body">
							<form method="post" action="${uploadAction}"
								enctype="multipart/form-data">

								<div class="panel panel-default">
									<div class="panel-heading">
										<h3 class="panel-title">Upload a photo.</h3>
									</div>
									<div class="panel-body">
										<table class="table">
											<tr>
												<td>Picture:</td>
												<td><input type="file" name="picture" required /></td>
											</tr>
											<tr>
												<td>Price:</td>
												<td><input name="price" type="number" min="0.00"
													step="0.01" max="2500" value="19.99" required /></td>
											</tr>
											<tr>
												<td><input type="submit" value="Upload"
													class="btn btn-primary" /></td>
											</tr>
										</table>
									</div>
								</div>
							</form>
						</div>
						<ul class="nav nav-pills nav-stacked">

						</ul>
					</div>
				</div>
				<div class="col-xs-12 col-md-7"
					style="font-size: 12pt; line-height: 2em;">
					<p>
					
					<h1>Description</h1>
					<ul>
						<li>
							<p>Choose your photo and choose your price.</p>
						</li>
						<li><p>
								You can remove pictures from the gallery at any time in your
								user profile.
							</p></li>
					</ul>
					<h1>Requirements</h1>
					<ul>
						<li>Must be <b>high definition</b></li>
						<li>Must be jpg format</li>
					</ul>


				</div>

			</div>

		</div>



	</div>

</body>