<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="container-fluid topHeader">
	<div class="row-fluid" position: fixed;top: 0px;>
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						 <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand">WISH</a>
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
							<%  if (request.getAttribute("page") == "HomePage") { %>
								<li class="active">
							<%  } else { %>
								<li>
							<% 	} %>
									<a href="${pageContext.request.contextPath}/home/">主页</a>
								</li>
							<%  if (request.getAttribute("page") == "WritePage") { %>
								<li class="active">
							<%  } else { %>
								<li>
							<% 	} %>
									<a href="${pageContext.request.contextPath}/write/">写字</a>
								</li>
							<%  if (request.getAttribute("page") == "UserArticlePage") { %>
								<li class="active">
							<%  } else { %>
								<li>
							<% 	} %>
									<a href="${pageContext.request.contextPath}/userArticle/">个人文章</a>
								</li>
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">下拉菜单<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="#">下拉导航1</a>
										</li>
										<li>
											<a href="#">下拉导航2</a>
										</li>
										<li>
											<a href="#">其他</a>
										</li>
										<li class="divider">
										</li>
										<li class="nav-header">
											标签
										</li>
										<li>
											<a href="#">链接1</a>
										</li>
										<li>
											<a href="#">链接2</a>
										</li>
									</ul>
								</li>
							</ul>
							<ul class="nav pull-right">
								<li>
									<%
										if (request.getCookies() != null){
											for (Cookie c : request.getCookies()) {
												if (c.getName().equals("account")) {
									%>
													<a href=""><%=c.getValue() %></a>
									<%
												}
											}
										}
									%>
								</li>
								<li class="divider-vertical">
								</li>
								<li class="dropdown">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">选项<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="${pageContext.request.contextPath}/loginPage/logOut">log out</a>
										</li>
										<li>
											<a href="${pageContext.request.contextPath}/loginPage/">log in</a>
										</li>
										<li>
											<a href="#">其他</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="#">链接3</a>
										</li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>