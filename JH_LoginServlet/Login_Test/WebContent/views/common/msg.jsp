<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	String location = (String)request.getAttribute("location");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		// 알림메세지
		alter("<%= msg %>")
		
		//이동
		location.replace(<%= request.getContextPath()%><%= location %>);
	
	</script>	
</body>
</html>