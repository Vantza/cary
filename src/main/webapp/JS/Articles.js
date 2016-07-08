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
								"<a onclick='comments(" + art.articleId + ")' class='comments-" + art.articleId + "'>发表评论</a>" +
								"&nbsp;&nbsp;&nbsp;" +
								"<a onclick='collapse(" + art.articleId + ")' class='collapse-" + art.articleId + "'>收起</a>" +
							"</div></div>" +
							"<div class='row-fluid'><hr style='FILTER: alpha(opacity=100,finishopacity=0,style=3)' color=#555666 SIZE=5 class='col-md-8 col-md-offset-2'></div></br>"
	});
	outstr = outstr + "</div>"
	$('.artsPart').html(outstr);
}

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