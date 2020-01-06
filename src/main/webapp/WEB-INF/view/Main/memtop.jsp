<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  }
.navbar1 {
  overflow: hidden;
  background-color: #333;
}

.navbar1 a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown1 {
  float: left;
  overflow: hidden;
}

.dropdown1 .dropbtn1 {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar1 a:hover, .dropdown1:hover .dropbtn1 {
  background-color: red;
}

.dropdown-content1 {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content1 a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content1 a:hover {
  background-color: #ddd;
}

.dropdown1:hover .dropdown-content1 {
  display: block;
}
</style>

</head>
<body>


<div class="navbar1">
  <a href="main">Home</a>
  <a href="goodsMain">ATO</a>
  <a href="QnA/qnaList">고객 센터</a>
  <a href="Car/carEnrollmentList">carcar</a>
  <a href="logout">로그아웃</a>
  <a href="profile"> 프로필 </a>
  <a href="ActivityInsert"> 활동 생성</a>

  <div class="dropdown1">
    <button class="dropbtn1">Dropdown 
      <i class="fa fa-caret-down1"></i>
    </button>
    <div class="dropdown-content1">
      <a href="spot">휴양지 신청</a>
      <a href="ActivityList">활동</a>
      <a href="Car/carWriter">car</a>
      <a href="Car/carCalendarList">car일정목록</a>
      
    </div>
  </div> 

</div>

</body>
</html>