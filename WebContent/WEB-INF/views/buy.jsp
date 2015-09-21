
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Buy DK</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/shared.css"/>" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<c:url var="completePaymentAction" value="/verifyPayment"></c:url>
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
							<form role="form" action="${completePaymentAction}">
								<div class="form-group">
									<label for="cardNumber"> CARD NUMBER</label>
									<div class="input-group">
										<input type="text" class="form-control" name="cardNumber"
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
												<input type="text" class="form-control" name="expiryMonth"
													placeholder="MM" required />
											</div>
											<div class="col-xs-6 col-lg-6 pl-ziro">
												<input type="text" class="form-control" name="expiryYear"
													placeholder="YY" required />
											</div>
										</div>
									</div>
									<div class="col-xs-5 col-md-5 pull-right">
										<div class="form-group">
											<label for="cvCode"> CV CODE</label> <input type="password"
												class="form-control" name="cvCode" placeholder="CV" required />
										</div>
									</div>
								</div>
								<input type="hidden" name="total" value="${picture.price}">
								<input type="hidden" name="id" value="${picture.id}">
								<input type="submit" value="Complete Payment"
									class="btn btn-success btn-lg btn-block" />
							</form>
						</div>
						<ul class="nav nav-pills nav-stacked">
							<li class="active"><a href="#"><span
									class="badge pull-right"><span class="glyphicon"></span>${picture.fileName}</span>
									Picture</a></li>
							<li class="active"><a href="#"><span
									class="badge pull-right"><span
										class="glyphicon glyphicon-usd"></span>${picture.price}</span> Final
									Payment</a></li>

						</ul>
					</div>
				</div>
				<div class="col-xs-12 col-md-8"
					style="font-size: 12pt; line-height: 2em;">
					<p>
					<h1>Final Payment</h1>
					<ul>
						<li>Verify picture on left below the form</li>
						<li>Enter a valid credit card number</li>
						<li>Wait for authorization</li>
						<li>Check your account page for access to see full sized
							image</li>
					</ul>
					</p>
					<p>
						All purchases are <b>non refundable</b>, but if you have a
						complaint with your picture, we'll hear you out
					</p>



				</div>

			</div>

		</div>



	</div>
</body>
</html>