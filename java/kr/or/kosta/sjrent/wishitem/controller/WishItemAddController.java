package kr.or.kosta.sjrent.wishitem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;
import kr.or.kosta.sjrent.wishitem.domain.WishItem;
import kr.or.kosta.sjrent.wishitem.service.WishItemService;
import kr.or.kosta.sjrent.wishitem.service.WishItemServiceImpl;

/**
 * wishitem 추가 controller
 * @author 남수현
 */

public class WishItemAddController implements Controller {
	private XMLObjectFactory factory;
	private WishItemService wishItemService;
	private UserService userService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		  
		  // Factory에서 object를 받아 오기 위한 xmlobjectFactory 받아오기
	      factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
	      // 위시 아이템, 유저 서비스 펙토리에서 받아오기
	      wishItemService = (WishItemService) factory.getBean(WishItemServiceImpl.class);
	      userService = (UserService) factory.getBean(UserServiceImpl.class);
	      // 파라미터에서 필요한 정보 수령
	      String modelName = request.getParameter("modelName");
	      String startDate = request.getParameter("startDate");
	      String endDate = request.getParameter("endDate");
	      String amountMoney = request.getParameter("amountMoney");
	      String picture = request.getParameter("picture");
	      String type = request.getParameter("type");
	      String fuelType = request.getParameter("fuelType");
	      //ajax 출력을 위한 writer 생성
    	  PrintWriter out = null;
		  try {
			out = response.getWriter();
		  } catch (IOException e2) {
		  }
	      WishItem wishItem = new WishItem();
	      User user = new User();
	      //로그인 상태 확인 및 유저 정보 가져오기
	      if(request.getAttribute("loginId")!=null && !request.getAttribute("loginId").equals("")) {
	    	  try {
				user = userService.read((String)request.getAttribute("loginId"));
			} catch (Exception e) {
				out.println(e);
			}
	      }else {
	      }
	      // wishitem 객체에 정보 setting
	      wishItem.setUserNumber(user.getSeq());
	      wishItem.setUserId(user.getId());
	      wishItem.setType(type);
	      wishItem.setStartDate(startDate);
	      wishItem.setPicture(picture);
	      wishItem.setModelName(modelName);
	      wishItem.setFuelType(fuelType);
	      wishItem.setEndDate(endDate);
	      if(amountMoney != null && !amountMoney.equals("")) {
	    	  wishItem.setAmountMoney(Integer.parseInt(amountMoney));
	      }
	      try {
	    	  //위시아이템 만들고 결과 송신
	    	  if(wishItemService.create(wishItem)) {
	    		  out.println("success");
	    	  }else {
	    		  out.println("fail");
	    	  }
	    	  
	      } catch (Exception e) {
	    	  e.printStackTrace();
	    	out.println("fail");
	      }
		return null;
	}

}