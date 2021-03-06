<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE>
<html lang="ko">
	<head>
	  <meta charset="UTF-8">
	  <title>관리자 : 공지사항 상세</title>
	  
	  <!-- link -->
	  <link rel="stylesheet" href="../../assets/css/bootstrap.css">
	  <link rel="stylesheet" href="../../assets/css/maicons.css">
	  <link rel="stylesheet" href="../../assets/vendor/animate/animate.css">
	  <link rel="stylesheet" href="../../assets/vendor/owl-carousel/css/owl.carousel.css">
	  <link rel="stylesheet" href="../../assets/vendor/fancybox/css/jquery.fancybox.css">
	  <link rel="stylesheet" href="../../assets/css/theme.css">
	  <link rel="stylesheet" href="../../assets/css/admin.css">
	  
	  <style>
	   #f-file-image {
	     height:100px;
	   }
	  </style>
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
	        <li><a href="#">봉사활동관리</a></li>
	        <li><a href="#">모금함활동관리</a></li>
	        <li><a href="#" class="on">공지사항관리</a></li>
	        <li><a href="#">문의사항관리</a></li>
	        <li><a href="#">챌린지사항관리</a></li>
	      </ul>
	    </div>
	    <!-- //menu -->
	    
	    <div class="ad-main">
	      <div class="ad-main-infor">
	        <div class="write-wrap">
	          <h4 class="mb-5">공지사항 상세</h4>
	          <form action="noticeUpdate" method="post" id="notice-form" enctype="multipart/form-data">
	            <div class="form-group">
	              <label for="f-no">번호</label>
	              <input type="text" class="form-control col-sm-1" id="f-no" name="noticeNo" value="${noticeDTO.no}" readonly>
	            </div>
	            <!-- //번호 -->
	            <div class="form-group">
	              <label for="f-title">제목</label>
	              <input type="text" class="form-control" id="f-title" name="title" value="${noticeDTO.title}">
	            </div>
	            <!-- //제목 -->
	            <div class="form-group">
	              <label for="f-content">내용</label>
	              <textarea name="content" id="f-content" cols="30" rows="8" class="form-control">${noticeDTO.content}</textarea>
	            </div>
	            <!-- //내용 -->
	            <div class="form-group">
	              <label for="f-registeredDate">등록일</label>
	              <span id='f-registeredDate'>${noticeDTO.registeredDate}</span>
	            </div>
	            <!-- //등록일 -->
	            <div class="form-group">
	              <label for="f-viewCount">조회수</label>
	              <span id='f-viewCount'>${noticeDTO.viewCount}</span>
	            </div>
	            <!-- //조회수 -->
	            <div class="form-group row">
	              <label for="f-file" class="col-sm-1 col-form-label">첨부파일</label>
	              <div class="col-sm-11">
	              <img  id ="f-file-image" src="../upload/notice/${notice.fileUpload}">
	                <input type="file" class="form-control-file" id="f-file" name="fileUpload">
	              </div>
	            </div>
	            <!-- //파일첨부 -->
	            <div class="form-group">
	              <button class="btn btn-primary">수정</button>
	              <a href="noticeDelete?noticeNo=${noticeDTO.no}" class="btn btn-primary">삭제</a>
	              <a href="noticeList" class="btn btn-primary">목록</a>
	            </div>
	            <!-- //ad-btn -->
	          </form>
	        </div>
	        <!-- //write-wrap -->
	      </div>
	      <!-- //form -->
	    </div>
	    <!-- //ad-main -->
	    
	  </div>
	  <!-- //wrap -->
	  
	  <!-- sript -->

		
	</body>
</html>