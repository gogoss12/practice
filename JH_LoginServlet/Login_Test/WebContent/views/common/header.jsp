<%@page import="JH.home.Test.mvc.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member member = (Member)session.getAttribute("loginMember");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
</head>
<body>
	<header>
		<h1>Hello TestLogin</h1>
		<div class = login-container>
		<!-- 로그인 폼 만들어보자 -->
			<%
				if(member == null) {
			%>
			<form id="loginForm" action="<%=request.getContextPath()%>/Login" method = "POST">
				<table>
					<tr>
						<td>
							<label>아이디 : <input type="text" name="userId" id="userId" ></label>
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td>
							<label>패스워드 : <input type="password" name="userPwd" id="userPwd" ></label>
						</td>
						<td>
							<input type="submit" value="로그인">
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" value="회원가입" onclick="location.href ='<%=request.getContextPath()%>/member/enroll';">
						</td>
					</tr>
				</table>
			</form>
			<% } else { %>
			<table>
					<tr>
						<td> <%=member.getTestName()%> 님 안녕하세요</td>
					</tr>
					<tr>
						<td>
							<input type="button" value="마이페이지" >
						</td>
						<td>
							<input type="button" value="로그아웃"
							onclick = "location.replace('<%=request.getContextPath()%>/Logout')">
						</td>
					</tr>
				</table>
			
			<% } %>
		</div>
	</header>