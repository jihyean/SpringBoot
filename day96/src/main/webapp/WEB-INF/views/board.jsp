<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>

<script type="text/javascript">
	function del(bid){
		var ans=confirm("정말 삭제하시겠습니까?");
		if(ans){
			location.href="deleteBoard?bid="+bid;
		}
	}
</script>

<c:if test="${empty data}">
	<h1>해당 게시글은 없거나 이용이 불가능한 게시글입니다!</h1>
</c:if>

<c:if test="${not empty data}">

	<c:if test="${data.mid ne member}">
		<form action="updateBoard" method="post" >
			<input type="hidden" name="bid" value="${data.bid}">
			<input type="text" name="mid" value="${data.mid}" disabled> <br>
			<input type="text" name="content" required value="${data.content}" disabled> <br>
		</form>
	</c:if>

	<c:if test="${data.mid eq member}">
		<form action="updateBoard" method="post" >
			<input type="hidden" name="bid" value="${data.bid}">
			<input type="text" name="mid" value="${data.mid}" disabled> <br>
			<input type="text" name="content" required value="${data.content}"> <br>
			<input type="submit" value="글 변경">&nbsp;&nbsp;&nbsp;<input type="button" onclick="del(${data.bid})" value="글 삭제">
		</form>
	</c:if>

</c:if>
<hr>

<a href="/">메인으로 돌아가기</a>

</body>
</html>