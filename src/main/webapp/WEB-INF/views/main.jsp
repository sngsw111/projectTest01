<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {margin: 0; padding: 0; }
	li {list-style: none; }
	body {font-family: 'Nanum Gothic', sans-serif; width: 1200px; margin: 0 auto; }
	            
	.logo {margin: 50px 0; font-size: 30px; text-align: center; font-family: 'Nanum Brush Script', cursive; }
	            
	.topMenu {width: 100%; margin-bottom: 20px; text-align: center; height: 40px; }
	.topMenu:after {content: ""; display: block; clear: both; }
	.menu01>li {float: left; width: 16%; line-height: 40px; }
	.menu01 span {font-size: 20px; font-weight: bold; }
	            
	.dept01 {display: none; padding: 20px 0; border-bottom: 1px solid #ccc; }
	            
	#nop {float: none; }
	            
	.none:after {content: ""; display: block; clear: both; }
	
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).on('mouseover', '.topMenu span', function() {
	    $('.dept01').slideDown(300);
	});
	$(document).on('mouseover', 'div', function () {
	    if (!$(this).hasClass('topMenu')) {
	        $('.dept01').slideUp(300);
	    }
	});
</script>
</head>
<body>
	<div class="logo">
		<span class="logo">펫위고 PET WE GO</span>
	</div>
	<div class="topMenu">
		<ul class="menu01">
			<li><span>마이펫</span>
				<ul class="dept01">
					<li>소제목1</li>
				</ul>
			</li>
			<li><span>숙소찾기</span>
				<ul class="dept01">
					<li>소제목1</li>
				</ul>
			</li>
			<li><span>자유게시판</span>
				<ul class="dept01">
					<li>소제목1</li>
				</ul>
			</li>
			<li><span>함께가요</span>
				<ul class="dept01">
					<li>소제목1</li>
				</ul>
			</li>
			<li><span>고객지원</span>
				<ul class="dept01">
					<li>소제목1</li>
				</ul>
			</li>
			<li><span>로그인</span>
				<ul class="dept01"></ul>
			</li>
		</ul>
	</div>
	 <div class="none">
     </div>
</body>
</html>