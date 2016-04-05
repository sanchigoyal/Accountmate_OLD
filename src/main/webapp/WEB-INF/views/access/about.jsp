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
				<h1>About Us...</h1>
			</div>
			<div class="col-md-12">
				<h3>What we do?</h3>
				<p>With a team of experience professionals and a suite of sophisticated electronic platforms,we give our client ways to strategize, track and store their daily business activities. Moreover we also provide a 24/7 support for our client's queries. </p>
			</div>
			<div class="col-md-12">
				<h3>How we do?</h3>
				<p>We bring in IT professionals and Business Analyst from all over India to develop electronic platforms using state of the art technologies to be available on mobile, tablet and PCs.In addition to this we also interact with our clients and include their suggestions as well. </p>
			</div>
			<div class="col-md-12">
				<h3>Why we do?</h3>
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
  </body>
</html>