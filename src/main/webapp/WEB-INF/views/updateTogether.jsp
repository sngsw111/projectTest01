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
	<form action="updateTogether.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="t_num" value="${t.t_num }">
		<input type="hidden" name="t_fname" value="${t.t_fname }">
		<%-- 글번호 : <input type="number" name="t_num" value="${t.t_num }"><br> --%>
		썸네일 : <input type="file" name="thumbnailFile"><br>
		제목 : <input type="text" name="t_title" value="${t.t_title }"><br>
		인트로 : <input type="text" name="t_intro" value="${t.t_intro }"><br>	
		장소 : <input type="text" name="t_place" value="${t.t_place }"><br>
		모임일 : <input type="date" name="t_date" value="${t.t_date }"><br>
		총인원 : <input type="number" name="t_size" value="${t.t_size }"><br>
		글내용 :<br>
		<textarea rows="10" cols="80" name="t_detail">${t.t_detail }</textarea><br>
		<img src="togetherupload/${t.t_fname }" width="50" height="50"><br>
		파일 : <input type="file" name="uploadFile"><br>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form> 	
</body>
</html>