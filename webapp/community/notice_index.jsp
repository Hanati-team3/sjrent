<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.kosta.sjrent.qna.domain.QnA"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.sjrent.qna.controller.QnAListController"%>
<%@page import="kr.or.kosta.sjrent.common.controller.Controller"%>
<%@page import="kr.or.kosta.sjrent.common.params.Params"%>
<%@page import="kr.or.kosta.sjrent.common.params.PageBuilder"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%
//넘버링하기
int count = (int)request.getAttribute("count"); 
//int listSize = 10;
int pageNum = 1;
String pageS = request.getParameter("page");
if(pageS!=null){
	pageNum = Integer.parseInt(pageS);
}
int listSize = 10;
int startNum = count -(listSize*(pageNum-1));
%>
<!DOCTYPE html>
<html>
<head>
<!-- 스타일 시작 -->
   <jsp:include page="../common/commoncss.jsp" />
   <jsp:include page="../common/commonjs.jsp" />
<style type="text/css">
table{
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color:#f5f5f5;
	color: black;
	}

/* Style tab links */
.tablink {
    background-color: #555;
    color: white; 
    float: inherit;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 18px;
    width: 33%;
}

.tablink:hover {
    background-color: #777;
}

.tabcontent {
    color: black;
    display: none;
    /* padding: 100px 20px; */
    height: 100%;
}

#QnA { background-color: #fafafa; 
/* background-color: orange; */}
#FAQ {background-color: #fafafa;}
#공지사항 {background-color: #fafafa;}

