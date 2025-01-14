<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head></head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
div {
	margin: 0 auto;
	display: block;
}

.categoryCon, .menueContainer, .menueInfo_container, .category_names {
	border: 1px solid black;
}

button {
	cursor: pointer;
}

.mainContainer {
	width: 1080px;
	height: 800px;
}

.categoryCon {
	width: 320px;
	height: 800px;
	float: left;
	height: 100%;
}

.category_names {
	width: 300px;
	height: 50px;
	margin: 0 auto;
	display: flex;
	justify-content: center;
}

.menueContainer {
	width: 700px;
	float: right;
	height: 100%;
	overflow: auto;
}

#insert_btn {
	width: 100%;
	margin: 0 auto;
}

#manage_btn {
	display: block;
}

#detailMenue_open {
	width: 50px;
	height: 50px;
	margin: 5px auto;
	float: right;
}

.menue_text {
	margin: 0 20px 0 10px;
}

.menue_text_top {
	
}

.menueInfo_container {
	height: 70px;
}

.menueInfo {
	margin: 5px 0 10px;
}

.menueInfo_top, .menueInfo_bottom {
	width: 550px;
	float: left;
}
</style>
<body>
	<h1>카테고리페이지입니다</h1>
	<div class="mainContainer">
		<div class="categoryCon">
			<c:forEach items="${cateList}" var="cateList">
				<button value="${cateList.category_num}" class="category_names"
					style="color: blue;">${cateList.category_name}</button>
			</c:forEach>
		</div>
		<div class="menueContainer">
			<div class="manage_con">
				<button value="${nowPage.nowCate}" type="button" id="manage_btn">메뉴관리</button>
			</div>
			<div id="menue_eachform">
				<c:forEach items='${cateTest}' var='cateTest'>
					<div class='menueInfo_container'>
						<button name="${cateTest.menue_name}"
							value="${cateTest.category_num}" id="detailMenue_open">상세보기</button>
						<div class="menueInfo menueInfo_top">
							<span class="menue_text menue_text_top menue_info_name">음식명
								: ${cateTest.menue_name}</span> <span
								class="menue_text menue_text_top menue_info_price">가격 : <fmt:formatNumber
									value="${cateTest.menue_price}"></fmt:formatNumber>&nbsp;원
							</span>
						</div>
						<div class="menueInfo menueInfo_bottom">
							<span class="menue_text menue_info_detail">${cateTest.etc}</span>
						</div>
					</div>
				</c:forEach>

			</div>
			<div>
				<button id="insert_btn">메뉴등록</button>
			</div>
		</div>
	</div>

	<form id="moveForm" method="get">
		<!-- cateTest 라는 name으로 menueManage 페이지 이동시키면 현재 보고있던 카테고리 바로뜰수 있을거 같음 -->
		
		<input type="text" name="nowCate" value="${nowPage.nowCate}"/>
	</form>

	<script>
		$(document)
				.ready(
						function() {
							$(document)
									.on(
											'click',
											'button[id="detailMenue_open"]',
											function(e) {
												let form = $("#moveForm");
												var menueName = $(this).attr(
														'name');
												console.log(menueName);
												form
														.append("<input type='hidden' name='menue_name' value='"
													+ menueName + "' />");
												form.attr("action",
														"/test/detailInfo");
												form.submit();
											});
						});
		$('#insert_btn').on('click', function() {
			window.location.href = "/test/insertMenue";
		});

		$(document).on("click", "#manage_btn", function() {
			$('#moveForm').append('<input type="text" name="cateTest" value="' + $(this).val() + '"/>');
			$('#moveForm').attr('action', '/test/menueManage');
			$('#moveForm').submit();
		});
		$(document).on("click", "button[class='category_names']", function() {
			var cateTest = $(this).val();
			/* console.log(cateTest + " ajax 부분"); */
			$.ajax({
				url : "/test/cateList",
				type : "GET",
				data : {
					cateTest : cateTest
				},
				success : function(testData) {
					document.body.innerHTML = testData;
					console.log(cateTest);
					$('#moveForm').find('input[name="nowCate"]').val(cateTest);
					$('#manage_btn').val(cateTest);

					/*
					 * body 부분 내용을 testData로 수정
					 */

				}
			});

		});
	</script>
</body>
</html>