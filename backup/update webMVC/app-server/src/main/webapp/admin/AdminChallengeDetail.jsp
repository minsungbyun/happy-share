<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>챌린지상세</title>
  <style>
  label {
    margin-right: 5px;
    text-align: right;
    display: inline-block;
    width: 60px;
  }
  </style>
</head>
<body>
<h1>챌린지 상세</h1>
<form action='update'>
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
</form>

</body>
</html>