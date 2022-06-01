<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<!-- html5버전으로 만들어진 웹문서 -->
<%@ page import="dao.*,dto.*,java.util.*" %>
<%
	Member_dao dao = new Member_dao();
	
	ArrayList<Member_dto> dtos = dao.getShotList();
	

%>
<html>
	<head>
		<link href="index.css" rel="stylesheet">	
		<title>홍길동</title>
	</head>
	<body>
		<header>
			<h1>(과정평가형정보처리산업기사)코로나 예방접종관리 프로그램 ver2021-09</h1>
		</header>
		<nav>
			<ul>
				<li><a href="sub1.jsp">접종대상조회</a></li>
				<li><a href="sub2.jsp">예방접종등록</a></li>
				<li><a href="sub3.jsp">접종현황조회</a></li>
				<li><a href="sub4.jsp">백신별접종현황</a></li>
				<li><a href="sub5.jsp">지역별접종현황</a></li>
				<li><a href="index.jsp">홈으로</a></li>
			</ul>
		</nav>
		<section>
			<h3>접종현황조회</h3>
	
			<form name="member" >
				<table>
			<colgroup>
					<col style="width:10%;">
					<col style="width:15%;">
					<col style="width:15%;">
					<col style="width:15%;">
					<col style="width:15%;">
					<col style="width:15%;">
				</colgroup>
					<tr>
						<th>접종번호</th>
						<th>고객번호</th>
						<th>고객명</th>
						<th>백신코드</th>
						<th>백신명</th>
						<th>접종일</th>
					</tr>
					<% for(int i = 0; i<dtos.size(); i++) { %>
					<tr>
					<td><%=dtos.get(i).getP_seno()%></td>
					<td><%=dtos.get(i).getNo()%></td>
					<td><%=dtos.get(i).getName()%></td>
					<td><%=dtos.get(i).getI_code()%></td>
					<td><%=dtos.get(i).getI_name()%></td>
					<td><%=dtos.get(i).getP_date()%></td>
					</tr>
					<% } %>
				</table>
			</form>
		
		</section>
		<footer>
			<p>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Developement Service of Korea.</p>
		</footer>
	</body>
</html>