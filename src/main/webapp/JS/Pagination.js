$(function(){
	getPageInfo();
});

var totalpage,
	cpage = 1;

function getPageInfo() {
	var totalCount;
	$.ajax({
		type: "GET",
		url: "pageInfo",
		async: true,
		success: function(result) {
			alert(result);
			totalCount = eval('(' + result + ')').artCount;
			totalpage = Math.ceil(totalCount/10);
			setpage();
		}
	});
}

function getCurrentPageArticles(currentPage) {
	$.ajax({
		type: "GET",
		url: "currentPageArts",
		async: true,
		data: {
			'currentPage' : currentPage
		},
		success: function(data) {
			alert(data);
			var obj = eval('(' + data + ')');
			setPageArts(obj);
		}
	});
}

function setpage() {
	var outstr = "";

    if (totalpage<=10) {        //总页数小于十页
        for (count=1; count<=totalpage; count++) {
        	if(count!=cpage) {
            	outstr = outstr + "<li><a href='javascript:void(0)' onclick='gotopage(" + count + ")'>" + count + "</a></li>";
            } else {
                outstr = outstr + "<li class='active'><a href='javascript:void(0)'>" + count + "</a></li>"; 
            }
        }
    }
    if (totalpage>10) {        //总页数大于十页
        if (parseInt((cpage-1)/10) == 0) {             
            for (count=1;count<=10;count++) {   
            	if (count!=cpage) { 
                    outstr = outstr + "<li><a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a></li>"; 
                } else { 
                    outstr = outstr + "<li class='active'><a href='javascript:void(0)'>" + count + "</a></li>"; 
                } 
            }
            outstr = outstr + "<li><a href='javascript:void(0)' onclick='gotopage("+count+")'>&raquo;</a></li>";
        } 
        else if (parseInt((cpage-1)/10) == parseInt(totalpage/10)) {
            outstr = outstr + "<li><a href='javascript:void(0)' onclick='gotopage("+(parseInt((cpage-1)/10)*10)+")'>&laquo;</a></li>";
            for (count=parseInt(totalpage/10)*10+1;count<=totalpage;count++) {   
            	if (count!=cpage) { 
                    outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a>"; 
                } else { 
                    outstr = outstr + "<span class='current'>"+count+"</span>"; 
                } 
            } 
        } 
        else 
        {     
            outstr = outstr + "<li><a href='javascript:void(0)' onclick='gotopage("+(parseInt((cpage-1)/10)*10)+")'>&laquo;</a></li>";
            for (count=parseInt((cpage-1)/10)*10+1;count<=parseInt((cpage-1)/10)*10+10;count++) {         
                if (count != cpage) { 
                    outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage(" + count + ")'>" + count + "</a>"; 
                } else { 
                    outstr = outstr + "<span class='current'>" + count + "</span>"; 
                }
            } 
            outstr = outstr + "<li><a href='javascript:void(0)' onclick='gotopage(" + count + ")'>&raquo;</a></li>";
        } 
    }     
    $(".pagination").html(outstr);
    outstr = "";
}

function gotopage(target) {
	cpage = target;
	getCurrentPageArticles(target);
	setpage();
}

function setPageArts(obj) {
	var artsPart = "",
		arts = obj.currentArticles;

	// It's confused that I can not use 'for(var art in arts)' here.
	// Once I use 'for in', art always get '0' instead of a Object. 
	for (var i=0; i<arts.length; i++) {
		artsPart = artsPart + 	"<div class='container-fluid'>" +
									"<div class='row-fluid'>" +
										"<div class='col-md-8 col-md-offset-2'><a href='javascript:void(0)'>" +
											arts[i].title +
										"</a></div>" +
									"</div>" +
									"<div class='row-fluid'><hr class='col-md-8 col-md-offset-2' /></div>" +
								  	"<div class='row-fluid'>" +
								  		"<div class='col-md-8 col-md-offset-2'>" +
								  			arts[i].text +
								  		"</div>" +
								  	"</div>" +
								  	"<div class='row-fluid'><hr style='FILTER: alpha(opacity=100,finishopacity=0,style=3)' color=#555666 SIZE=5 class='col-md-8 col-md-offset-2'></div><br/>" +
								"</div>"
	}

	$(".artsPart").html(artsPart);
}