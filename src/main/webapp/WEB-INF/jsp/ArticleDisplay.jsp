<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.cary.cwish.pojo.Article" %>
<div class="artsPart mainBody">
<%
	List<Article> articles = (List<Article>)request.getAttribute("articles");
	for (Article art : articles) {
%>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="col-md-1 col-md-offset-1">
					<%=art.getUserName()%>
				</div>
				<div class="col-md-8 articleTitle"><a href=""><%=art.getTitle()%></a></div>
			</div>
			<div class="row-fluid">
				<hr class="col-md-8 col-md-offset-2" />
			</div>
			<div class="row-fluid">
				<div class="col-md-8 col-md-offset-2 artText"><%=art.getText()%></div>
			</div>
			<br/>
			<div class="row-fluid">
				<div class="col-md-2 col-md-offset-10">
					<a href="">收起</a>
				</div>
			</div>
			<div class="row-fluid">
				<hr style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" color=#555666 SIZE=5 class="col-md-8 col-md-offset-2">
			</div>
			<br/>
		</div>
<%		
	}
%>
</div>