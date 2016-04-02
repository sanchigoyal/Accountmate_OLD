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
    <%@include file="../layout/header-simple.jsp" %>
	<!-- -- --- -->
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<img class="img-center" src="resources/images/logo/Logo.JPG" width="100" height="100"/>
				<h3 class="text-center">Sign in to Accountmate</h3>
				<br/>
			</div>
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
				  <div class="panel-body">
				    <div id="failure" class="hideIt">
			            <div class="alert alert-danger" >
			              <button type="button" class="close" data-dismiss="alert">&times;</button>
			              <strong>Oh snap!</strong> ${message}
			            </div>
			        </div>
	   				<form id="loginForm" class="form-horizontal" action="/AccountmateWS2/login" method="post">
						<div class="col-md-12">
							<div class="form-group required">
								<label class="control-label" for="email">Email</label>
								<input type="email" class="form-control" id="email" name="email" placeholder="Enter email address...">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group required">
								<label class="control-label" for="password">Password</label>
								<input type="password" class="form-control" id="password" name="password" placeholder="Enter password...">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<p><a class="not-active">Forgot your password?</a></p>
							</div>
						</div> 
						<div class="col-md-12">
							<div class="form-group">
								<button type="submit" class="btn btn-success btn-jumbo"> Sign In</button>
							</div>
							<div class="form-group">
								<a data-toggle="modal" href="/Accountmate/signup" class="btn btn-primary btn-jumbo">Sign Up</a>
							</div>
						</div>
					</form>
				  </div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
    <%@include file="../layout/footer-login.jsp" %>
    <script>
    if ("${success}" == "false"){
    	document.getElementById("failure").style.display = "block";
    }
    else{		
    	document.getElementById("failure").style.display = "none";
    }
    </script>
  </body>
</html>