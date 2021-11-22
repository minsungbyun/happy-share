<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="page-banner bg-img bg-img-parallax overlay-dark"
	style="background-image: url(../../assets/img/bg_image_3.jpg);">
	<div class="container h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col-lg-8">
				<nav aria-label="breadcrumb">
					<ol
						class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
						<li class="breadcrumb-item"><a href="#"
							style="font-size: 20px;">함께해요</a></li>
						<li class="breadcrumb-item active" aria-current="page"
							style="font-size: 22px;">봉사목록</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</div>
<!-- //page-banner -->

<main>
	<div class="page-section">
		<div class="container">
			<h3 class="widget-title">${volunteer.title}</h3>
			<div class="vol-detail">
				<div class="vol-de-img">
					<img src="../assets/img/201612011168_500.jpg" alt="함께해요 상세 이미지" />
				</div>
				<div class="vol-infor-wrap">
					<!-- vol-joiner -->
					<div class="vol-joiner">
						<div style="padding: 10px;">
							<span class="vol-cur"> <span class="sr-only">참여인원</span> <b
								class="vol-count">${volunteer.currentNum}명</b> / <span
								class="sr-only">총 모집인원</span> ${volunteer.limitNum}명
							</span>
							<div class="progress">
								<div class="progress-bar progress-bar-striped"
									role="progressbar" style="width: 10%" aria-valuenow="10"
									aria-valuemin="0" aria-valuemax="100"></div>
							</div>
							<input type="hidden" id="volunteerNo" value="${volunteer.no}" />
							<button type="button" class="btn btn-primary open" id="btn-modal">봉사
								참여자 목록</button>
						</div>
					</div>
					<!-- //vol-joiner -->

					<!-- vol-owner -->
					<div class="vol-owner">
						<!-- vol-owner -->
						<div class="social-mini-button">
							<span class="owner-right"><span>주최자</span> : <b>${volunteer.owner.id}</b></span>
							<span class="owner-right">${volunteer.tel}</span> <span
								class="owner-right">${volunteer.email}</span>
						</div>
					</div>
					<!-- //vol-owner -->

					<!-- vol-detail-infor -->
					<div class="vol-detail-infor">
						<ul>
							<li><span>봉사기간</span> : <span>${volunteer.startDate}
									~ ${volunteer.endDate}</span><span>총
									${volunteerDate.totalDate}일</span></li>
							<li><span>봉사시간</span> : <span>${volunteer.startTime}
									~ ${volunteer.endTime}</span></li>
							<li>D-day ${volunteerDate.remainDate}일</li>
						</ul>
						<a href="join/form?no=${volunteer.no}"
							class="btn btn-primary open" role="button">참여하기</a>
					</div>
					<!-- //vol-detail-infor -->
				</div>
				<!-- //vol-infor-wrap -->

				<!-- modal -->
				<div id="vol-modal" class="vol-modal-overlay">
					<div class="vol-modal-window ">
						<div class="close-area">X</div>
						<div class="vol-title">
							<h1>[ 참여자 목록 ]</h1>
						</div>
						<div class="vol-content">
							<table>
								<thead>
									<tr>
										<th>번호</th>
										<th>아이디</th>
										<th>이름</th>
										<th>시작시간</th>
										<th>신청일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${volunteerList}" var="volunteerJoinDTO">
										<tr>
											<td>${volunteerJoinDTO.volunteer.no}</td>
											<td>${volunteerJoinDTO.joinUser.id}</td>
											<td>${volunteerJoinDTO.joinUser.name}</td>
											<td>${volunteerJoinDTO.startTime}</td>
											<td>${volunteerJoinDTO.registeredDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<%-- <button type="button" class="btn btn-primary" data-toggle="modal" onclick="location.href='join/list?no=${volunteer.no}'" >참여자목록</button>--%>
						</div>
					</div>
				</div>
				<!-- //modal -->
			</div>
			<!-- //vol-detail -->

			<!-- tabArea -->
			<div class="tabArea" style="margin-top: 35px; display: flex; justify-content: center; text-align: center;">
				<div class="vol-con-wrap tab">
				  <ul class="tab">
				    <li class="on"></li>
				    <li></li>
				    <li></li>
						<button class="btn btn-primary on" type="button" id="i-box1"
							data-target="#i-box1">상세정보</button>
						<button class="btn btn-primary" type="button" id="i-box2"
							data-target="#i-box2">참여인증 / 댓글</button>
						<button class="btn btn-primary" type="button" id="i-box3"
							data-target="#i-box3">위치</button>
				  </ul>
				</div>
				<!-- //tab -->
			</div>
			<!-- //tabArea -->

			<!-- s-box1 -->
			<div id="s-box1" class="vol-con-wrap">
				<h3 class="widget-title" id="scroll-section1"
					style="padding-top: 30px;">상세정보</h3>
				<div class="col-lg-12">
					<div class="widget">
						<div class="widget-box">
							<form action="#" class="form-contact" method="post"
								enctype="multipart/form-data" name="form">
								<div class="row">
									<div class="col-sm-12 py-2">
										<label for="no" class="fg-grey" type="hidden">번호</label> <input
											type="number" class="form-control" id="no" name="no"
											value="${volunteer.no}" readonly>
									</div>
									<!-- //번호 -->
									<div class="col-sm-12 py-2">
										<label for="title" class="fg-grey">제목</label> <input
											type="text" class="form-control" id="title" name="title"
											value="${volunteer.title}" readonly>
									</div>
									<!-- //제목 -->
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">전화번호</label> <input
											type="text" class="form-control" id="tel" name="tel"
											value="${volunteer.tel}" readonly>
									</div>
									<!-- //전화번호 -->
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">이메일</label> <input
											type="email" class="form-control" id="email"
											value="${volunteer.email}" readonly>
									</div>
									<!-- //이메일 -->
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">시작일</label> <input
											type="text" class="form-control" id="startDate"
											value="${volunteer.startDate}" readonly>
									</div>
									<!-- //시작일 -->
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">종료일</label> <input
											type="text" class="form-control" id="endDate"
											value="${volunteer.endDate}" readonly>
									</div>
									<!-- //종료일 -->
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">시작시간</label> <input
											type="text" class="form-control" id="startTime"
											value="${volunteer.startTime}" readonly>
									</div>
									<!-- //시작시간 -->
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">종료시간</label> <input
											type="text" class="form-control" id="endTime"
											value="${volunteer.startTime}" readonly>
									</div>
									<!-- //종료시간 -->
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">총모집인원</label> <input
											type="text" class="form-control" id="limitNum"
											value="${volunteer.limitNum}" readonly>
									</div>
									<!-- //총모집인원 -->
									<div class="col-12 py-2">
										<label for="content" class="fg-grey">내용</label>
										<textarea id="content" rows="8" class="form-control">${volunteer.content}</textarea>
									</div>
									<!-- //내용 -->
								</div>
								<!-- //row -->
							</form>
						</div>
						<!-- //widget-box -->
					</div>
					<!-- //widget -->
				</div>
				<!-- //col-lg-12 -->
			</div>
			<!-- //s-box1 -->

			<!-- s-box2 -->
			<div id="s-box2" class="vol-con-wrap">
				<h3 class="widget-title" id="s-section1" style="padding-top: 30px;">
					참여인증 / 댓글</h3>
				<div class="col-lg-12">
					<div class="widget">
						<div class="widget-box">
							<!-- cont-short-list -->
							<div class="cont-short-list">
								<c:forEach items="${volunteerShortReviewList}"
									var="volunteerShortReviewDTO">
									<div class="s-review-list">
										<div class="review-view">
											<ul>
												<li>
													<div class="review-section">
														<div class="profile-thumb">
															<img src="${contextPath}/assets/img/level.png"
																alt="프로필사진">
														</div>
														<div class="review-infor">
															<div class="review-post">
																<div class="profile-infor">
																	<span>${volunteerShortReviewDTO.owner.id}</span> <span
																		class="txt_date">${volunteerShortReviewDTO.registeredDate}</span>
																	<%-- <span class="ico_bbs ico_new">새글</span>--%>
																</div>
																<div class="review-post">
																	<p>
																		<span>${volunteerShortReviewDTO.content}</span>
																	</p>
																</div>
																<div class="review-btn">
																	<a href='reviewUpdate?no=${volunteerShortReviewDTO.no}'
																		class="link_menu">[수정]</a> <a
																		href='reviewDelete?no=${volunteerShortReviewDTO.no}'
																		class="link_menu">[삭제]</a>
																</div>
															</div>
														</div>
													</div>
												</li>
											</ul>
										</div>
									</div>
								</c:forEach>
							</div>
							<!-- //cont-short-list -->

							<button class="btn btn-primary" type="button"
								onclick="location.href='reviewList?no=${volunteer.no}'">상세정보</button>
							<!-- col-12 -->
							<div class="col-12 my-5">
								<nav aria-label="Page Navigation">
									<ul class="pagination justify-content-center">
										<li class="page-item disabled"><a class="page-link"
											href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
										</li>
										<li class="page-item"><a class="page-link" href="#">2</a>
										</li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
										<li class="page-item"><a class="page-link" href="#">Next</a>
										</li>
									</ul>
								</nav>
							</div>
							<!-- //col-12 -->
						</div>
						<!-- //widget-box -->
					</div>
					<!-- //widget -->
				</div>
				<!-- //col-lg-12 -->
			</div>
			<!-- //s-box2 -->

			<!-- s-box3 -->
			<div id="s-box3" class="vol-con-wrap">
				<h3 class="widget-title" id="s-section1" style="padding-top: 30px;">
					위치</h3>
				<div class="col-lg-12">
					<div class="widget">
						<div class="widget-box">
							<div id="map"
								style="width: 700x; height: 400px; align-items: center"></div>

						</div>
						<!-- //widget-box -->
					</div>
				</div>
			</div>
			<!-- //s-box3 -->
			<button type="button" class="btn btn-primary nBtn"
				onclick="history.go(-1)">이전</button>
			<button type="button" class="goupbtn" onclick="goTop()">맨 위로</button>
		</div>
		<!-- //container -->
	</div>
	<!-- //page-section -->
</main>
<!-- //main -->

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=957738e74b502a9fe5576d94da13113d"></script>

<script>
function goTop(){
	  $('html').scrollTop(0);
	}
</script>



<script>
$(".menu li").click(function() {
	  var scrollPosition = $($(this).attr("data-target")).offset().top;

	  $("body").animate({
	        scrollTop: scrollPosition
	  }, 500);
	}
</script>

<script>
	function checkValue() {
		var content = document.querySelector("#f-content");

		if (content.value == "") {
			alert("내용을 입력해주세요");
			return false;
		}
	}
</script>
<script>
	var volunteerNo = document.querySelector("#volunteerNo");
	var no = volunteerNo.textContent;
	function joinMember() {
		location.href = "join/list?no=" + no
	}
</script>
<script>
	var container = document.getElementById('map');
	var options = {
		center : new kakao.maps.LatLng(37.49950381717442, 127.02906340621007),
		level : 3
	};
	var map = new kakao.maps.Map(container, options);
	var markerPosition = new kakao.maps.LatLng(37.49950381717442,
			127.02906340621007);
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position : markerPosition
	});
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	var iwContent = '<div style="padding:5px;">여기야여기! <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
	iwPosition = new kakao.maps.LatLng(37.49950381717442, 127.02906340621007); //인포윈도우 표시 위치입니다
	// 인포윈도우를 생성합니다
	var infowindow = new kakao.maps.InfoWindow({
		position : iwPosition,
		content : iwContent
	});
	// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
	infowindow.open(map, marker);
</script>