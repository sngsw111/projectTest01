<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>함께가요 상세</h2>
	<hr>
	작성자 : ${t.user_id }<br>
	장소 : ${t.t_place }<br>
	모임일 : ${t.t_date }<br>
	첨부파일 :${t.t_fname }<br>
	글내용 :<br>
	<textarea rows="10" cols="80" readonly="readonly">${t.t_detail }</textarea><br>
	<a href="updateTogether.do?t_num=${t.t_num }">수정</a>
	<a href="deleteTogether.do?t_num=${t.t_num }">삭제</a>
	<a href="insertTogetherComment.do?t_num=${t.t_num }">답글</a>
</body>
</html>