<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.testHeader{
		border: 1px solid red;
	}
	.testContents{
		border: 1px solid black;
	}
	.testFooter{
		border: 1px solid blue;
	}
</style>
</head>
<body>
	<header>
		<jsp:include page="./testHeader.jsp"/>
		<%-- <jsp:include page="/WEB-INF/views/test/testHeader.jsp"/> --%>
	</header>
	<div class="testContents">
		<h3>
			여긴 주요 내용이 들어갈 contents 영역입니다.
		</h3> 
			테스트 : ${testList}
	</div>
	<footer>
		<jsp:include page="./testFooter.jsp"/>
	</footer>
</body>
</html>