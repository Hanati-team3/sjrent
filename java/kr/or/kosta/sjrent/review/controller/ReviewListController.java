package kr.or.kosta.sjrent.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.converter.ObjectToJson;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.review.domain.Review;
import kr.or.kosta.sjrent.review.service.ReviewService;
import kr.or.kosta.sjrent.review.service.ReviewServiceImpl;

/**
 * 유저 혹은 모델을 받아서 조건에 따라 리스트 출력 
 * @author 남수현
 */
public class ReviewListController implements Controller {
	// 컨트롤러 사용을 위한 객체 선언
	private XMLObjectFactory factory;
	private ReviewService reviewService;
	private JSONArray jsonArray;
	private ObjectToJson otj;
	
   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException {
	   // 컨트롤러 사용을 위한 객체 생성
      factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
      reviewService = (ReviewService)factory.getBean(ReviewServiceImpl.class);
      jsonArray = new JSONArray();
      otj = new ObjectToJson();
      
      // 값 수신
      String userId = (String) request.getAttribute("loginId");
      String modelName = request.getParameter("modelName");
      String pageS = request.getParameter("page");
      String listSizeS = request.getParameter("listSzie");
      List<Review> reviewList = new ArrayList<Review>();
      
      // 페이지 값 및 페이지 당 출력 사이즈 수신
      int page = 1;
      int listSize = 10000;
      if(pageS!=null&&!pageS.equals("")) {
    	page = Integer.parseInt(pageS);  
      }
      if(listSizeS!=null&&!listSizeS.equals("")) {
    	listSize = Integer.parseInt(listSizeS);  
      }
      // 모델 네임 유무, 유저 아이디 유무에 따라 분기하여 해당 조건으로 리뷰 리스트 가져오기
      if(modelName != null) {
    	  try {
			reviewList = reviewService.listByModelByPage(page, listSize, modelName);
		} catch (Exception e) {
			
		}
      }else if(userId !=null) {
    	  try {
			reviewList = reviewService.listByUserByPage(page, listSize, userId);
		} catch (Exception e) {

		}
      }
      for(Review review : reviewList) {
    	  //review jsonobject로 변환하여 jsonarray에 넣기
    	  jsonArray.add(otj.ObjectToJsonObject(review));
      }
      response.setCharacterEncoding("utf-8");
      try {
		response.getWriter().print(jsonArray);
	} catch (IOException e) {
		e.printStackTrace();
	}
      return null;
   }
}
