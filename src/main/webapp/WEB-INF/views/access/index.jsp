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
    <link href="resources/css/index.css" rel="stylesheet">
	<!-- -- --- -->
	
    <div class="jumbotron jumbotron-bg-dark">
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
		              <strong>Oh snap!</strong> ${message}
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
		  <p>With a team of experience professionals and a suite of sophisticated electronic platforms,we give our client ways to strategize, track and store their daily business activities. Moreover we also provide a 24/7 support for our client's queries. </p>
		</div>
		<div class="col-md-4">
		  <h2>How we do?</h2>
		  <p>We bring in IT professionals and Business Analyst from all over India to develop electronic platforms using state of the art technologies to be available on mobile, tablet and PCs.In addition to this we also interact with our clients and include their suggestions as well. </p>
	   </div>
		<div class="col-md-4">
		  <h2>Why we do?</h2>
		  <p>Helping others has always been our top priority here at Accountmate. Looking at the difficulties faced with other accounting software we thought of coming up with a better solution to make lives of our client better.</p>
		</div>
		<div class="col-md-12">
			<hr/>
		</div>
		<div class="col-md-12">
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
	<script>
		if ("${success}" == "false"){
			document.getElementById("failure").style.display = "block";
		}
		else{		
			document.getElementById("failure").style.display = "none";
		}
	</script>	
	<!-- Footer -->
    <%@include file="../layout/footer-login.jsp" %>
    <script src="resources/js/index.js"></script>

  </body>
</html>