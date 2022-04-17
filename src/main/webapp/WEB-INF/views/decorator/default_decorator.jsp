<!-- sitemesh 사용을 위한 설정 파일 -->
<%@page import="com.project.member.vo.LoginVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
LoginVO loginVO = (LoginVO) session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>플젝:<decorator:title /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- CDN 방식의 Gogle Icon 라이브러리 등록 -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!-- jQuery UI 라이브러리 CDN 방식으로 등록 -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

<style type="text/css">
header, footer {
	background: AntiqueWhite;
}

pre {
	background: white;
	border: 0px;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: black;
	padding: 25px;
	color: #ddd;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

article {
	min-height: 400px;
	margin-top: 80px;
}

#welcome {
	color: grey;
	margin: 0 auto;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
<decorator:head/>
</head>
<body>
	<header>
<!-- 		<div><img href="#"/></div> -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/">Logo</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="/notice/list.do">공지사항</a></li>
						<li><a href="/image/list.do">이미지</a></li>
						<li><a href="/board/list.do">게시판</a></li>
						<li><a href="/qna/list.do">질문답변</a></li>
						<% if(loginVO != null) { %>
							<li><a href="/message/list.do">메시지</a></li>
						<% } %>			
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<% if(loginVO == null){ %>
							<li><a href="/member/write.do">회원가입</a></li>
							<li><a href="/member/login.do">로그인</a></li>
						<% } else { %>
							<li><a href="/member/view.do">
									<%= loginVO.getName() %>(<%= loginVO.getGradeName() %>)
							</a></li>
							<li><a href="/member/logout.do">로그아웃</a></li>
						<% } %>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<article>
		<decorator:body />
	</article>
	<footer class="container-fluid text-center navbar navbar-inverse navbar-fixed-bottom">
	</footer>
</body>
</html>