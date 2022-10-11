/**
 * 
 메인 메뉴 JS
 */
 
 
$(document).ready(function(
){
	$(".header").on("click", ".search-toggle",function(e) {
		  var selector = $(this).data("selector");
	
		  $(selector).toggleClass("show").find(".search-input").focus();
		  $(this).toggleClass("active");
	
		  e.preventDefault();
		});
});


/* 로고 페이퍼 */

/* $(document).ready(function() {
	$(".flag").lettering();
}); */