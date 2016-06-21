<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>This is the write page</title>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../JS/Header.js"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-md-8 col-md-offset-2">
			<form action="" method="post" role="form">
		        <input type="text" class="form-control" id="title" name="title" placeholder="请输入标题" required="">
				<textarea name="editor"></textarea>
				<script type="text/javascript">CKEDITOR.replace('editor');</script>
				<br/>
				<input type="button" value="Submit" class="btn btn-primary" onclick="onSubmit();" />
			</form>
			<script type="text/javascript">
				function onSubmit(){
					// check if the title is empty
					if (!jQuery.isEmptyObject($('#title').val())) {
						// Blow is important if CKEditor in form.
						for ( instance in CKEDITOR.instances ) 
							CKEDITOR.instances[instance].updateElement(); 
						document.forms[0].action="${pageContext.request.contextPath}/write/submit";
						document.forms[0].submit();
					}
				}
			</script>
		</div>
	</div>
</div>
</body>
</html>