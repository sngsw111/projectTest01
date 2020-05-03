<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>함께가요 등록</h2>
	<form action="insertTogether.do" method="post" enctype="multipart/form-data">
		글번호 : <input type="number" name="t_num"><br>
		썸네일 : <input type="text" name="t_thumbnail"><br>
		제목 : <input type="text" name="t_title"><br>
		인트로 : <input type="text" name="t_intro"><br>	
		장소 : <input type="text" name="t_place"><br>
		모임일 : <input type="text" name="t_date"><br>
		총인원 : <input type="number" name="t_size"><br>
		상세내용 :<br>
		<textarea rows="10" cols="80" name="t_detail"></textarea><br>
		파일 : <input type="file" name="uploadFile"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form> 	
</body>
</html>