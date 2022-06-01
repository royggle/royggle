<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	Member_dao dao = new Member_dao();
	
	int bun = Integer.parseInt(request.getParameter("bun"));
	String no = request.getParameter("no");
	String inject = request.getParameter("inject");
	String date = request.getParameter("date");
	
	int result = dao.addInjection(bun, no, inject, date);
	String msg = result == 1 ? "예방접종등록 정보가 정상적으로 등록되었습니다!" : "중복되었거나 올바르지 않은 등록번호입니다.";
	
	%>
<!DOCTYPE html>
<html>
<head>
<script>

alert("<%=msg%>");
location.href="sub2.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>