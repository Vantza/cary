<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.cary.cwish.pojo.Article" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Welcome to Cary's wish</title>
		<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
		<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
		<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
		<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
		<link href="../CSS/Common.css" rel="stylesheet" media="screen" type="text/css" />
		<script type="text/javascript" src="../JS/Articles.js"></script>
	</head>
	<body>

		<jsp:include page="Header.jsp"></jsp:include>

		<jsp:include page="ArticleDisplay.jsp"></jsp:include>

	</body>
</html>