
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Login DK</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/shared.css"/>" rel="stylesheet"
	type="text/css" />

<style>
</style>
<%@ include file="/WEB-INF/views/navbar.jsp"%>
</head>
<body>
	<c:url var="loginAction" value="login"></c:url>
	<c:url var="registerAction" value="register"></c:url>

	<div class="container-fluid" id="loginModal">


		<div class="modal-body modal-sm row-fluid">
			<div class="modal-header well">
				<h3>Have an Account?</h3>
			</div>
			<div class="well">
				<%@ include file="/WEB-INF/views/alerts.jsp"%>
				<ul class="nav nav-tabs">
					<li class="active"><a href="#login" data-toggle="tab">Login</a></li>
					<li><a href="#create" data-toggle="tab">Create Account</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane active in" id="login">
						<form:form action="${loginAction}" commandName="user">
							<fieldset>
								<div class="control-group">
									<!-- Username -->
									<form:label path="username">
										<spring:message text="Username" />
									</form:label>
									<div class="controls">
										<form:input path="username" class="form-control" />
									</div>
								</div>

								<div class="control-group">
									<!-- Password-->
									<label class="control-label" for="password">Password</label>
									<div class="controls">
										<input type="password" id="password" name="password"
											class="form-control">
									</div>
								</div>

								<input type="hidden" value="${target}" name="target" />
								<div class="control-group">
									<!-- Button -->
									<div class="controls">
										<input type="submit" class="btn btn-lg btn-primary btn-block"
											style="padding: 20x 200px;" value="Login" />
									</div>
								</div>
							</fieldset>
						</form:form>
					</div>
					<div class="tab-pane fade" id="create">
						<form:form action="${registerAction}" commandName="user" method="post" enctype="multipart/form-data">
							<fieldset>
								<div class="control-group">
									<!-- Username -->
									<form:label path="username">
										<spring:message text="Username" />
									</form:label>
									<div class="controls">
										<form:input path="username" class="form-control" />
									</div>
								</div>

								<div class="control-group">
									<!-- Password-->
									<label class="control-label" for="firstName">First Name</label>
									<div class="controls">
										<input id="firstName" name="firstName" class="form-control" required>
									</div>
								</div>

								<div class="control-group">
									<!-- Password-->
									<label class="control-label" for="lastName">Last Name</label>
									<div class="controls">
										<input id="lastName" name="lastName" class="form-control" required>
									</div>
								</div>

								<div class="control-group">
									<!-- Password-->
									<label class="control-label" for="email">Email</label>
									<div class="controls">
										<input id="email" name="email" class="form-control" required>
									</div>
								</div>

								<div class="control-group">
									<!-- Password-->
									<label class="control-label" for="password">Password</label>
									<div class="controls">
										<input type="password" id="password" name="password"
											class="form-control" required>
									</div>
								</div>

								<input type="hidden" value="${target}" name="target" />
								<div class="control-group">
									<!-- Button -->
									<div class="controls">
										<input type="submit" class="btn btn-lg btn-primary btn-block"
											style="padding: 20x 200px;" value="Register" required />
									</div>
								</div>

							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<script class="cssdeck"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script class="cssdeck"
	src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>