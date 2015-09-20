
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>DK Stock Photos</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/shared.css"/>" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<%@ include file="/WEB-INF/views/navbar.jsp"%>
	<div class="container-fluid container">
		<%@ include file="/WEB-INF/views/alerts.jsp"%>


		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-4">
				
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Payment Details</h3>
						</div>
						<div class="panel-body">
							<form role="form">
								<div class="form-group">
									<label for="cardNumber"> CARD NUMBER</label>
									<div class="input-group">
										<input type="text" class="form-control" id="cardNumber"
											placeholder="Valid Card Number" required autofocus /> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-lock"></span></span>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-7 col-md-7">
										<div class="form-group">
											<label for="expityMonth"> EXPIRY DATE</label>
											<div class="col-xs-6 col-lg-6 pl-ziro">
												<input type="text" class="form-control" id="expityMonth"
													placeholder="MM" required />
											</div>
											<div class="col-xs-6 col-lg-6 pl-ziro">
												<input type="text" class="form-control" id="expityYear"
													placeholder="YY" required />
											</div>
										</div>
									</div>
									<div class="col-xs-5 col-md-5 pull-right">
										<div class="form-group">
											<label for="cvCode"> CV CODE</label> <input type="password"
												class="form-control" id="cvCode" placeholder="CV" required />
										</div>
									</div>
								</div>
								<input type="button" value="Complete Payment" class="btn btn-success btn-lg btn-block"/>
							</form>
						</div>
						<ul class="nav nav-pills nav-stacked">
						<li class="active"><a href="#"><span
								class="badge pull-right"><span
									class="glyphicon glyphicon-usd"></span>4200</span> Final Payment</a></li>
					</ul>
					</div>
				</div>
				<div class="col-xs-12 col-md-8"
					style="font-size: 12pt; line-height: 2em;">
					<p>
					<h1>Final Payment</h1>
					<ul>
					<li>Verify total on left</li>
						<li>Enter a valid credit card number</li>
						<li>Wait for authorization</li>
						<li>Check your account page for access to full sized image</li>
					</ul>
					</p>
					<p>All purchases are <b>non refundable.</b></p>

					
					
				</div>
				
			</div>

		</div>
		
		

	</div>
</body>
</html>