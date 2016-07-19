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
							"</div></div>" +
							"<div class='row-fluid comments-" + art.articleId + "'></div>" +
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
		lab.text('收起评论');
	} else {
		com.html("");
		lab.text('发表评论');
	}
}

/**
 * function to handle submit comments
 */
function submitComment(articleId) {
	var comments;

	comments = $('.commentsTextArea-' + articleId).val();

	$.ajax({
		type: "GET",
		url: "submitComment",
		async: true,
		data:{
			'comments' : comments,
			'articleId' : articleId
		},
		success: function(result) {
			alert(result);
		}
	});
}