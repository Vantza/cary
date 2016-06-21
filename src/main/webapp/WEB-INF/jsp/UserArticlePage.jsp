<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.cary.cwish.pojo.Article" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>This is your articles.</title>
		<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
		<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
		<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
		<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	</head>
	<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<%
		List<Article> articles = (List<Article>)request.getAttribute("articles");
		for (Article art : articles) {
	%>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="col-md-8 col-md-offset-2"><a href=""><%=art.getTitle()%></a></div>
				</div>
				<div class="row-fluid">
					<hr class="col-md-8 col-md-offset-2" />
				</div>
				<div class="row-fluid">
					<div class="col-md-8 col-md-offset-2"><%=art.getText()%></div>
				</div>
				<br/>
				<div class="row-fluid">
					<hr style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" color=#555666 SIZE=5 class="col-md-8 col-md-offset-2">
				</div>
				<br/>
			</div>
	<%		
		}
	%>


	</body>
</html>