<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login Page</title>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<div class="col-lg-4 col-lg-offset-4 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2" id="logindev">
     <form class="form" method="post" action="${pageContext.request.contextPath}/loginPage/login">
       <h2>Please sign in</h2>
       <label for="inputEmail" class="sr-only">Email address</label>
       <input type="email" id="inputEmail" name="user_name" class="form-control" placeholder="Email address" required="" autofocus="">
       <label for="inputPassword" class="sr-only">Password</label>
       <input type="password" id="inputPassword" name="user_pwd" class="form-control" placeholder="Password" required="">
       <div class="checkbox">
         <label>
           <input type="checkbox" value="remember-me"> Remember me
         </label>
       </div>
       <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
     </form>
	</div>
</div> <!-- /container -->

</body>
</html>