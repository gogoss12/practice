<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<form id="loginForm">
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
							<input type="button" value="로그인">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</header>