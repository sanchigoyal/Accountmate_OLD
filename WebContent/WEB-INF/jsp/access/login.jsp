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
    <link href="resources/css/login.css" rel="stylesheet">
	<!-- -- --- -->
	
    <div class="jumbotron">
	  <div class="container">
		<div class="row">
			<div class="col-md-6">
				<h1>Let's build your business</h1>
				<p>This is a startup that helps you build and manage your business efficiently.</p>
			</div>
			<div class="col-md-4 col-md-offset-2">
				<div id="failure" class="hideIt">
		            <div class="alert alert-danger" >
		              <button type="button" class="close" data-dismiss="alert">&times;</button>
		              <strong>Oh snap!</strong> Invalid email or password !!
		            </div>
		        </div>
				<form id="signupForm" class="form-horizontal" action="/Accountmate/signup" method="post">
					<div class="form-group">
						<div class="col-md-12">
							<input type="email" class="form-control" id="email" name="email" placeholder="Your email address">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<input type="password" class="form-control" id="password" name="password" placeholder="Create a password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<button type="submit" class="btn btn-success btn-lg btn-jumbo"> Sign up for Accountmate</button>
							<p class="text-center">By clicking "Sign up for Accountmate", you agree to our terms of service and privacy policy. We'll occasionally send you account related emails</p>
						</div>
				    </div>
				</form>
			</div>
		</div>
	  </div>
	</div>

	<div class="container">
	  <div class="row">
		<div class="col-md-4">
		  <h2>What we do?</h2>
		  <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		  <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		</div>
		<div class="col-md-4">
		  <h2>How we do?</h2>
		  <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		  <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
	   </div>
		<div class="col-md-4">
		  <h2>Why we do?</h2>
		  <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
		  <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		</div>
		<div class="col-md-12">
			<hr/>
		</div>
		<div claass="col-md-12">
			<h1 class="text-center">Our Amazing Team</h1>
		</div>
		<div class=" col-md-offset-4 col-md-4">
			<img class="img-circle img-center" src="resources/images/team/sanchi.JPG" width="200" height="200">
			<h2 class="text-center">Sanchi Goyal<br>
				<small>Lead Designer & Developer</small></h2>
			<ul class="list-inline text-center">
			  <li>
			  	<a href="https://twitter.com/" target="_blank" class="social-icon">
			  		<i class="fa fa-twitter-square fa-2x"></i>
			  	</a>
			  </li>
			  <li>
			  	<a href="https://www.linkedin.com/in/sanchi-goyal-45312761" target="_blank" class="social-icon">
			  		<i class="fa fa-linkedin-square fa-2x"></i>
			  	</a>
			  </li>
			  <li>
			  	<a href="https://www.facebook.com/sanchi.goyal.1" target="_blank" class="social-icon">
			  		<i class="fa fa-facebook-square fa-2x"></i>
			  	</a>
			  </li>
			</ul>
		</div>
	  </div>
	</div>
		
	<!-- Footer -->
    <%@include file="../layout/footer-login.jsp" %>
    <script src="resources/js/login.js"></script>
  </body>
</html>