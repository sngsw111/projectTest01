<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 수정</h2>
	<form action="updateTogether.do" method="post">
		글번호 : <input type="number" name="t_num" value="${t_num }"><br>
		썸네일 : <input type="text" name="t_thumbnail" value="${t_thumbnail }"><br>
		제목 : <input type="text" name="t_title" value="${t_title }"><br>
		인트로 : <input type="text" name="t_intro" value="${t_intro }"><br>	
		장소 : <input type="text" name="t_place" value="${t_place }"><br>
		모임일 : <input type="text" name="t_date" value="${t_date }"><br>
		총인원 : <input type="number" name="t_size" value="${t_size }"><br>
		상세내용 :<br>
		<textarea rows="10" cols="80" name="t_detail" value="${t_detail }"></textarea><br>
		파일 : <input type="text" name="t_fname" value="${t_fname }"><br>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form> 	
</body>
</html>