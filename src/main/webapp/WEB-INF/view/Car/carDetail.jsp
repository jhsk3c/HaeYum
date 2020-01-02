<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<jsp:include page="../Main/memtop.jsp" />
	</div>
	<h1 align="center">운전자 상세정보</h1>
	<table border="1" align="center" width = "300" height = "100" >
		<tr>
			<td>이름</td>
		</tr>
		<tr>
			<td>${carDTO.driveName}</td>
		</tr>
		<tr>
			<td>나이</td>
		</tr>
		<tr>
			<td>${carDTO.driveAge}</td>
		</tr>
		<tr>
			<td>운전면허증</td>
		</tr>
		<tr>
			<td>${carDTO.driveLicenseInfo}</td>
		</tr>
		<tr>
			<td>차 이름</td>
		</tr>
		<tr>
			<td>${carDTO.carName}</td>
		</tr>
		<tr>
			<td>차 번호</td>
		</tr>
		<tr>
			<td>${carDTO.carNum}</td>
		</tr>
		<tr>
			<td>차 사진</td>
		</tr>
		<tr>
			<td><c:forEach var="store" items="${stores}" varStatus="status">
					<img src="upload/${store}" width="100" height="100">
				</c:forEach> </td>
		</tr>
		<tr>
			<td>무게</td>
		</tr>
		<tr>
			<td>${carDTO.carSize}</td>
		</tr>
		<tr>
			<td>종류</td>
		</tr>
		<tr>
			<td>${carDTO.carKinds}</td>
		</tr>
		<tr>
			<td>내용</td>
		</tr>
		<tr>
			<td>${carDTO.carContent}</td>
		</tr>
		<tr>
			<td>차 등록시간</td>
		</tr>
		<tr>
			<td>${carDTO.carRegist}</td>
		</tr>
		<c:if test="${memLev == 4 }">
			<tr>
				<td>운전 면허증</td>
			</tr>
			<tr>
				<td><c:forEach var="store2" items="${stores2}" varStatus="status">
					<img src="upload/${store2}" width="100" height="100">
				</c:forEach> </td>
			</tr>
			<tr>
				<td>보험 증명서 </td>
			</tr>
			<tr>
				<td>
					<c:forEach var="store" items="${stores1}" varStatus="status">
						<img src="upload/${store}" width="100" height="100">
					</c:forEach> 
				</td>
			</tr>
			<tr>
				<td>자차 확인서</td>
			</tr>
			<tr>
				<td><c:forEach var="store3" items="${stores3}" varStatus="status">
						<img src="upload/${store3}" width="100" height="100">
					</c:forEach> </td>
			</tr>
			<tr>
				<td colspan="2"><a
					href="carApprovalCheck?driveNum=${carDTO.driveNum}&memNum=${carDTO.memNum}&carApproval=1">승인확인</a>
					<a
					href="carApprovalCheck?driveNum=${carDTO.driveNum}&memNum=${carDTO.memNum}&carApproval=2">승인거절</a>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="2"><a href="carEnrollmentList">목록</a> <c:if
					test="${memLev == 1 }">
					<a href="carEnrollmentModify?driveNum=${carDTO.driveNum}">수정</a>
				</c:if></td>
		</tr>
	</table>
</body>
</html>