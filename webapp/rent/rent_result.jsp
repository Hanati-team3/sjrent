<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="../common/commoncss.jsp" />
   <jsp:include page="../common/commonjs.jsp" />
   
<script type="text/javascript">
/* 새로고침 막기 */
function noEvent() {
	if (event.keyCode == 116) {
		event.keyCode= 2;
		return false;
	}
	else if(event.ctrlKey && (event.keyCode==78 || event.keyCode == 82)){
		return false;
	}
}
document.onkeydown = noEvent;
</script>
</head>
<body class="tg-home tg-homevone">

<!--************************************
			Nav 시작
	*************************************-->
<jsp:include page="../include/nav.jsp" />
<!--************************************
			Nav 종료
	*************************************-->

<!--************************************
			Wrapper 시작
	*************************************-->
<div id="tg-wrapper" class="tg-wrapper tg-haslayout">

<!--************************************
			Header 시작
*************************************-->
<jsp:include page="../include/header.jsp" />
<!--************************************
			Header 종료
*************************************-->

<!--************************************
			Main 시작
*************************************-->
<main id="tg-main" class="tg-main tg-sectionspace tg-haslayout tg-bglight">
	<div class="container">
		<div class="row">
			<div class="tg-homebannerslider tg-homebannerslider tg-haslayout">
				<div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
					<div class="container">
						<div class="tg-tabcontent tab-content" style="padding: 0px 350px 0;">
							<!-- 결제 완료 정보 출력 -->
							<div role="tabpanel" class="tab-pane active fade in" id="home">
								<div style="text-align: center; margin: 50px 0px;">
									<h2>결제 완료</h2>
								</div>
								<div class="form-group">
									<div style="display: inline-block;">
										<h4 style="width: 100px">예약자 :</h4>
									</div>
									<div style="display: inline-block">
										<input type="text" class="form-control" name="id" style="border: none; width: 265px;"
										value = "<%=request.getAttribute("loginId")%>" readonly>
									</div>
								</div>
								<c:forEach var="item" items="${resultRents}" varStatus="status">
									<div class="form-group">
										<div style="display: inline-block;">
											<h4 style="width: 100px">차이름 :</h4>
										</div>
										<div style="display: inline-block">
											<input type="text" class="form-control" style="border: none; width: 265px;"
											 value="${item.modelName}" readonly>
										</div>
									</div>
									
									<div class="form-group">
										<div style="display: inline-block;">
											<h4 style="width: 100px">날 짜 :</h4>
										</div>
										<div style="display: inline-block">
											<input type="text" class="form-control" name="text" style="border: none; width: 265px;"
											value="${item.startDate} ~ ${item.endDate}" readonly>
										</div>
									</div>
								</c:forEach>
								<c:forEach var="item" items="${failRents}" varStatus="status">
									<div class="form-group">
										<div style="display: inline-block;">
											<h4 style="width: 100px">예약 실패 :</h4>
										</div>
										<div style="display: inline-block">
											<input type="text" class="form-control" style="border: none; width: 265px;"
											 value="${item.modelName}" readonly>
										</div>
									</div>
									
									<div class="form-group">
										<div style="display: inline-block;">
											<h4 style="width: 100px">날 짜 :</h4>
										</div>
										<div style="display: inline-block">
											<input type="text" class="form-control" name="text" style="border: none; width: 265px;"
											value="${item.startDate} ~ ${item.endDate}" readonly>
										</div>
									</div>
								</c:forEach>
								<div style="margin: 50px 0px; text-align: center;">
									<div style="display: inline-block; vertical-align: middle; padding: 0px 20px">
										<button class="tg-btn tg-btn-lg" style="padding: 0px 30px;" onclick="location.href='<%=application.getContextPath()%>/index.jsp'">
											<span style="font-size: 14pt; width: 30%">홈으로</span>
										</button>
									</div>
									<% if (request.getParameter("loginId") != null){ %>
									<div style="display: inline-block; vertical-align: middle; padding: 0px 20px">
										<button class="tg-btn tg-btn-lg" style="padding: 0px 30px;" onclick="location.href='<%=application.getContextPath()%>/rent/list.rent'">
											<span style="font-size: 14pt; width: 10%">결제내역</span>
										</button>
									</div>
									<%} %>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
<!--************************************
		Main 종료
*************************************-->

<!--************************************
		Wrapper 종료
*************************************-->
</div>
</body>
</html>