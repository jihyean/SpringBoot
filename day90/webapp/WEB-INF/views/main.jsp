<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kim" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>

   <script type="text/javascript">
      function signUp(){
         // window.open("signUp.jsp","_blank","width=450,height=250");
         location.href="signUp.do";
      }
   </script>
   
   <c:if test="${empty member}">
      <form action="login.do" method="post">
         아이디 <input type="text" name="mid" required> <br>
         비밀번호 <input type="password" name="mpw" required> <br>
         <input type="submit" value="로그인">
      </form>
      <br>
      <form action="signUp.do" method="post">
         아이디 <input type="text" name="mid" required> <br>
         비밀번호 <input type="password" name="mpw" required> <br>
         <input type="submit" value="회원가입">
      </form>
   </c:if>
   <c:if test="${not empty member}">
      <a href="logout.do">로그아웃</a>
      <br>
      <a href="check.do">마이페이지</a>
      <br>
      <form action="insertBoard.do" method="post">
         게시글: <input type="text" name="content" required> <br>
         <input type="submit" value="글 작성">
      </form>
   </c:if>

<hr>

<br>
<c:if test="${fn:length(datas) <= 0}">
	<h1>출력할 게시글이 존재하지않습니다!</h1>
</c:if>
<c:if test="${fn:length(datas) > 0}">
<table border="1">
	<tr>
		<th>글 번호</th><th>글 내용</th><th>작성자</th>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td><a href="board.do?bid=${v.bid}">${v.bid}</a></td><td>${v.content}</td><td>${v.mid}</td>
		</tr>
	</c:forEach>
</table>
</c:if>

</body>
</html>