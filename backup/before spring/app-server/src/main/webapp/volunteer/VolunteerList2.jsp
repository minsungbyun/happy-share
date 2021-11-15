
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--<meta name="copyright" content="MACode ID, https://macodeid.com/"> -->
  
    <title>함께해요 : 봉사목록</title>
    <!-- link -->
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/maicons.css">
    <link rel="stylesheet" href="../assets/vendor/animate/animate.css">
    <link rel="stylesheet" href="../assets/vendor/owl-carousel/css/owl.carousel.css">
    <link rel="stylesheet" href="../assets/vendor/fancybox/css/jquery.fancybox.css">
    <link rel="stylesheet" href="../assets/css/theme.css">
    <link rel="stylesheet" href="../assets/css/style.css">
  </head>
<body>

  <!-- Back to top button -->
  <div class="back-to-top"></div>


  <!-- header -->
  <header>
    <div class="top-bar">
      <div class="container">
        <div class="row align-items-center">          
          <div class="col-md-12 text-right d-none d-md-block">
            <div class="social-mini-button">
              <a href="#"><span>로그인</span></a>
              <a href="#"><span>회원가입</span></a>
               <a href="#"><span>관리자</span></a>
            </div>
          </div>
        </div>
        <!-- //row -->
      </div>
    </div>
    <!-- //top-bar -->

    <!-- nav -->
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
        <a href="index.html" class="navbar-brand">Happy<span class="text-primary logo">Share</span></a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <!-- navbarContent -->
        <div class="navbar-collapse collapse" id="navbarContent">
          <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
            <li class="nav-item active">
              <a href="#" class="nav-link">함께해요</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">소통해요</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">나눔이야기</a>
                <a class="dropdown-item" href="#">한줄후기</a>
              </div>
            </li>
            <li class="nav-item">
              <a href="services.html" class="nav-link">챌린지</a>
            </li>
            <li class="nav-item">
              <a href="portfolio.html" class="nav-link">모금함</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">고객센터</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">공지사항</a>
                <a class="dropdown-item" href="#">문의사항</a>
              </div>
            </li>
          </ul>
        </div>
        <!-- //navbarContent -->
      </div>
      <!-- //container -->
    </nav>
    <!-- //nav -->


    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../assets/img/bg_image_3.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="index.html" style="font-size:20px;">함께해요</a></li>
                <li class="breadcrumb-item active" aria-current="page" style="font-size:22px;">봉사목록</li>
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </div> <!-- .page-banner -->
  </header>

  <!-- main -->
  <main>
    <div class="page-section">
      <div class="container">
        <div class="btn-regi" style="text-align:right;">
          <a href="#" class="btn btn-outline-primary nBtn btn-sm" role="button" style="padding:8px 20px">개인봉사등록</a>
          <a href="#" class="btn btn-outline-success nBtn btn-sm" role="button" style="padding:8px 20px">기관봉사등록</a>
        </div>
        <!-- //filterable-btn -->
        <div class="filterable-btn">
          <button class="btn active" data-filter="*">전체</button>
          <button class="btn" data-filter=".web">비대면</button>
          <button class="btn" data-filter=".mobile">아동</button>
          <button class="btn" data-filter=".desktop">청소년</button>
          <button class="btn" data-filter=".desktop">노인</button>
          <button class="btn" data-filter=".desktop">장애인</button>
          <button class="btn" data-filter=".desktop">동물</button>
          <button class="btn" data-filter=".desktop">환경</button>
          <button class="btn" data-filter=".desktop">기타</button>
      </div>
      <!-- //filterable-btn -->

      <!-- card_body -->
      <div class="card_body " style="overflow: hidden; box-sizing: border-box; width:100%; margin-top:45px;" >

        <!-- 봉사목록 -->
         <div class="card card-item" style="width: 33.33%; float: left;  padding: 0 5%; border: none; ">
          <img src="https://cdn-icons-png.flaticon.com/512/3349/3349234.png" class="card-img-top" alt="...">
          <div class="card-body">
              <h5 class="card-title vol-title"><a href='detail?no=${volunteerRequestDTO.no}'>${volunteerRequestDTO.title}</a></h5>
              <p class="card-text"><span class="text-muted">${volunteerRequestDTO.startDate} ~ ${volunteerRequestDTO.endDate}</span></p>
              <p class="card-text">카테고리 : ${volunteerRequestDTO.category.title}</p>
              <p class="card-text">남은자리 : ${remainNum}명</p>
              <input type="checkbox" name="wish"> 찜하기
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item" style="font-weight:bold;">
              <span class="vol-cur">
                  <span class="sr-only">참여인원</span>
                  <b class="vol-count">${volunteerRequestDTO.currentNum}명</b>
                  /
                  <span class="sr-only">총 모집인원</span>
                  ${volunteerRequestDTO.limitNum}명
                </span>
              <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">010-1111-1111</span>
            </li>
            <li class="list-group-item">~ ${remainNum}일 남음</li>
          </ul>
          <div class="card-footer">
            <small class="text-muted">${volunteerRequestDTO.owner.id}</small>
          </div>
         <span class="vol-type bu">${volunteerRequestDTO.category.title}</span>
        </div>
        <!-- //봉사목록 -->
        
        <!-- 봉사목록 -->
         <div class="card card-item" style="width: 33.33%; float: left;  padding: 0 5%; border: none; ">
          <img src="https://cdn-icons-png.flaticon.com/512/3349/3349234.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title vol-title">제목제목제(글자수제한걸기)</h5>
            <p class="card-text"><span class="text-muted">2021.11.10~2021.11.25</span></p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item" style="font-weight:bold;">
              <span class="vol-cur">
                  <span class="sr-only">참여인원</span>
                  <b class="vol-count">0명</b>
                  /
                  <span class="sr-only">총 모집인원</span>
                  5명
                </span>
              <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">010-1111-1111</span>
            </li>
            <li class="list-group-item">~5일 남음</li>
          </ul>
          <div class="card-footer">
            <small class="text-muted">주최자 ID</small>
          </div>
         <span class="vol-type bu">비대면</span>
        </div>
        <!-- //봉사목록 -->

        <!-- 봉사목록 -->
         <div class="card card-item" style="width: 33.33%; float: left;  padding: 0 5%; border: none; ">
          <img src="https://cdn-icons-png.flaticon.com/512/3349/3349234.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title vol-title">제목제목제(글자수제한걸기)</h5>
            <p class="card-text"><span class="text-muted">2021.11.10~2021.11.25</span></p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item" style="font-weight:bold;">
              <span class="vol-cur">
                  <span class="sr-only">참여인원</span>
                  <b class="vol-count">0명</b>
                  /
                  <span class="sr-only">총 모집인원</span>
                  5명
                </span>
              <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">010-1111-1111</span>
            </li>
            <li class="list-group-item">~5일 남음</li>
          </ul>
          <div class="card-footer">
            <small class="text-muted">주최자 ID</small>
          </div>
         <span class="vol-type bu">비대면</span>
        </div>
        <!-- //봉사목록 -->
      </div>
      <!-- //card_body -->

      <div class="mt-5 text-center">
         <button class="btn btn-primary">Load More</button>
       </div>
      </div> <!-- .container -->
    </div> <!-- .page-section -->
  </main>

 <!-- footer -->
  <footer class="page-footer">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 py-3">
          <h3>Reve<span class="fg-primary">Tive.</span></h3>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Contact Information</h5>
          <p>301 The Greenhouse, Custard Factory, London, E2 8DY.</p>
          <p>Email: example@mail.com</p>
          <p>Phone: +00 112323980</p>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Company</h5>
          <ul class="footer-menu">
            <li><a href="#">Career</a></li>
            <li><a href="#">Resources</a></li>
            <li><a href="#">News & Feed</a></li>
          </ul>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Newsletter</h5>
          <form action="#">
            <input type="text" class="form-control" placeholder="Enter your email">
            <button type="submit" class="btn btn-primary btn-sm mt-2">Submit</button>
          </form>
        </div>
      </div>

      <hr>

      <div class="row mt-4">
        <div class="col-md-6">
          <p>Copyright 2020. This template designed by <a href="https://macodeid.com">MACode ID</a></p>
        </div>
        <div class="col-md-6 text-right">
          <div class="sosmed-button">
            <a href="#"><span class="mai-logo-facebook-f"></span></a>
            <a href="#"><span class="mai-logo-twitter"></span></a>
            <a href="#"><span class="mai-logo-youtube"></span></a>
            <a href="#"><span class="mai-logo-linkedin"></span></a>
          </div>
        </div>
      </div>
    </div>
  </footer>
  <!-- //footer -->

  <!-- script -->
  <script src="../assets/js/jquery-3.5.1.min.js"></script>
  <script src="../assets/js/bootstrap.bundle.min.js"></script>
  <script src="../assets/vendor/owl-carousel/js/owl.carousel.min.js"></script>
  <script src="../assets/vendor/wow/wow.min.js"></script>
  <script src="../assets/vendor/fancybox/js/jquery.fancybox.min.js"></script>
  <script src="../assets/vendor/isotope/isotope.pkgd.min.js"></script>
  <script src="../assets/js/google-maps.js"></script>
  <script src="../assets/js/theme.js"></script>

</body>
</html>


















