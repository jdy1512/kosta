<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="/jQuery_class/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#chk").bind("click", function(){
				alert("체크박스 클릭");
			});
			$("#btn").click(function(){
				alert("버튼이 클릭됨");
			});
			$("#chk").on("click", function(){
				// event 처리 함수에서 event 소스(DOM객체)에 접근 - this
				if (this.checked) { // 클릭이 발생한 DOM 객체(checkbox) - jQuery 객체가 아니라 DOM노드 객체
					alert("메일을 수신합니다.");
				} else {
					alert("메일을 수신 하지 않습니다.");
				}
			});
			$("a").on("mouseover", function(){// 링크에 마우스포인터가 올라가면
				$(this).css("text-decoration", "underline");
			});
			$("a").on("mouseout", function(){// 링크에 마우스포인터가 벗어나면
				$(this).css("text-decoration", "none");
			});
			
			$("li").hover(function(){
				$(this).css("text-decoration", "underline");
			}, function(){
				$(this).css("text-decoration", "none");
			});
			
			$("a").on("click", {message:"정말 이동할래요?"}, function(evt){// evt : event객체가 할당
				// 링크로 이동할지 여부를 물어본다.
				var flag = confirm(evt.data.message);//"정말 이동하시겠습니까?");
				if (!flag) {
					evt.preventDefault();
				}
			});
		});
	</script>

<style type="text/css">
	a{
		text-decoration: none;
	}
</style>
</head>
<body> 
메일 수신여부 : 
<input type="checkbox" name="mailing" value="true" id="chk"><br>
<input type="button" value="click" id="btn">
<p>
<a href="http://www.google.com">구글</a>
<a href="http://www.daum.net">다음</a>
</p>
<ul>
	<li>우유</li>
	<li>빵</li>
	<li>두유</li>
	<li>쿠키</li>
	<li>탄산음료</li>
</ul>
</body>
</html>







