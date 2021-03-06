<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <div class="ad-main">
      <div class="ad-main-infor">
        <!-- serch -->
        <div class="serch">
          <label for="inforSerch">검색</label>
          <input type="text" class="" id="inforSerch">
          <button type="submit" class="searchBtn">검색</button>
        </div>
        <!-- //serch -->
        <div class="table01">
          <table class="table">
            <thead>
              <tr>
               <th scope="col">
                 <input type="checkbox">
               </th>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">시작일</th>
                <th scope="col">종료일</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${challengeList}" var="challengeDTO">
              <tr>
                <td><input type="checkbox" class="select-box"></td>
                <td>${challengeDTO.no}</td>
                <td><a href='detail?no=${challengeDTO.no}'>${challengeDTO.title}</td>
                <td>${challengeDTO.startDate}</td>
                <td>${challengeDTO.endDate}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <div class="ad-btn">
            <a href="form" class="btnSubmit">등록</a>
            <a href="#" class="btnSubmit">수정</a>
            <a href='delete?no=${challengeDTO.no}' class="btnSubmit">삭제</a>
          </div>
        </div>
        <!-- //table01 -->
      </div>
      <!-- //form -->
    </div>
    <!-- //ad-main -->
    
