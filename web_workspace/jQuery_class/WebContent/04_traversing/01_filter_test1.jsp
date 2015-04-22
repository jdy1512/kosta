<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/jQuery_class/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("div").filter(":odd").css("background-color", "gray")
				.end().css("color", "red").css("text-decoration", "underline")
				.add("p").css("font-weight", "bold")
				.last().addClass("lightblue");// 노드에 class=lightblue를 추가
		
		// 모든 div의 밑줄, 모든 글자에 font-weight -bold
		//$("div").css("text-decoration", "underline").end("p").css("font-weight", "bold");
				
		var flag = $(".test").is("p");// 셀렉터로 조회한 노드리스트 중 p가 있나? 한개이상 있으면 true
		alert(flag);
		flag = $(".test").is("a");
		alert(flag);
	});
</script>

<style>
	div { 
		width:60px; height:60px; margin:10px;
        border:2px solid blue  ; 
	}
	.lightblue { 
		background:lightblue; color:white;
	}
</style>
</head>
 <body>
   <div>1번</div>
   <div>2번</div>
   <div>3번</div>
   <div>4번</div>
   <div>5번</div>
   <div>6번</div>
   
   <hr>
   <div class="test">가</div>
   <div class="test">나</div>
   <div class="test">다</div>
   <p class="test">라</p>
   
   
 </body>
</html>
