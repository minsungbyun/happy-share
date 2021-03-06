<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>관리자페이지</title>
  
  <!-- link -->
  <link rel="stylesheet" href="../../assets/css/bootstrap.css">
  <link rel="stylesheet" href="../../assets/css/maicons.css">
  <link rel="stylesheet" href="../../assets/vendor/animate/animate.css">
  <link rel="stylesheet" href="../../assets/vendor/owl-carousel/css/owl.carousel.css">
  <link rel="stylesheet" href="../../assets/vendor/fancybox/css/jquery.fancybox.css">
  <link rel="stylesheet" href="../../assets/css/theme.css">
  <link rel="stylesheet" href="../../assets/css/admin.css">
</head>

<body>
  <div id="wrap">
    <div class="head">
      <div class="container">
        <div class="header">
          <h6 class="navbar-brand">Happy<b class="text-primary logo">Share</b></h6>
          <div class="btn-logoout">
            <button type="button" class="btn btn-primary btn-sm btn-logo">로그아웃</button>
          </div>
        </div>
      </div>
    </div>
    <!-- //head -->
    
    <div class="menu">
      <ul>
        <li><a href="#" >회원정보조회</a></li>
        <li><a href="#">모금&봉사활동관리</a></li>
        <li><a href="#">공지사항관리</a></li>
        <li><a href="#">문의사항관리</a></li>
        <li><a href="#" class="on">챌린지사항관리</a></li>
      </ul>
    </div>
    <!-- //menu -->

    <div class="ad-main">
      <div class="ad-main-infor">
        <!-- serch -->
        <div class="serch">
          <label for="inforSerch">검색</label>
          <input type="text" class="" id="inforSerch">
          <button type="submit" class="searchBtn">검색</button>
        </div>
        <!-- //serch -->
        <h1>챌린지 상세</h1>
    <form action='update' method='post' enctype="multipart/form-date">
        <label for='f-no'>번호</label> 
        <input id='f-no' type='text' name='no' value='${challengeDTO.no}' readonly><br>
        
        <label for='f-title'>제목</label>
        <input id='f-title' type='text' name='title' value='${challengeDTO.title}'><br>
        
        <label for='f-content'>내용</label> 
        <input id='f-content' type='text' name='content' value='${challengeDTO.content}'><br>
        
        <label for='f-startDate'>시작일</label> 
        <input id='f-startDate' type='date' name='startDate' value='${challengeDTO.startDate}'><br>
        
        <label for='f-endDate'>종료일</label> 
        <input id='f-endDate' type='date' name='endDate' value='${challengeDTO.endDate}'><br>

        <label for='f-registeredDate'>등록일</label> 
        <span id='f-registeredDate'>${challengeDTO.registeredDate}</span><br>
    <button>변경</button>
     <a href='delete?no=${challengeDTO.no}'>[삭제]</a> <a href='list'>[목록]</a><br>
     <a href='questionList?no=${challengeDTO.no}'>[문의목록]</a>
    </form>
      </div>
      <!-- //form -->
    </div>
    <!-- //ad-main -->
        
  </div>
  <!-- //wrap -->
</body>
</html>