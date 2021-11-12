<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
  
    <title>HappyShare</title>
    <!-- link -->
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/maicons.css">
    <link rel="stylesheet" href="assets/vendor/animate/animate.css">
    <link rel="stylesheet" href="assets/vendor/owl-carousel/css/owl.carousel.css">
    <link rel="stylesheet" href="assets/vendor/fancybox/css/jquery.fancybox.css">
    <link rel="stylesheet" href="assets/css/theme.css">
    <link rel="stylesheet" href="assets/css/style.css">
  </head>
  <body>
    <header>
      <div class="top-bar">
        <div class="container">
          <div class="row align-items-center">          
            <div class="col-md-12 text-right d-none d-md-block">
              <div class="social-mini-button">
               <c:if test="${empty sessionScope.loginUser}">
                  <a href="auth/loginForm"><span>로그인</span></a>
                </c:if>
                <c:if test="${not empty sessionScope.loginUser}">
						    <c:if test="${empty sessionScope.loginUser.photo}">
						        <img src="asset/img/default.png">
						    </c:if>
							    <c:if test="${not empty sessionScope.loginUser.photo}">
							    <img src="happyshare/upload/user/${sessionScope.loginUser.photo}_100x100.jpg">
							    </c:if>
						        ${sessionScope.loginUser.name}<br>
						         <a href="auth/logout"><span>로그아웃</span></a>
						    </c:if>
                <a href="join/userType"><span>회원가입</span></a>
                <a href="#"><span>관리자</span></a>
              </div>
            </div>
          </div>
          <!-- //row -->
        </div>
      </div>
      <!-- //top-bar -->
  
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
           <a href="index.html" class="navbar-brand">Happy<span class="text-primary logo">Share</span></a>
          <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
  
          <div class="navbar-collapse collapse" id="navbarContent">
            <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
              <li class="nav-item">
                <a href="index.html" class="nav-link">함께해요</a>
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
        </div> <!-- .container -->
      </nav> <!-- .navbar -->
    </header>
    
    <section>
      <div class="page-banner home-banner mb-5">
        <div class="slider-wrapper">
          <div class="owl-carousel hero-carousel">
            <div class="hero-carousel-item">
              <img src="assets/img/bg_image_1.jpg" alt="">
              <div class="img-caption">
                <div class="subhead">We're design studio believe in ideas</div>
                <h1 class="mb-4">Creative Design</h1>
                <a href="#services" class="btn btn-outline-light">Get Started</a>
              </div>
            </div>
            <div class="hero-carousel-item">
              <img src="assets/img/bg_image_2.jpg" alt="">
              <div class="img-caption">
                <h1 class="mb-4">We combine Design, Thinking, and Technical</h1>
                <a href="#services" class="btn btn-outline-light">Get Started</a>
                <a href="#services" class="btn btn-primary">See Pricing</a>
              </div>
            </div>
            <div class="hero-carousel-item">
              <img src="assets/img/bg_image_3.jpg" alt="">
              <div class="img-caption">
                <div class="subhead">Easy way to build perfect website</div>
                <h1 class="mb-4">Beautify handcrafted templates for your website</h1>
                <a href="#services" class="btn btn-primary">Read More</a>
              </div>
            </div>
          </div>
        </div> <!-- .slider-wrapper -->
      </div> <!-- .page-banner -->
    </section>
  
    <main>
      <div class="page-section">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-6 py-3">
              <div class="subhead">About Us</div>
              <h2 class="title-section">We are <span class="fg-primary">Professional Teams</span> to Growth your Business</h2>
  
              <p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of</p>
  
              <a href="about.html" class="btn btn-primary mt-4">Read More</a>
            </div>
            <div class="col-lg-6 py-3">
              <div class="about-img">
                <img src="assets/img/about.jpg" alt="">
              </div>
            </div>
          </div>
        </div>
      </div> <!-- .page-section -->
  
      <div class="page-section">
        <div class="container">
          <div class="text-center">
            <div class="subhead">Our Services</div>
            <h2 class="title-section">See what can we do for your Projects</h2>
          </div>
  
          <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="assets/img/icons/web_development.svg" alt="">
                </div>
                <h5>Web Development</h5>
              </div>
            </div>
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="assets/img/icons/graphics_design.svg" alt="">
                </div>
                <h5>Graphics Design</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="assets/img/icons/seo_and_marketing.svg" alt="">
                </div>
                <h5>SEO & Marketing</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="assets/img/icons/customer_services.svg" alt="">
                </div>
                <h5>Customer Services</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="assets/img/icons/app_development.svg" alt="">
                </div>
                <h5>App Development</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="assets/img/icons/ui_ux_design.svg" alt="">
                </div>
                <h5>UI/UX Design</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="assets/img/icons/product_design.svg" alt="">
                </div>
                <h5>Product Design</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="assets/img/icons/data_analyst.svg" alt="">
                </div>
                <h5>Data Analyst</h5>
              </div>
            </div>
  
          </div>
        </div> <!-- .container -->
      </div> <!-- .page-section -->
  
      <div class="page-section">
        <div class="container">
          <div class="text-center">
            <div class="subhead">Our Teams</div>
            <h2 class="title-section">The Expert Team on ReveTive</h2>
          </div>
  
          <div class="owl-carousel team-carousel mt-5">
            <div class="team-wrap">
              <div class="team-profile">
                <img src="assets/img/teams/team_1.jpg" alt="">
              </div>
              <div class="team-content">
                <h5>Walter White</h5>
                <div class="text-sm fg-grey">Chief Executive Officer</div>
  
                <div class="social-button">
                  <a href="#"><span class="mai-logo-facebook-messenger"></span></a>
                  <a href="#"><span class="mai-call"></span></a>
                  <a href="#"><span class="mai-mail"></span></a>
                </div>
              </div>
            </div>
  
            <div class="team-wrap">
              <div class="team-profile">
                <img src="assets/img/teams/team_2.jpg" alt="">
              </div>
              <div class="team-content">
                <h5>Sarah Johanson</h5>
                <div class="text-sm fg-grey">Chief Technology Officer</div>
  
                <div class="social-button">
                  <a href="#"><span class="mai-logo-facebook-messenger"></span></a>
                  <a href="#"><span class="mai-call"></span></a>
                  <a href="#"><span class="mai-mail"></span></a>
                </div>
              </div>
            </div>
  
            <div class="team-wrap">
              <div class="team-profile">
                <img src="assets/img/teams/team_3.jpg" alt="">
              </div>
              <div class="team-content">
                <h5>Anna Anderson</h5>
                <div class="text-sm fg-grey">Product Manager</div>
  
                <div class="social-button">
                  <a href="#"><span class="mai-logo-facebook-messenger"></span></a>
                  <a href="#"><span class="mai-call"></span></a>
                  <a href="#"><span class="mai-mail"></span></a>
                </div>
              </div>
            </div>
  
          </div>
        </div> <!-- .container -->
      </div> <!-- .page-section -->
  
      <div class="page-section">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-md-6 py-3">
              <div class="subhead">Portfolio</div>
              <h2 class="title-section">Our Latest Projects</h2>
            </div>
            <div class="col-md-6 py-3 text-md-right">
              <a href="portfolio.html" class="btn btn-outline-primary">Browse Projects <span class="mai-arrow-forward ml-2"></span></a>
            </div>
          </div>
  
          <div class="row mt-3">
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="assets/img/portfolio/work-1.jpg" data-fancybox="portfolio">
                  <img src="assets/img/portfolio/work-1.jpg" alt="">
                </a>
              </div>
            </div>
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="assets/img/portfolio/work-2.jpg" data-fancybox="portfolio">
                  <img src="assets/img/portfolio/work-2.jpg" alt="">
                </a>
              </div>
            </div>
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="assets/img/portfolio/work-3.jpg" data-fancybox="portfolio">
                  <img src="assets/img/portfolio/work-3.jpg" alt="">
                </a>
              </div>
            </div>
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="assets/img/portfolio/work-4.jpg" data-fancybox="portfolio">
                  <img src="assets/img/portfolio/work-4.jpg" alt="">
                </a>
              </div>
            </div>
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="assets/img/portfolio/work-5.jpg" data-fancybox="portfolio">
                  <img src="assets/img/portfolio/work-5.jpg" alt="">
                </a>
              </div>
            </div>
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="assets/img/portfolio/work-6.jpg" data-fancybox="portfolio">
                  <img src="assets/img/portfolio/work-6.jpg" alt="">
                </a>
              </div>
            </div>
          </div>
        </div> <!-- .container -->
      </div> <!-- .page-section -->
  
      <!-- Testimonials -->
      <div class="page-section">
        <div class="container">
          <div class="owl-carousel testimonial-carousel">
            <div class="card-testimonial">
              <div class="content">
                The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph
              </div>
              <div class="author">
                <div class="avatar">
                  <img src="assets/img/person/person_1.jpg" alt="">
                </div>
                <div class="d-inline-block ml-2">
                  <div class="author-name">Sam Watson</div>
                  <div class="author-info">CEO - Mosh Elite Ltd.</div>
                </div>
              </div>
            </div>
  
            <div class="card-testimonial">
              <div class="content">
                The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph
              </div>
              <div class="author">
                <div class="avatar">
                  <img src="assets/img/person/person_2.jpg" alt="">
                </div>
                <div class="d-inline-block ml-2">
                  <div class="author-name">Edinson Alfa</div>
                  <div class="author-info">CEO - Mosh Elite Ltd.</div>
                </div>
              </div>
            </div>
  
            <div class="card-testimonial">
              <div class="content">
                The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph
              </div>
              <div class="author">
                <div class="avatar">
                  <img src="assets/img/person/person_3.jpg" alt="">
                </div>
                <div class="d-inline-block ml-2">
                  <div class="author-name">May Halloway</div>
                  <div class="author-info">CEO - Mosh Elite Ltd.</div>
                </div>
              </div>
            </div>
  
            <div class="card-testimonial">
              <div class="content">
                The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph
              </div>
              <div class="author">
                <div class="avatar">
                  <img src="assets/img/person/person_1.jpg" alt="">
                </div>
                <div class="d-inline-block ml-2">
                  <div class="author-name">Sam Watson</div>
                  <div class="author-info">CEO - Mosh Elite Ltd.</div>
                </div>
              </div>
            </div>
  
            <div class="card-testimonial">
              <div class="content">
                The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph
              </div>
              <div class="author">
                <div class="avatar">
                  <img src="assets/img/person/person_2.jpg" alt="">
                </div>
                <div class="d-inline-block ml-2">
                  <div class="author-name">Edinson Alfa</div>
                  <div class="author-info">CEO - Mosh Elite Ltd.</div>
                </div>
              </div>
            </div>
  
            <div class="card-testimonial">
              <div class="content">
                The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph
              </div>
              <div class="author">
                <div class="avatar">
                  <img src="assets/img/person/person_3.jpg" alt="">
                </div>
                <div class="d-inline-block ml-2">
                  <div class="author-name">May Halloway</div>
                  <div class="author-info">CEO - Mosh Elite Ltd.</div>
                </div>
              </div>
            </div>
  
          </div> <!-- .row -->
        </div> <!-- .container -->
      </div> <!-- .page-section -->
  
      <div class="page-section">
        <div class="container">
          <div class="text-center">
            <div class="subhead">News</div>
            <h2 class="title-section">Read Our Latest News</h2>
          </div>
  
          <div class="row my-5 card-blog-row">
            <div class="col-lg-3 py-3">
              <div class="card-blog">
                <div class="header">
                  <div class="entry-footer">
                    <div class="post-author">Sam Newman</div>
                    <a href="#" class="post-date">23 Apr 2020</a>
                  </div>
                </div>
                <div class="body">
                  <div class="post-title"><a href="blog-single.html">What is Business Management?</a></div>
                </div>
                <div class="footer">
                  <a href="blog-single.html">Read More <span class="mai-chevron-forward text-sm"></span></a>
                </div>
              </div>
            </div>
            <div class="col-lg-3 py-3">
              <div class="card-blog">
                <div class="header">
                  <div class="avatar">
                    <img src="assets/img/person/person_1.jpg" alt="">
                  </div>
                  <div class="entry-footer">
                    <div class="post-author">Sam Newman</div>
                    <a href="#" class="post-date">23 Apr 2020</a>
                  </div>
                </div>
                <div class="body">
                  <div class="post-title"><a href="blog-single.html">What is Business Management?</a></div>
                  <div class="post-excerpt">Lorem, ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
                <div class="footer">
                  <a href="blog-single.html">Read More <span class="mai-chevron-forward text-sm"></span></a>
                </div>
              </div>
            </div>
            <div class="col-lg-3 py-3">
              <div class="card-blog">
                <div class="header">
                  <div class="avatar">
                    <img src="assets/img/person/person_2.jpg" alt="">
                  </div>
                  <div class="entry-footer">
                    <div class="post-author">Sam Newman</div>
                    <a href="#" class="post-date">23 Apr 2020</a>
                  </div>
                </div>
                <div class="body">
                  <div class="post-title"><a href="blog-single.html">What is Business Management?</a></div>
                  <div class="post-excerpt">Lorem, ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
                <div class="footer">
                  <a href="blog-single.html">Read More <span class="mai-chevron-forward text-sm"></span></a>
                </div>
              </div>
            </div>
            <div class="col-lg-3 py-3">
              <div class="card-blog">
                <div class="header">
                  <div class="avatar">
                    <img src="assets/img/person/person_3.jpg" alt="">
                  </div>
                  <div class="entry-footer">
                    <div class="post-author">Sam Newman</div>
                    <a href="#" class="post-date">23 Apr 2020</a>
                  </div>
                </div>
                <div class="body">
                  <div class="post-title"><a href="blog-single.html">What is Business Management?</a></div>
                  <div class="post-excerpt">Lorem, ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
                <div class="footer">
                  <a href="blog-single.html">Read More <span class="mai-chevron-forward text-sm"></span></a>
                </div>
              </div>
            </div>
          </div>
  
          <div class="text-center">
            <a href="blog.html" class="btn btn-primary">View More</a>
          </div>
  
        </div> <!-- .container -->
      </div> <!-- .page-section -->

  
    </main>
  
    <footer class="page-footer">
        <div class="container">
          <div class="row">
            <div class="col-lg-3 py-3">
              <h3>Happy<span class="fg-primary">Share.</span></h3>
            </div>
            <div class="col-lg-3 py-3">
              <h5>Contact Information</h5>
              <p>서울특별시 강남구 강남대로94길 20 삼오빌딩 </p>
              <p>Email: happyshare@mail.com</p>
              <p>Phone: +02 1111-1111</p>
            </div>
            <div class="col-lg-3 py-3">
              <h5>About us</h5>
              <ul class="footer-menu">
                <li><a href="#">Happyshare 소개</a></li>

              </ul>
            </div>
            
          </div>
    
          <hr>
    
          <div class="row mt-4">
            <div class="col-md-6">
              <p>Copyright 2020. This template designed by <a href="https://macodeid.com">MACode ID</a></p>
            </div>
          <!--  <div class="col-md-6 text-right">
           <div class="sosmed-button">
                <a href="#"><span class="mai-logo-facebook-f"></span></a>
                <a href="#"><span class="mai-logo-twitter"></span></a>
                <a href="#"><span class="mai-logo-youtube"></span></a>
                <a href="#"><span class="mai-logo-linkedin"></span></a>
              </div> 
            </div> -->
          </div>
        </div>
      </footer>
    
      
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/owl-carousel/js/owl.carousel.min.js"></script>
    <script src="assets/vendor/wow/wow.min.js"></script>
    <script src="assets/vendor/fancybox/js/jquery.fancybox.min.js"></script>
    <script src="assets/vendor/isotope/isotope.pkgd.min.js"></script>
    <script src="assets/js/google-maps.js"></script>
    <script src="assets/js/theme.js"></script>
    
    </body>
    </html>

  