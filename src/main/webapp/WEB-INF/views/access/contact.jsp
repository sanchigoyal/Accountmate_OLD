<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<link rel="icon" href="resources/images/logo/favicon.ico">
    <title>Accountmate</title>
  </head>

  <body>
	<%
	if(session.getAttribute("USERID") != null){%>
		<%@include file="../layout/header.jsp" %>
	<%
	}else{%>
		<%@include file="../layout/header-login.jsp" %>
	<%	
	}
	
	%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<br/>
				<div class="panel panel-default">
				  <div class="panel-heading">
				  	<h4><i class="fa fa-lg fa-map-marker extraPaddingLeftRight5"></i>Location</h4>
				  </div>
				  <div class="panel-body">
				    <div id="map-container" style="height:300px;"></div>
				  </div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
				  <div class="panel-heading">
				  	<h4><i class="fa fa-lg fa-suitcase extraPaddingLeftRight5"></i>Our office</h4>
				  </div>
				  <div class="panel-body">
				    <address>
					  <strong>Accountmate, Inc.</strong><br>
					  Kundanhalli Gate<br>
					  Bangalore - 37, India<br>
					  <i class="fa fa-mobile-phone"></i> (+91) 90021-72084
					</address>

					<address>
					  <strong>Sanchi Goyal</strong><br>
					  <a href="mailto:sanchi_goyal@yahoo.in">sanchi.goyal.sg@gmail.com</a>
					</address>
				  </div>
				</div>
				<div class="panel panel-default">
				  <div class="panel-heading">
				  	<h4><i class="fa fa-lg fa-clock-o extraPaddingLeftRight5"></i>Business hours</h4>
				  </div>
				  <div class="panel-body">
				    <strong>9AM - 2PM IST</strong><br/>
					<strong>3PM - 7PM IST</strong>
				  </div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="panel panel-default">
				  <div class="panel-heading">
				  	<h4><i class="fa fa-lg fa-envelope-o extraPaddingLeftRight5"></i>Feel free to contact us</h4>
				  </div>
				  <div class="panel-body">
				    <form id="contactForm" class="form-horizontal" method="post" action="">
						<div class="form-group form-group-sm required">
							<label for="contactname" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-5">
								<input id="contactname" name="contactname" type="text" class="form-control" placeholder="Enter Name..."/>
							</div>
						</div>
						<div class="form-group form-group-sm required">
							<label for="email" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-5">
								<input id="email" name="email" type="email" class="form-control" placeholder="Enter Email..."/>
							</div>
						</div>
						<div class="form-group form-group-sm required">
							<label for="message" class="col-sm-2 control-label">Message</label>
							<div class="col-sm-5">
								<textarea id="message" name="message" class="form-control" rows="4" placeholder="Enter Message..."></textarea>
							</div>
						</div>
						<div class="form-group form-group-sm">
							<label for="knowme" class="col-sm-2 control-label">How did you hear about Accountmate ?</label>
							<div class="col-sm-5">
								<select id="knowme" name="knowme" class="form-control">
									<option value="1">Web Search</option>
									<option value="2">Facebook Ad</option>
									<option value="3">Friends</option>
									<option value="4">An Invoice I Received</option>
								</select>
							</div>
						</div>
						<div class="form-group form-group-sm">
							<div class="col-sm-5 col-sm-offset-2">
								<button class="btn btn-primary" type="submit">Submit</button>
								<button class="btn btn-default" type="reset">Reset</button>
							</div>
						</div>
					</form>
				  </div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
    <%
	if(session.getAttribute("USERID") != null){%>
		<%@include file="../layout/footer.jsp" %>
	<%
	}else{%>
		<%@include file="../layout/footer-login.jsp" %>
	<%	
	}
	
	%>
	<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script src="resources/js/contact.js"></script>
  </body>
</html>