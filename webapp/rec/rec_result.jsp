<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SJ 렌트카</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/normalize.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/font-awesome.min.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/icomoon.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/owl.carousel.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/bootstrap-select.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/scrollbar.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/jquery.mmenu.all.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/prettyPhoto.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/transitions.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/main.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/color.css">
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/responsive.css">
<script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

<style type="text/css">

.resultImg {
   	position: absolute;
   	top: 55%;
	left: 50%;
	transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	background-color: #d64161;
	color: white;
	font: bold; 
	font-size: 32px;
	padding: 10px;
	border: none;
	cursor: pointer;
	/* box-shadow: 0 9px #999; */ 
	/* border-radius: 50%; */
	text-align: center;
	height: 30%;
}

.resultImg:active {
	  background-color: #c94c4c;
	  box-shadow: 0 5px #666;
	  /* transform: translateY(4px); */
	}
	
.resultImg:hover {
background-color: #ff8080;
}

</style>

<script>

   <%-- $(document).ready(function(){
	   var result = '초기값';
	   
		console.log('id : ' + '<%=request.getAttribute("loginId")%>');
		console.log('<%=request.getParameter("hidden")+","+request.getParameter("click")%>');
	      /** 모델 목록을 불러오는 search controller로 요청 전달 */
	      $.ajax({
	         type : "POST",
	          url : "<%=application.getContextPath()%>/model/recommend.rent",
	          async: false, 
	          data : {
	             'result' : '<%=request.getParameter("hidden")+","+request.getParameter("click")%>',
	          },
	          dataType: "json",
	          success: function(data){
				//console.log(data.modelName);
				//console.log(data.picture);
				//console.log(data.type);
				
				var type = data.type; 
				var picture = data.picture; 

				//console.log(typeof modelName);//string
				//console.log(typeof type);//string
				
				result = ("..images/" + type + "/" + picture).trim();
				console.log('ajax안에서  : ' + result);
				
				
	          }
	       });
		   return result;
	   }) --%>
	   
	   /** 이미지 경로 받아오기 */
	   function getImagePath() {
	   var result; 
	   	console.log('id : ' + '<%=request.getAttribute("loginId")%>');
		console.log('<%=request.getParameter("hidden")+","+request.getParameter("click")%>');
	   $.ajax({
	         type : "POST",
	          url : "<%=application.getContextPath()%>/model/recommend.rent",
	          async: false, 
	          data : {
	             'result' : '<%=request.getParameter("hidden")+","+request.getParameter("click")%>',
	          },
	          dataType: "json",
	          success: function(data){
				//console.log(data.modelName);
				//console.log(data.picture);
				//console.log(data.type);
				
				var type = data.type; 
				var picture = data.picture; 

				//console.log(typeof modelName);//string
				//console.log(typeof type);//string
				
				result = ("../images/cars/" + type + "/" + picture).trim();
				console.log('ajax안에서  : ' + result);
				
				
	          }
	       });
	   	   console.log("최종적으로 넘어가는 리절트: " + result);
	   	   return result; 
		}
   
	   
   		/** 시작하자마자 */
   		$(document).ready(function(){ 
			var imagePath = getImagePath(); 
   			//console.log('이미지경로 : '+ imagePath);
   			
			var resultCar = document.getElementById('resultCar');
   			resultCar.src = imagePath;
			//resultCar.src = "../images/K5.jpg";
   			console.log('11111111 : '+resultCar.src);
			//alert(resultCar.src);
			//console.log('어떤 값이 들어가지? ' + imagePath);
			//var resultImg = document.getElementsByClassName('resultImg'); 
		}) 
		
		
   
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
    <main id="tg-main" class="tg-main tg-sectionspace tg-haslayout">
    <div class="container">
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
          style="padding: 0px 300px">
          <div class="tg-pkgplan" style="padding: 0px">

            <!--************************************
									Content 시작
							*************************************-->
            
							<img alt="여행선택지" src="../images/rec/rec_result.JPG">
							<img alt="추천자동차" src="" id="resultCar" class="resultImg">	
							<span></span>
			<!-- ../images/cars/ASegment/2017K3.jpg  -->	
            <!--************************************
									Content 종료
							*************************************-->



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

  <script
    src="<%=application.getContextPath()%>/js/vendor/jquery-library.js"></script>
  <script
    src="<%=application.getContextPath()%>/js/vendor/bootstrap.min.js"></script>
  <script
    src="https://maps.google.com/maps/api/js?key=AIzaSyCR-KEWAVCn52mSdeVeTqZjtqbmVJyfSus&language=en"></script>
  <script
    src="<%=application.getContextPath()%>/js/bootstrap-select.min.js"></script>
  <script
    src="<%=application.getContextPath()%>/js/jquery-scrolltofixed.js"></script>
  <script src="<%=application.getContextPath()%>/js/owl.carousel.min.js"></script>
  <script src="<%=application.getContextPath()%>/js/jquery.mmenu.all.js"></script>
  <script src="<%=application.getContextPath()%>/js/packery.pkgd.min.js"></script>
  <script src="<%=application.getContextPath()%>/js/jquery.vide.min.js"></script>
  <script src="<%=application.getContextPath()%>/js/scrollbar.min.js"></script>
  <script src="<%=application.getContextPath()%>/js/prettyPhoto.js"></script>
  <script src="<%=application.getContextPath()%>/js/countdown.js"></script>
  <script src="<%=application.getContextPath()%>/js/parallax.js"></script>
  <script src="<%=application.getContextPath()%>/js/gmap3.js"></script>
  <script src="<%=application.getContextPath()%>/js/main.js"></script>
</body>
</html>