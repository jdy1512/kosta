<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td{
	border: 1px solid black;
}
table{
	width:700px;
	border-collapse: collapse;
}
td{
	padding: 5px; /* 안쪽 여백 너비 */
}
select{
	width:150px;
}
#product_info_layer{
	width:700px;
	border: 1px solid gray;
	padding:5px;/* 안쪽 여백 너비 */
	display: none;/*최초로딩시에는 안보이도록 처리*/
}
#tbody{
	cursor: pointer;
}
</style>

<script type="text/javascript" src="/category_jquery_template/script/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#first_category").on("change", function() {
			$.ajax({
				url:"/category_jquery_template/controller",
				type:"POST",
				data:"command=second_category&firstCategoryId=" + $(this).val(),
				dataType:"JSON",
				beforeSend:function() {
					if ($("#first_category option").index($("#first_category option:selected"))==0) {
						$("#second_category").empty().append("<option value='default'>중분류</option>");
						$("#third_category").empty().append("<option value='default'>소분류</option>");
						$("#thead").empty();
						$("#tbody").empty();
						$("#product_info_layer").hide();
						return false;
					}
				},
				error:errorCallback,
				success:function(obj) {
					$("#second_category").empty().append("<option value='default'>중분류</option>");
					$("#third_category").empty().append("<option value='default'>소분류</option>");
					$("#thead").empty();
					$("#tbody").empty();
					$("#product_info_layer").hide();
					for (var idx = 0; idx < obj.length; idx++) {
						$("#second_category").append("<option value='"+ obj[idx].categoryId + "'>" + obj[idx].categoryName + "</option>");
					}
				}
			});
		});
		
		$("#second_category").on("change", function() {
			$.ajax({
				url:"/category_jquery_template/controller",
				type:"POST",
				data:"command=third_category&secondCategoryId=" + $(this).val(),
				dataType:"JSON",
				beforeSend:function() {
					if ($("#second_category option").index($("#second_category option:selected"))==0) {
						$("#third_category").empty().append("<option value='default'>소분류</option>");
						$("#thead").empty();
						$("#tbody").empty();
						$("#product_info_layer").hide();
						return false;
					}
				},
				error:errorCallback,
				success:function(obj) {
					$("#third_category").empty().append("<option value='default'>소분류</option>");
					$("#thead").empty();
					$("#tbody").empty();
					$("#product_info_layer").hide();
					for (var idx = 0; idx < obj.length; idx++) {
						$("#third_category").append("<option value='"+ obj[idx].categoryId + "'>" + obj[idx].categoryName + "</option>");
					}
				}
			});
		});
		
		$("#third_category").on("change", function() {
			$.ajax({
				url:"/category_jquery_template/controller",
				type:"POST",
				data:"command=get_product_list&thirdCategoryId=" + $(this).val(),
				dataType:"JSON",
				beforeSend:function() {
					if ($("#third_category option").index($("#third_category option:selected"))==0) {
						$("#thead").empty();
						$("#tbody").empty();
						$("#product_info_layer").hide();
						return false;
					}
				},
				error:errorCallback,
				success:function(obj) {
					$("#thead").empty();
					$("#tbody").empty();
					$("#product_info_layer").hide();
					$("#thead").append("<tr><td>제품ID</td><td>제품명</td><td>제조사</td><td>제품가격</td></tr>");
					for (var idx = 0; idx < obj.length; idx++) {
						$("#tbody").append("<tr id='item'><td>"+ obj[idx].productId + "</td><td>"+ obj[idx].productName + "</td><td>"+ obj[idx].productMaker + "</td><td>"+ obj[idx].productPrice + "</td></tr>");
					}
				}
			});
		});
		
		
		$("#tbody").on("click", "#item", function() {
			$("#tbody tr").css("background-color", "white");
			$(this).css("background-color", "orange");
			
			$.ajax({
				url:"/category_jquery_template/controller",
				type:"POST",
				data:"command=get_product_info&productId=" + $(this).children().html(),
				dataType:"JSON",
				error:errorCallback,
				success:function(obj) {
					$("#product_info_layer").html(obj.productInfo).show();
				}
			});
		});
		
	});
	
	function errorCallback() {
		alert("error");
	}
</script>

</head>
<body>
대분류 : 
<select name="first_category" id="first_category">
	<option value='default'>대분류</option>
	<c:forEach items="${ firstCategory }" var="category">
		<option value='${category.categoryId}'>${category.categoryName}</option>
	</c:forEach>
</select>
중분류 : 
<select id="second_category">
	<option value='default'>중분류</option>
</select>
소분류 : 
<select id="third_category">
	<option value='default'>소분류</option>
</select>
<p>
<table>
	<thead id="thead"></thead>
	<tbody id="tbody"></tbody>
</table>
<p>
<!-- 상품 상세 정보 출력할 div-->
<div id="product_info_layer"></div>
</body>
</html>




    