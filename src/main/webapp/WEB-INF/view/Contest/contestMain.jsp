<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#admin-menu{
		display: inline-block; 
		border-style: solid;
	}
	#contest-menu{
		border-style: solid;
		width: 80%;
	}
</style> 
</head>
<body>
	<div id="contest-menu">
		<h1>공모전 메인</h1>
		<a href="contestList">공모전리스트</a>
	</div>
	<c:if test="${memLev == 4}">
		<div id="admin-menu">
			<div>
				<h1>관리자 메뉴</h1>
			</div>
			<div>
				<a href="contestInsertForm">공모전등록</a>
			</div>
			<div>
				<a href="contestCheck">등록한 공모전 조회</a>
			</div>
		</div>
	</c:if>
</body>
</html>