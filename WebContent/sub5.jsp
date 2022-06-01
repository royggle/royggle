<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<!-- html5버전으로 만들어진 웹문서 -->
<%@ page import="dao.*,dto.*,java.util.*" %>
<%
	Member_dao dao = new Member_dao();

	ArrayList<Member_dto> dtos = dao.getAreaList();
	int total = 0;
	int total_shot = 0;
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
			<h3> 지역별접종현황</h3>
	
			<form name="member" >
				<table>
				<colgroup>
					<col style="width:10%;">
					<col style="width:20%;">
					<col style="width:20%;">
					<col style="width:20%;">
					<col style="width:*;">
				</colgroup>
					<tr>
						<th>지역코드</th>
						<th>지역명</th>
						<th>접종대상인원</th>
						<th>접종완료인원</th>
						<th>접종률</th>
					</tr>
					<%for(int i = 0; i< dtos.size(); i++) { %>
					<tr>
						<td><%=dtos.get(i).getCity() %></td>
						<td><%=dtos.get(i).getName() %></td>
						<td><%=dtos.get(i).getTotal_number() %></td>
						<td><%=dao.getAreaNumber(dtos.get(i).getCity()) %></td>
						<% double percentile = 
						(dao.getAreaNumber(dtos.get(i).getCity())*1000.00/(dtos.get(i).getTotal_number()));
						total += dtos.get(i).getTotal_number();
						total_shot += dao.getAreaNumber(dtos.get(i).getCity());
						%>
						<td><%=((int)percentile)/10.0%></td>
					</tr>
					<% } %>					
					<tr>
					<% double total_rate = total_shot*10000/total; %>
						<td colspan="4">전체접종현황</td>
						<td><%=((int)total_rate)/100.00%></td>
					</tr>

					
				</table>
			</form>
		
		</section>
		<footer>
			<p>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Developement Service of Korea.</p>
		</footer>
	</body>
</html>