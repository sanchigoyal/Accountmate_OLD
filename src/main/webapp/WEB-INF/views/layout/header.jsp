<!-- List of CSS -->
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/navbar.css" rel="stylesheet">
<link href="resources/css/extra.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/formValidation.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-formhelper-min.css" rel="stylesheet">
<link href="resources/css/datepicker.css" rel="stylesheet">
<link href="resources/css/daterangepicker-bs3.css" rel="stylesheet">


<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
	  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	  </button>
	  <a class="navbar-brand" href="/Accountmate/index">Accountmate</a>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
		<ul id="leftnav" class="nav navbar-nav">
			<li class="dropdown">
				<a class="dropdown-toggle pointerCursor not-active" data-toggle="dropdown">Vouchers<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="">Sales</a></li>
					<li><a href="">Purchase</a></li>
					<li><a href="">Payment</a></li>
					<li><a href="">Receipt</a></li>
					<li><a href="">Contra</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a class="dropdown-toggle pointerCursor not-active" data-toggle="dropdown">Accounts<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="">New Account</a></li>
					<li><a href="">Accounts List</a></li>
					<li><a href="">Account Categories</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a class="dropdown-toggle pointerCursor" data-toggle="dropdown">Inventory<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="" class="not-active">New Stock Item</a></li>
					<li><a href="" class="not-active">Stock Item List</a></li>
					<li><a href="" class="not-active">Stock Item Categories</a></li>
					<li><a href="" class="not-active">Item Price List</a></li>
					<li><a href="" class="not-active">Unit of Measures</a></li>
				</ul>
			</li>
		  </ul>
		  
		  <ul class="nav navbar-nav navbar-right">
            <li><a id ="logoutnav" class="dropdown-toggle pointerCursor" data-toggle="dropdown"><i class="fa fa-user"></i></a>
            	<ul class="dropdown-menu">
					<li><a href="" class="not-active">My Profile</a></li>
					<li><a href="/Accountmate/logout">Logout</a></li>
				</ul>
            </li>
          </ul>
		  
		  <div id="businessDate" class="form-control navbar-nav navbar-right" style="cursor: pointer;width:auto;margin-top:8px;border-color:white;box-shadow:none;">
               <i class="fa fa-calendar"></i>
               <span></span> <b class="caret"></b>
               <input type="hidden" name="businessDate" value=""/>
		  </div>
		  
		  
	 </div><!--/.navbar-collapse -->
  </div>
</nav>