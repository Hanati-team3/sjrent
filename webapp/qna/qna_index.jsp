<%@page import="kr.or.kosta.sjrent.qna.controller.QnAListController"%>
<%@page import="kr.or.kosta.sjrent.common.controller.Controller"%>
<%@page import="kr.or.kosta.sjrent.common.params.Params"%>
<%@page import="kr.or.kosta.sjrent.common.params.PageBuilder"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%
//페이지당 보여지는 페이지수 설정
int pageSize = 5;

// 페이징 정렬 
request.getAttribute("page");
//List<Article> list = dao.listByPage(params);

// 페이징 처리에 필요한 검색 개수 DB조회
//int rowCount = dao.countBySearch(params);

// PageBuilder를 이용하여 페이징 계산
//PageBuilder pageBuilder = new PageBuilder(params, rowCount);
//pageBuilder.build();

%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp"/> 
<!-- 스타일 시작 -->
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
    color: white;
    display: none;
    padding: 100px 20px;
    height: 100%;
}

#QnA { background-color: #446600; 
/* background-color: orange; */}
#FAQ {background-color: #800060;}
#공지사항 {background-color: #006699;}

</style>
<!-- 스타일 종료 -->
<!-- 스크립트 시작 -->
<script type="text/javascript">
/**
 * qna_index.jsp가 로드될 때 실행되는 함수
 */

<%-- $(document).ready(function(){
 $.ajax({
     type: "POST",
     url: "<%=application.getContextPath()%>/qna/qnaIndex.rent",
      //data: modelParams,
      dataType: "json",
      success: function(data) {
          setQnAList(data);
      }
  });
});
 --%>      

function setQnAList(list) {
	
	for ( var i in list) {
		var title = list[i].title;
		var userId = list[i].userId;
		var date = list[i].date;
		var content = list[i].content;
		
		//document.getElementById("td").innerHTML = title; 
		
		  /* <td id="tdNumber"></td>
          <td id="tdTitle"></td>
          <td id="tdUserId" ></td>
          <td id="tdDate"></td> */
		
		//console.log("제목:"+list[i].title +" 내용:"+ list[i].content +" 작성자:"+ list[i].userId + " 날짜:"+list[i].date);
		//$("#carListRow").append(model);
	}	//for 끝
	
	

}


</script>
<!-- 스크립트 종료 -->
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
         <div style="text-align: center; margin: 100px 0px"><h2>QnA</h2></div>
            <div id="tg-twocolumns" class="tg-twocolumns">
                 <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="" >
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
                             <% if (request.getAttribute("list") != null ){ %> 
                              <c:forEach var="qna" items="${list}" varStatus="status">
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
	                                 <td class="startDate" style="vertical-align: middle;"><span>${qna.title}</span>
	                                 </td>
	                                 <!--***********
	                              	 		작성자 
	                              	 	 ***********-->	
	                                 <td class="startDate" style="vertical-align: middle;"><span>${qna.userId}</span>
	                                 </td>
	                                 <!--***********
	                              	 		작성일 
	                              	 	 ***********-->	
	                                 <td class="endDate"   style="vertical-align: middle;"><span>${qna.date}</span>
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

<body class="tg-home tg-homevone">

	

   <jsp:include page="../common/commonjs.jsp" />
</body>
</html>