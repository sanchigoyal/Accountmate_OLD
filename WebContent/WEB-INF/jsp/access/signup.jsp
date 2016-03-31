<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<link rel="icon" href="resources/images/logo/favicon.ico">
    <title>Accountmate</title>
  </head>

  <body>
  
	<!-- Header -->
    <%@include file="../layout/header-login.jsp" %>
	<!-- -- --- -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-center">
					   <b>BUILD</b> YOUR PROFILE <br>
					   <small>This information will let us know more about you.</small>
					</h3>
				</div>
				<div class="col-md-12">
					<form class="form-horizontal" action="/Accountmate/register" id="registrationForm" method="post" enctype="multipart/form-data">
						<ul class="nav nav-pills wizard-pills">
							<li class="active"><a href="#about" data-toggle="tab" class="not-active">About</a></li>
							<li><a href="#account" data-toggle="tab" class="not-active">Account</a></li>
							<li><a href="#settings" data-toggle="tab" class="not-active">Settings</a></li>
						</ul>
					
						<div class="tab-content">
							<div class="tab-pane active wizard-content" id="about" style="min-height:350px;">
								<h4 class="text-center"> Let's start with the basic information</h4>
								<div class="col-sm-4 col-sm-offset-1 picture-container">
									<div class="picture">
										<img src="resources/images/others/default-avatar.png" class="picture-src" id="wizardPicturePreview">
										<input type="file" id="wizard-picture" name="uploadimage">
									</div>
								</div>
								<div class="col-sm-6">
									<div class="required form-group-sm form-group">
									   <label for="firstname" class="control-label">First Name</label>
									   <input type="text" id="firstname" name="firstName" class="form-control input-sm" placeholder="Enter First Name..."/>
									 </div>
									 <div class="required form-group form-group-sm">
									   <label for="lastname" class="control-label">Last Name</label>
									  <input type="text" id="lastname" name="lastName" class="form-control input-sm" placeholder="Enter Last Name..."/>
									 </div>
								</div>
								<div class="col-sm-10 col-sm-offset-1">
									<div class="required form-group form-group-sm">
									   <label for="email" class="control-label">Email</label>
									   <input id ="email" type="email" class="form-control input-sm" name="email" placeholder="Enter Email... " value="${user.email}"/>
									 </div>
								</div>
								<div class="col-sm-4 col-sm-offset-1">
									<div class="required form-group form-group-sm">
									   <label for="password" class="control-label">Password</label>
									   <input type="password" class="form-control input-sm" id="password" name="password" placeholder="Enter Password..." value="${user.password}"/>
									 </div>
								</div>
								<div class="col-sm-offset-2 col-sm-4">
									<div class="required form-group form-group-sm">
									   <label for="repassword" class="control-label">Re-Enter Password</label>
									   <input type="password" class="form-control input-sm"  name="repassword" placeholder="Re-Enter Password...">
									 </div>
								</div>					
							</div>
							<div class="tab-pane" id="account" style="min-height:350px;">
								<h4 class="text-center"> Let's create your first company</h4>
								<div class="col-sm-10 col-sm-offset-1">
									<div class="required form-group form-group-sm">
										<label for="companyname" class="control-label">Company</label>
										<input type="text" class="form-control input-sm" id="companyname" name="companyName" placeholder="Enter Company/Business Name... "/>
									</div>
								</div>
								<div class="col-sm-5 col-sm-offset-1">
									<div class="form-group form-group-sm">
										<label for="phonenumber" class="control-label">Phone Number</label>
										<input type="text" class="form-control input-sm" id="phonenumber" name="phoneNumber" placeholder="Enter Phone Number... "/>
									</div>
								</div>
								<div class="col-sm-10 col-sm-offset-1">
									<div class="required form-group form-group-sm">
										<label for="address" class="control-label">Street/Building</label>
										<input type="text" class="form-control input-sm"  id="address" name="address" placeholder="Enter Street/Building... "/>
									</div>
								</div>
								<div class="col-sm-5 col-sm-offset-1">
									<div class="form-group">
										<label for="country" class="control-label">Country</label>
										<div id="countries_states2" class="bfh-selectbox bfh-countries bfh-small" data-country="IN" data-name="country" data-blank="false">
										</div>
									</div>
								</div>
								<div class="col-sm-5">
									<div class="required form-group">
										<label for="state" class="control-label">State</label>
										<div class="bfh-selectbox bfh-states bfh-small" data-country="countries_states2" data-state='AN' data-name="state" data-blank="false">
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane" id="settings" style="min-height:350px;">
								<h4 class="text-center"> Let's set your configuration</h4>
								<div class="col-sm-4">
									<div class="form-group form-group-sm">
										<label for="itemWiseDiscont" class="control-label col-sm-8" style="padding-top:0px;">Item-wise discount</label>
										<div class="col-sm-4">
											<input id="itemWiseDiscount" name="itemWiseDiscount" class="form-control on-off" type="checkbox" data-size="mini" data-off-color="warning">
										</div>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="form-group form-group-sm">
										<label for="itemWiseVat" class="control-label col-sm-8" style="padding-top:0px;">Item-wise VAT</label>
										<div class="col-sm-4">
											<input id="itemWiseVat" class="form-control on-off" name="itemWiseVat" type="checkbox" data-size="mini" data-off-color="warning">
										</div>
									</div>
								</div>
								<div class="col-sm-12">
									<p class="text-center">Rest options will be coming soon!!</p>
								</div>
							</div>
							
							<div class="col-md-12">
								<!-- Previous/Next buttons -->
								<ul class="pager wizard">
									<li class="previous"><a href="javascript: void(0);">Previous</a></li>
									<li class="next"><a href="javascript: void(0);">Next</a></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	<!-- Footer -->
    <%@include file="../layout/footer-login.jsp" %>
    <script src="resources/js/signup-min.js"></script>
  </body>
</html>