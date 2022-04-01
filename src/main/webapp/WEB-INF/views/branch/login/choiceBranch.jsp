<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="selectForm">
	<table>
		<tr>
			<th></th>
			<th>지점 명</th>
			<th>지점 전화번호</th>
			<th>점주 이름</th>
			<th>지점 주소</th>
			<th>지점 상세주소</th>
			<th>지점 오픈시간</th>
			<th>지점 닫는시간</th>
		</tr>
		<c:forEach var="info" items="${info}">
		<tr>
			<td><input type="radio" name="branch_name" value="${info.branch_name}"></td>
			<td>${info.branch_name}</td>
			<td>${info.branch_phone}</td>
			<td>${info.branch_leaderName}</td>
			<td>${info.branch_addr}</td>
			<td>${info.branch_detail}</td>
			<td>${info.branch_openTime}</td>
			<td>${info.branch_closeTime}</td>
		</tr>
		</c:forEach>
	</table>
	<button type="button">지점선택</button>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var selectForm = $("#selectForm");
		$("#selectForm button").on("click", function(e) {
			e.preventDefault();
			
			if($("input:radio[name=branch_name]").is(":checked") == false){
				alert("지점을 선택해주세요.");
				return;
			}
			
			var checkvar = $("input:radio[name=branch_name]:checked").val();
			console.log(checkvar);
			selectForm.attr({
				"method" : "GET",
				"action" : "/branch/main/index"
			});
			selectForm.submit();
		});
	});
</script>
</body>
</html>