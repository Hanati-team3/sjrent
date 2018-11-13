<%
String loginId = (String)request.getAttribute("loginId"); 
//System.out.println("header에 넘어온 loginId : " + loginId);

%>

<%@ page contentType="text/html; charset=utf-8"%>
      <header id="tg-header" class="tg-header tg-haslayout">
         <div class="container-fluid">
    <div class="row">
      <div class="tg-navigationarea tg-headerfixed">
        <strong class="tg-logo"><a
          href="<%=application.getContextPath()%>/index.jsp"><img
            src="<%=application.getContextPath()%>/images/logo.png"
            alt="company logo here"></a></strong>
        <div class="tg-socialsignin">
          <div class="tg-userbox">


            <!-- 회원인 경우 Header -->
            <%
            	if(loginId != null) {
            %>
            <a id="tg-btnsignin" class="tg-btn"
              href="/sjrent/user/logout.rent"><span
              style="size: 15pt">로그아웃</span></a>



            <div class="dropdown tg-dropdown"></div>
          </div>
        </div>
        <nav id="tg-nav" class="tg-nav">
          <div id="tg-navigation"
            class="collapse navbar-collapse tg-navigation">
            <ul>
              <li><a
                href="<%=application.getContextPath()%>/rent/search.jsp">실시간</a></li>
              <li><a
                href="<%=application.getContextPath()%>/rec/rec_index.jsp">추천예약</a></li>
              <li class="menu-item-has-children"><a
                href="<%=application.getContextPath()%>/qna/qnaIndex.rent">커뮤니티</a>
                <ul class="sub-menu">
                  <li><a
                    href="<%=application.getContextPath()%>/qna/qnaIndex.rent">Q&A</a></li>
                  <li><a
                    href="<%=application.getContextPath()%>/qna/qnaIndex.rent">FAQ</a></li>
                  <li><a
                    href="<%=application.getContextPath()%>/qna/qnaIndex.rent">공지사항</a></li>
                </ul></li>

              <li><a
                href="<%=application.getContextPath()%>/wishitem/list.rent">위시리스트</a></li>
              <li><a
                href="<%=application.getContextPath()%>/rent/list.rent">예약확인</a></li>
              <li><a
                href="<%=application.getContextPath()%>/mypage/myPage.jsp">MYPAGE</a></li>
            </ul>
          </div>
        </nav>






        <!-- 비회원인 경우 Header -->
        <%
        	} else {
        %>
        <a id="tg-btnsignin" class="tg-btn" href="#tg-loginsingup"><span
          style="size: 15pt">로그인</span></a>

        <div class="dropdown tg-dropdown"></div>
      </div>
    </div>
    <nav id="tg-nav" class="tg-nav">
      <div id="tg-navigation"
        class="collapse navbar-collapse tg-navigation">
        <ul>
          <li><a
            href="<%=application.getContextPath()%>/rent/search.jsp">실시간</a></li>
          <li><a
            href="<%=application.getContextPath()%>/rec/rec_index.jsp">추천
              예약</a></li>
          <li class="menu-item-has-children"><a href="<%=application.getContextPath()%>/qna/qnaIndex.rent">커뮤니티</a>
            <ul class="sub-menu">
              <li><a
                href="<%=application.getContextPath()%>/qna/qnaIndex.rent">Q&A</a></li>
              <li><a
                href="<%=application.getContextPath()%>/qna/qnaIndex.rent">FAQ</a></li>
              <li><a
                href="<%=application.getContextPath()%>/qna/qnaIndex.rent">공지사항</a></li>
            </ul></li>

          <li><a
            href="<%=application.getContextPath()%>/user/login.jsp">위시리스트</a></li>
          <li><a
            href="<%=application.getContextPath()%>/user/login2.jsp">예약확인</a></li>
          <li><a
            href="<%=application.getContextPath()%>/user/login.jsp">MYPAGE</a></li>
        </ul>
      </div>
    </nav>


    <%
    	}
    %>


    <!-- 원본임!!!!!!!!!!!!! -->
                        
<%--                         <div class="dropdown tg-dropdown">
                        </div>
                     </div>
                  </div>
                  <nav id="tg-nav" class="tg-nav">
                     <div id="tg-navigation" class="collapse navbar-collapse tg-navigation">
                        <ul>
                           <li><a href="<%=application.getContextPath()%>/rent/search.jsp">실시간</a></li>
                           <li><a href="<%=application.getContextPath()%>/rec/rec_index.jsp">추천 예약</a></li>
                           <li class="menu-item-has-children"><a
                              href="javascript:void(0);">커뮤니티</a>
                              <ul class="sub-menu">
                                 <li><a href="<%=application.getContextPath()%>/community/qna_index.jsp?type=qna">Q&A</a></li>
                                 <li><a href="<%=application.getContextPath()%>/community/faq_index.jsp?type=faq">FAQ</a></li>
                                 <li><a href="<%=application.getContextPath()%>/community/notice_index.jsp?type=notice">공지사항</a></li>
                              </ul></li>
                                                           
                           <li><a href="<%=application.getContextPath()%>/wishitem/list.rent">위시리스트</a></li>
                           <li><a href="<%=application.getContextPath()%>/user/login2.jsp">예약확인</a></li>
                           <li><a href="<%=application.getContextPath()%>/mypage/myPage.jsp">MYPAGE</a></li>
                        </ul>
                     </div>
                  </nav> --%>
               </div>
      </header>
      
      <!-- 재민 수정 시작(2/2) -->
      <!--  로그인 화면  -->
      <div id="tg-loginsingup" class="tg-loginsingup" data-vide-options="position: 0% 50%">
      <div class="tg-contentarea tg-themescrollbar">
         <div class="tg-scrollbar">
            <button type="button" class="close">x</button>
            <div class="tg-logincontent">
               <nav id="tg-loginnav" class="tg-loginnav">
                  
               </nav>
               <div class="tg-themetabs">
                  <ul style= "text-align: center;">
                     <li style="list-style: none;"><h2>로그인</h2></li>
                  </ul>
                  <div class="tg-tabcontent tab-content">

                     
                     
                     
                           
                           
								<!--************************************
										회원 로그인 시작 
								*************************************-->
								<div role="tabpanel" class="tab-pane active fade in" id="user" >
                
									<form class="tg-formtheme tg-formlogin" action="/sjrent/user/login.rent" method="post">
										<fieldset>
											<div class="form-group">
												<label>아이디 <sup>*</sup></label>
												<input type="text" name="id" class="form-control" placeholder="" maxlength="16" style="text-transform:  none;" required value="${id }" >
											</div>
											<div class="form-group">
												<label>비밀번호 <sup>*</sup></label>
 								                <input type="password" name="pw" class="form-control" placeholder="" maxlength="10"  style="text-transform:  none;" required>
											</div>
											<div class="form-group">
													<input type="checkbox" name="remember" id="rememberpass" style="display: inline-block; "><label for="rememberpass" style="display: inline-block; ">아이디 저장</label>
											</div>
											                        
                                             <div style="margin-top: 20px;">
                                              <a href="<%=application.getContextPath()%>/user/regist.jsp" style="color: grey; float: right; ">아직 회원이 아니신가요?</a>
                                             </div>
                                   
                          	                 <button type="submit" class="tg-btn tg-btn-lg" style="display: inline-block;  vertical-align: middle; margin-top: 10px"><span>로그인</span></button>
                    
                                       </fieldset>
									</form>
								</div>
								<!--************************************
										회원 로그인 종료 
								*************************************--> 
                     
                    
                     
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div> 