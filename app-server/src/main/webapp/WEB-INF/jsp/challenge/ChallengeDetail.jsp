<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="page-banner bg-img bg-img-parallax overlay-dark"
	style="background-image: url(${contextPath}/images/challenge_bg.jpg;">
	<div class="container h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col-lg-8">
				<nav aria-label="breadcrumb">
					<ol
						class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
						<li class="breadcrumb-item"><a href="${contextPath}/app/home">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">챌린지</li>
					</ol>
				</nav>
				<h1 class="fg-white text-center">상세정보</h1>
			</div>
		</div>
	</div>
</div>
<!-- .page-banner -->

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 스크롤 js -->

<main>
	<div class="page-section">
		<div class="container">
			<div class="challgne-item">
				<p class="challgne-type bu">비대면</p>
				<h3>${challengeDTO.title}</h3>
			</div>
			<div class="chall-detail">
				<div class="chall-de-img">
					<img src="${contextPath}/upload/challenge/${challengeDTO.photo}" alt="챌린지 상세 이미지" />
				</div>
				<!-- //vol-de-img -->
				<div class="vol-infor-wrap">
					<!-- vol-joiner -->
					<div class="chall-joiner" style="padding: 25px;">
					 <span>
							<span class="sr-only">참여인원</span>
	              <b class="vol-count">0명</b> /
	            <span class="sr-only">총 모집인원</span> 50명
						</span>
						<div class="progress" style="margin-top: 12px;">
							<div class="progress-bar progress-bar-striped" role="progressbar"
								style="width: 10%" aria-valuenow="10" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>

            <!-- 모달 창 -->
						<div class="modal fade" id="myModalJoin${vs.index}"
							role="dialog">
							<!-- 사용자 지정 부분① : id명 -->
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">참여자 목록</h4>
										<!-- 사용자 지정 부분② : 타이틀 -->
										<button type="button" class="close" data-dismiss="modal">×</button>
									</div>
									<div class="modal-body">
										<c:forEach items="${joinUser}" var="JoinDTO" varStatus="vs">
											<div class="class" id="id" style="display: none">
												<label for='f-no'>챌린지번호</label> <input id='f-no' type='text'
													name='no' value='${challengeDTO.no}' readonly> <br>
											</div>
											<label for='f-member'>참여자</label>
											<span id='f-member'>${JoinDTO.id}</span>
											<br>

											<label for='f-registeredDate'>등록일</label>
											<span id='f-registeredDate'>${JoinDTO.registerDate}</span>
											<br>
										</c:forEach>
									</div>
									<div class="modal-footer"></div>
								</div>
							</div>
						</div>
						<!-- 모달 창 -->
						&nbsp;&nbsp;<a data-toggle="modal" class="btn btn-outline-secondary open btn-sm"
							style=" display:block; margin-top:18px;" href="#myModalJoin${vs.index}">[참여자 보기]</a>
					</div>

					<div class="vol-detail-infor" style="height:290px">
						<ul>
						  <li class="do-d-day" style="margin-bottom:10px;">D-day ${challengeDTO.remainDate}</li>
							<li><span>모집기간</span> <span>${challengeDTO.startDate}~${challengeDTO.endDate}</span><span style="padding-left:5px;">총
									${challengeDTO.totalDate}일</span></li>
							<li><span>참여기간</span> <span>${challengeDTO.startDate}~${challengeDTO.endDate}</span>
							</li>
							<li>
								<p>획득 포인트:100포인트</p>
							</li>
						</ul>
						<form action="joinAdd" method="post">
							<div class="class" id="id" style="display: none">
								<label for='f-no'>챌린지번호</label> <input id='f-no' type='text'
									name='no' value='${challengeDTO.no}' readonly>
							</div>
							<br>
							<button class="btn btn-secondary">참여하기</button>
						</form>
					</div>
				</div>
				<!-- //vol-infor-wrap -->
			</div>
			<!-- //vol-detail -->

			<div class="vol-con-wrap">
			 <div class="widget">
					<div class="widget-box w-box2">
						<h1 class="widget-title" style="padding-top: 30px;"
							id="scroll-section1">상세정보</h1>
						<div class="content-box">${challengeDTO.content}</div>
					</div>
				</div>
				<div class="widget-box w-box2">
					<a href='reviewList?no=${challengeDTO.no}#section2'>
						<h4 class="widget-title" style="padding-top: 30px;">참여인증&댓글</h4>
					</a>
				</div>
				<div class="widget-box w-box2">
					<a href='questionList?no=${challengeDTO.no}#section3'>
						<h4 class="widget-title" style="padding-top: 30px;"
							id="scroll-section2">문의하기</h4>
					</a>
				</div>
			</div>
		</div>

		<div class="btn-regi">
			<button type="submit" class="btn btn-primary nBtn">참여하기</button>
			<input type="button" class="btn btn-outline-primary nBtn" value="이전"
				onClick="history.go(-1)" role="button">
		</div>
	</div>
	<!-- //container -->
	<!-- //page-section -->

	<script>
		$(document).ready(function() {
			var page_url = window.location.href;
			var page_id = page_url.substring(page_url.lastIndexOf("#") + 1);
			// alert(page_id); 
			if (page_id == 'section1') {
				$('html, body').animate({
					scrollTop : $('#scroll-' + page_id).offset().top
				}, 500);
			} else if (page_id == 'section2') {
				$('html, body').animate({
					scrollTop : $('#scroll-' + page_id).offset().top
				}, 500);
			} else if (page_id == 'section3') {
				$('html, body').animate({
					scrollTop : $('#scroll-' + page_id).offset().top
				}, 500);
			}
		});
	</script>
</main>
</body>
</html>
