<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
      
    <main>
      <div class="page-section">
        <div class="container">
          <div>
            <h1 class="title-h">로그인</h1>
            <form action="login" class="login-form" method="post" onsubmit="return checkValue()">
              <div class="form-group fo">
                <label for='f-id' class="sr-only">아이디</label> 
                <input id='f-id' class="form-control" type='text' name='id' placeholder="아이디" value="${cookie.id.value}"><br>              
              </div>
              <!-- //아이디 -->
              <div class="form-group fo">
                <label for='f-password' class="sr-only">비밀번호</label> 
                <input id='f-password' class="form-control" type='password' name='password' placeholder="비밀번호"><br>           
              </div>
              <!-- //비밀번호 --> 
              <div class="form-group form-check">
<<<<<<< HEAD:app-server/src/main/webapp/auth/Login.jsp
                <input type="checkbox" class="form-check-input" id="exampleCheck1" name="saveId" ${not empty cookie.id ? "checked" : ""}>
=======
                <input type="checkbox" class="form-check-input" id="exampleCheck1" name="saveId"  ${not empty cookie.id ? "checked" : ""}>
>>>>>>> 927a6172a1e99a6e899b3348ac4001899ce67632:app-server-backup/src/main/webapp/auth/Login.jsp
                <label class="form-check-label" for="exampleCheck1">아이디 저장하기</label>
              </div>              
              <!-- //아이디 저장하기 -->
              
              <button type="submit" class="btn btn-primary btn-md btn-block" id="login" style="border-radius: 40px;">로그인</button>
              <div style="margin: 15px auto;" class="social-mini-button">
                <a href="#"><span>아이디 찾기</span></a> 
                <a href="#"><span>비밀번호 찾기</span></a>
              </div>
              <div class="loginSns">
                <a href="" class="sns-login-button sns01" snstype="naver">
                  <s></s>
                  <span>네이버 계정으로 로그인</span>
                </a>
  
                <a href="" class="sns-login-button sns02" snstype="kakao">
                  <s></s>
                  <span>카카오 계정으로 로그인</span>
                </a>
  
                <a href="" class="sns-login-button sns03" snstype="google">
                  <s></s>
                  <span>구글 계정으로 로그인</span>
                </a>
              </div> <!--//loginSns -->
             </form>
            </div>
          </div>  <!-- //container -->
        </div>  <!-- //아이디 찾기 -->
    </main>
	<script type="text/javascript">
    
        function checkValue() {
        	
        	var check = document.querySelector("#login");
          check.onclick = function() {
            alert("테스트");
            return false;
          }
        	
        	
        	
            if(!document.login.id.value) {
                alert("아이디를 입력하세요.");
                return false;
            }
            
            if(!document.login.password.value) {
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            
        }     
  </script>
  </body>

    
	
	
    