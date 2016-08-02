$(function(){
	getArtsInfo();
});


function collapse(id) {
	// alert(id);
	var text = '.artText-' + id,
		collapseId = '.collapse-' + id;
	$(text).toggle();
	if ($(collapseId).text() == '收起') {
		$(collapseId).html('显示全部');	
	} else {
		$(collapseId).html('收起');
	}
}

function setArticles(arts) {
	var articles = arts.articles,
		outstr = "<div class='container-fluid artEach'>";
	$.each(articles, function (i, art) {
		outstr = outstr +	"<div class='row-fluid'>" +
								"<div class='col-md-1 col-md-offset-1'>" +
									art.userName +
								"</div>" +
								"<div class='col-md-8'><a href=''>" + art.title + "</a></div>" +
							"</div>" +
							"<div class='row-fluid'>" +
								"<hr class='col-md-8 col-md-offset-2' />" +
							"</div>" +
							"<div class='row-fluid'>" +
								"<div class='col-md-8 col-md-offset-2 artText-" + art.articleId + "'>" + art.text + "</div>" +
							"</div></br>" +
							"<div class='row-fluid'><div class='col-md-4 col-md-offset-8'>" +
								"<a onclick='comments(" + art.articleId + ")' class='commentLabel-" + art.articleId + "'>发表评论</a>" +
								"&nbsp;&nbsp;&nbsp;" +
								"<a onclick='collapse(" + art.articleId + ")' class='collapse-" + art.articleId + "'>收起</a>" +
								"&nbsp;&nbsp;&nbsp;" +
								"<a onclick='showComments(" + art.articleId + ")' class='commentDisplayLabel-" + art.articleId + "'>查看评论</a>" +
							"</div></div>" +
							"<div class='row-fluid comments-" + art.articleId + "'></div>" +
							"<div class='row-fluid commentsDisplay-" + art.articleId + "'></div>" +
							"<div class='row-fluid'><hr style='FILTER: alpha(opacity=100,finishopacity=0,style=3)' color=#555666 SIZE=5 class='col-md-8 col-md-offset-2'></div></br>"
	});
	outstr = outstr + "</div>"
	$('.artsPart').html(outstr);
}

/**
 * function to get home page articles by ajax
 */
function getArtsInfo() {
	var arts;
	$.ajax({
		type: "GET",
		url: "homeArticles",
		async: true,
		success: function(result) {
			// alert(result);
			arts = eval('(' + result + ')');
			setArticles(arts);
		}
	});
}

/**
 * function to handle comments issues.
 */
function comments(articleId) {
	var comments = '.comments-' + articleId,
		label = '.commentLabel-' + articleId,
		outstr = "<div class='col-md-8 col-md-offset-2'>",
		com = $(comments),
		lab = $(label);

	if (com.html() == "") {
		outstr = outstr + 	"<hr class='col-md-8'>" +
							"<div class='row-fluid'>" +
								"<textarea rows=2 class='col-md-8 commentsTextArea-" + articleId + "'></textarea>" +
							"</div>" +
							"<div><button type='button' class='btn btn-default' onclick='submitComment(" + articleId + ")'>提交评论</button></div>"

		outstr = outstr + "</div>"
		com.html(outstr);
		lab.text('取消发表');
	} else {
		com.html("");
		lab.text('发表评论');
	}
}

/**
 * function to handle submit comments
 */
function submitComment(articleId) {
	var comments,
		account;

	comments = $('.commentsTextArea-' + articleId).val();

	account = getCookie('account');

	if (comments==null || comments==undefined || comments=='') {
		alert('comment 不能为空！');
	}

	if (account!=null && account!=undefined && account!='') {
		$.ajax({
			type: "GET",
			url: "submitComment",
			async: true,
			data:{
				'comments' : comments,
				'articleId' : articleId
			},
			success: function(result) {
				// show comment which exsits
				showComments(articleId);
				// hide comment div
				$('.comments-' + articleId).html("");
				$('.commentLabel-' + articleId).text('发表评论');
			}
		});
	} else {
		alert('请先登录再发表评论！');
	}
}

/**
 * get cookie
 */
function getCookie(name) { 
    var arr,reg = new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr = document.cookie.match(reg))
 
        return unescape(arr[2]); 
    else 
        return null; 
}

/**
 * show comments of articles
 */
function showComments(articleId) {
	var outstr = "<div class='col-md-8 col-md-offset-2'><div class='col-md-10 col-md-offset-1'>",
		comdis = $('.commentsDisplay-' + articleId),
		com = $('.comments-' + articleId),
		label = $('.commentDisplayLabel-' + articleId),
		coms;

	coms = listArticleComments(articleId);

	if (comdis.html()!='' && comdis.html()!=undefined && comdis.html()!=null && com.html()=='') {
		comdis.html("");
		label.text('查看评论');
	} else {
		$.each(coms.comments, function (i, com) {
			outstr = outstr +	"<hr/>" +
								"<div class='row-fluid'>" +
									"<div class='col-md-2'>" + com.userName + "</div>" +
									"<div class='col-md-8'>" + com.text + "</div><br/>" +
								"</div>"
		});

		outstr = outstr + "</div></div>";

		comdis.html(outstr);
		label.text('收起评论');
	}
	
}

/**
 * This method is to get article method by ajax
 */
function listArticleComments(articleId) {
	var coms;
	$.ajax({
		type: "GET",
		url: "listArticleComments",
		data: {
			'articleId' : articleId
		},
		async: false,
		success: function(result) {
			coms = eval('(' + result + ')');
		}
	});
	return coms;
}