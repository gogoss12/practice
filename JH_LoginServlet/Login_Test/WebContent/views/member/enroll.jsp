<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

<section id="content">
	<h2 align="center">회원가입 페이지</h2>
	<div id ="enroll-container">
	<form name="memberEnrollFrm" action="<%= request.getContextPath()%>/member/enroll" method="POST">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="userId" id="newId" placeholder="아이디(4글자이상)" required>
					<input type="button" id="checkDuplicate" value="중복검사">
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="userPwd" id="pass1" required>
				</td>
			</tr>
			<tr>
				<th>패스워드 확인</th>
				<td>
					<input type="password" id="pass2">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="userName" id="userName" required>
				</td>
			</tr>
			<tr>
				<th>휴대전화</th>
				<td>
					<input type="tel" placeholder="(-없이)0123456789" name="phone" id="phone" maxlength="11">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text"  name="address" id="address">
				</td>
			</tr>
		</table>
		<input type="submit" id="enrollSubmit" value="회원가입">
		<input type="reset" value="취소">
	</form>
	<form name="checkIdForm">
		<input type="hidden" name="userId">
	</form>
	</div>
</section>
<%@ include file="/views/common/footer.jsp" %>