</style>
<!-- 스타일 종료 -->
</head>

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
<main id="tg-main" class="tg-main tg-haslayout tg-bglight">
   <div class="container">
      <div class="row">
         <div style="text-align: center; margin: 100px 0px "><h2>커뮤니티</h2></div>
         <div style="text-align: center;  margin: 10px 0px 20px">
			<button class="tablink" onclick="openPage('QnA', this, '#446600')" >QnA</button>   
			<button class="tablink" onclick="openPage('FAQ', this, '#800060')"  >FAQ</button>
			<button class="tablink" onclick="openPage('공지사항', this, '#006699')" id="defaultOpen" >공지사항</button>
		</div>
		
		<!-- QnA -->
		<div id="QnA" class="tabcontent" >
										
			 <!-- table에 원래 있던 class="w3-table w3-striped w3-bordered" -->
		    <table class="table table-responsive">
                          <colgroup>
                             <col width="5%"/>
                             <col width="40%"/>
                             <col width="20%"/>
                             <col width="15%"/>
                          </colgroup>
                          <tr>
                             <th scope="col">번호</th>
                             <th scope="col">제목</th>
                             <th scope="col">작성자</th>
                             <th scope="col">작성일</th>
                          </tr>
                          <tbody>
                          <!--************************************
                                QnA 리스트 시작 
                             *************************************-->
                             <!-- && (!((ArrayList)request.getAttribute("list")).isEmpty()) -->
                             
                             <% 
                            String loginId = (String)request.getAttribute("loginId");
                          	
                             List<QnA> QnAList = (ArrayList<QnA>)request.getAttribute("list");
                             int index = 0;
                             if (request.getAttribute("list") != null ){ %> 
                              <c:forEach var="qna" items="${list}" varStatus="status">
	                              <tr>
	                              	 <!--***********
	                              	 		번호 
	                              	 	 ***********-->	
	                                 <td>
	                                 <span><%= startNum-- %></span>
	                                 </td>
	                                 <!--***********
	                              	 		제목 
	                              	 	 ***********-->	
	                                 <td class="startDate" style="text-align: left; padding-left: 20px">
	                                 	<%
	                                	
	                                	
	                                 	
	                                 	if(loginId.equals(QnAList.get(index++).getUserId())){//작성자이면
	                                 	
	                                 	%>
	                                 		<span><a href="<%=application.getContextPath() %>/qna/qna_read.jsp">${qna.title}</a></span>
	                                 	<%	
	                                 	}else{
	                                 	%>	
	                                 		  <span>
	                                 		  	<img alt="자물쇠" src="<%=application.getContextPath()%>/images/lock.png">
	                                 		  	비밀글입니다.
	                                 		  </span> 
	                                 	<%
	                                 	}
	                                 	%>
	                                 </td>
	                                 <!--***********
	                              	 		작성자 
	                              	 	 ***********-->	
	                                 <td class="startDate" style="vertical-align: middle;">
	                                 	<span>${qna.userId}</span>
	                                 </td>
	                                 <!--***********
	                              	 		작성일 
	                              	 	 ***********-->	
	                                 <td class="endDate"   style="vertical-align: middle;">
	                                 	<span>${qna.date}</span>
	                                 </td>
	                              </tr>
                              </c:forEach>
                              <%}else{ %>
                              <tr>
                              	<td colspan="4" style="height: 100px; vertical-align: middle;">QnA가 존재하지 않습니다.</td>
                              </tr>
                              <%}%>
                             <!--************************************
                                QnA 리스트 종료
                             *************************************-->
                          </tbody>
                       </table>
                       
                       <!-- 글쓰기 버튼 -->
                       <div style="display:inline-block; float: right; margin-top: 30px">
							<button class="tg-btn tg-btn-lg" style=" padding: 0px 30px; float: right;" onclick="location.href='<%=application.getContextPath()%>/qna/qna_create.jsp'"><span style="font-size: 14pt; width:30%">글쓰기</span></button>
					   </div>
	        
		</div>
		
		<!-- FAQ -->
		
		<%-- <div id="FAQ" class="tabcontent">
			<h3>FAQ</h3>
			<!-- FAQ 내용 시작 -->
			<div style="padding-left: 15px; margin-bottom: 180px">
				<%
				for(int i=1; i<6; i++){
				%>
				<h5># 내용 <%=i %></h5>
				<%
				}
				%>
			</div>
			<!-- FAQ 내용 종료 -->
		</div> --%>
		
		<div id="FAQ" class="tabcontent" >
		    <table class="table table-responsive">
                          <colgroup>
                             <col width="5%"/>
                             <col width="40%"/>
                          </colgroup>
                          <tr>
                             <th scope="col">번호</th>
                             <th scope="col">제목</th>
                          </tr>
                          <tbody>
                          <!--************************************
                                FAQ 리스트 시작 
                             *************************************-->
                             <!-- && (!((ArrayList)request.getAttribute("list")).isEmpty()) -->
                             
	                              <tr>
	                              	 <!--***********
	                              	 		번호 
	                              	 	 ***********-->	
	                                 <td>
	                                 <span>1</span>
	                                 </td>
	                                 <!--***********
	                              	 		제목 
	                              	 	 ***********-->	
	                                 <td>
                                 		<span>공지사항1</span>
	                                 </td>
	                              </tr>
                             <!--************************************
                                FAQ 리스트 종료
                             *************************************-->
                          </tbody>
                       </table>
	        
		</div>
		
		
		
		<!-- Notice -->
		<div id="공지사항" class="tabcontent">
			<h3>공지사항</h3>
			<!-- Notice 내용 시작 -->
			<div style="padding-left: 15px; margin-bottom: 180px">
				<%
				for(int i=1; i<6; i++){
				%>
				<h5># 내용 <%=i %></h5>
				<%
				}
				%>
			</div>
			<!-- Notice 내용 종료 -->
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

<body class="tg-home tg-homevone">
	<script>
		function openPage(pageName, elmnt, color) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].style.backgroundColor = "";
			}
			document.getElementById(pageName).style.display = "block";
			elmnt.style.backgroundColor = color;

		}
		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>
	

   <jsp:include page="../common/commonjs.jsp" />
</body>
</html>