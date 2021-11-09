<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>모금함 개설신청 양식</title>
	<style>
	label {
		margin-right: 5px;
		text-align: right;
		display: inline-block;
		 width: 100px;
	 }
	</style>
</head>
<body>
<h1>모금함 개설신청 양식(MVC)</h1>
<form action='boardAdd' method="post">
<c:forEach items="${categorys}" var="category">
    <label for='f-category'>${category.title}</label> 
    <input id='f-category' type='radio' name='category' value="${category.no}"><br>
</c:forEach>
    
    <br>
    <label for='f-leader'>주최자</label> 
    <input id='f-leader' type="number" name='leader'><br>
    
    <label for='f-title'>제목</label> 
    <input id='f-title' type='text' name='title'><br>
    
    <label for='f-content'>내용</label> 
    <input id='f-content' type='text' name='content'><br>
    
    <label for='f-tel'>전화</label> 
    <input id='f-tel' type='tel' name='tel'><br>
    
    <label for='f-email'>이메일</label> 
    <input id='f-email' type='email' name='email'><br>
    
    <%-- 
    <label for='f-file'>첨부파일</label> 
    <input id='f-file' type="file" name='fileUpload'><br>
    --%>
    <label for='f-startDate'>시작일</label> 
    <input id='f-startDate' type="date" name='startDate'><br>
    
    <label for='f-endDate'>종료일</label> 
    <input id='f-endDate' type="date" name='endDate'><br>
    
    <label for='f-taget'>목표금액</label> 
    <input id='f-taget' type="number" name='moneyTarget'><br>
<button id='donation-Button'>등록</button><br>
</form>

<script>
document.querySelector("#donation-Button").onclick = () => {
    var startDate = document.querySelector("#f-startDate");
    var endDate = document.querySelector("#f-endDate");
    if (startDate.value >= endDate.value) {
      alert("시작일이 종료일보다 같거나 클 수 없습니다.");
      return false; 
    } 
  }
  
</script>

</body>
</html>
     