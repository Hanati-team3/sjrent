<%@ page contentType="text/html; charset=UTF-8"%>
<%
String loginId = (String)request.getAttribute("loginId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">


<title>MYPAGE</title>
</head>
<body>

	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="height:33%; ">
	   <h3 class="w3-bar-item" style="padding-left: 30px; vertical-align: middle;">Menu</h3>
	  <a href="/sjrent/rent/list.rent" class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px ">나의예약확인</a>
	  <a href="/sjrent/review/list2.rent" class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">나의리뷰</a>
	  <a href="/sjrent/user/read.rent"  class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">회원정보수정</a>
      <a href="/sjrent/mypage/deleteUser.jsp" class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">회원탈퇴</a>
	</div>
	
</body>
</html>