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
	<!-- <form action="listTogether.do" method="post">
		<select name="searchColumn">
			<option value="t_hit">인기순</option>
			<option value="t_title">제목순</option>
			<option value="t_size">총모집인원순</option>
			<option value="t_open_date">모임개설일순</option>
			<option value="t_place">모임장소순</option>
		</select>: <input type="text" value="keyword">
		<input type="submit" value="검색">
	</form> -->
	<br>
	<table border="1" width="80%">
		<tr>
			<td>썸네일</td>
			<td><a href="listTogether.do?sortColumn=t_title">제목</a></td>
			<td>인트로</td>
			<td>아이디</td>
			<td><a href="listTogether.do?sortColumn=t_size">총모집인원</a></td>
			<td>현재참가인원</td>
			<td><a href="listTogether.do?sortColumn=t_date">모임일</a></td>
			<td><a href="listTogether.do?sortColumn=t_place">모임장소</a></td>
			<td><a href="listTogether.do?sortColumn=t_hit">조회수</a></td>
		</tr>
		<c:forEach var="c" items="${list}">
			<tr>
				<td><img src="thumbnailupload/${c.t_thumbnail}" width="150" height="150"></td>
				<td><a href="detailTogether.do?t_num=${c.t_num }">${c.t_title}</td>
				<td>${c.t_intro}</td>				
				<td>${c.user_id}</td>
				<td>${c.t_size}</td>
				<td>${c.t_attendee_cnt}</td>	
				<td>${c.t_date}</td>	
				<td>${c.t_place}</td>
				<td>${c.t_hit}</td>	
			</tr>
		</c:forEach>
		<hr>
		<c:forEach var="i" begin="1" end="${totalPage}">
			<a href="listTogether.do?pageNum=${i }">${i }</a>&nbsp;&nbsp;
		</c:forEach>
		
	</table>
</body>
</html>