<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>함께가요</h2>
	<form action="listTogether.do" method="post">
		<select name="searchColumn">
			<option value="t_place">주소</option>
		</select>: <input type="text" value="keyword">
		<input type="submit" value="검색">
	</form>
	<br>
	<table border="1" width="80%">
		<tr>
			<td>썸네일</td>
			<td>제목</td>
			<td>인트로</td>
			<td>아이디</td>
			<td>총참가인원</td>
			<td>현재참가인원</td>
			<td><a href="listTogether.do?sortColumn=t_place">모임장소</a></td>
		</tr>
		<c:forEach var="c" items="${list}">
			<tr>
				<td>${c.t_img}</td>
				<td>${c.t_title}</td>
				<td>${c.t_intro}</td>				
				<td>${c.user_id}</td>
				<td>${c.t_size}</td>
				<td>${c.t_attendee_cnt}</td>	
				<td>${c.t_place}</td>
			</tr>
		</c:forEach>
		
		
	</table>
</body>
</html>