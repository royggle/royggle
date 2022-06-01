<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String bun = request.getParameter("bun");
	String no = request.getParameter("no");
	String inject = request.getParameter("inject");
	String date = request.getParameter("date");

%>
<!doctype html>
<!-- html5버전으로 만들어진 웹문서 -->
<html>
	<head>
		<link href="index.css" rel="stylesheet">	
		<title>홍길동</title>
	</head>
	
	<script type="text/javascript">
	function check() {
		if(member.bun.value=="") {
			alert("예방접종이력번호가 입력되지 않았습니다.");
			member.bun.focus();
			return;
		}
		if(member.no.value=="") {
			alert("고객번호가 입력되지 않았습니다.");
			member.no.focus();
			return;
		}
		if(member.inject.value=="") {
			alert("백신명이 선택되지 않았습니다.");
			member.inject.focus();
			return;
		}
		if(member.date.value=="") {
			alert("접종일자가 입력되지 않았습니다.");
			member.date.focus();
			return;
		}
		member.method="post";
		member.action="db_member_add.jsp";
		member.submit();
	}

	
	function goCancel(){
		alert("정보를 지우고 처음부터 다시 입력합니다.");
		//member.bun.value="";
		//member.no.value="";
		//member.inject.checked=false;
		//member.date.value="";
		//console.log(member.inject.checked);
		//
		member.bun.focus();
	}
	//
	
	
	
	
	
	</script>
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
			<h3>예방접종등록 등록/ 수정</h3>
	
			<form name="member" >
				<table>
				<colgroup>
					<col style="width:40%;">
					<col style="width:70%;">
				</colgroup>
					<tr>
						<th>접종번호</th>
						<td class="text_left"><input type="text" size="7" name="bun">예)20210001</td>
					</tr>
					<tr>
						<th>고객번호</th>
						<td class="text_left"><input type="text" size="4" value="" name="no"></td>
					</tr>
					<tr>
						<th>백신</th>
						<td class="text_left">
							
							<input name="inject" value="A001" type="radio" >아스트라제네카
							<input name="inject" value="A002" type="radio" >얀센
							<input name="inject" value="A003" type="radio" >화이자
							<input name="inject" value="A004" type="radio" >모더나
						</td>
					</tr>
					<tr>
						<th>접종일자</th>
						<td class="text_left"><input type="text" size="6" name="date"></td>
					</tr>
					<tr>
						<td colspan="2" class="col2">
							<input type="button" onclick="check()" value="등록">
							<input type="button" onclick="check()" value="수정">
							<input type="reset" onclick="goCancel()" value="다시쓰기">
						</td>
					</tr>					
				</table>
			</form>
		
		</section>
		<footer>
			<p>HRDKOREA Copyright &copy; All rights Reserved. Human Resources Developement Service of Korea.</p>
		</footer>
	</body>
</html>