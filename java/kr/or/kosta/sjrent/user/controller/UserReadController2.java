package kr.or.kosta.sjrent.user.controller;


import java.io.IOException;

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

/**
 * id로 user를 검색하는 컨트롤러
 * 
 * @author 유예겸
 *
 */

public class UserReadController2 implements Controller {
	//컨트롤러 사용을 위한 객체 선언
	private ModelAndView mav;
	private UserService userService;
	private JSONObject obj;

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		//컨트롤러 사용을 위한 객체 생성
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		userService = (UserService)factory.getBean(UserServiceImpl.class);
	
		String id = (String)request.getAttribute("loginId");
		User user = null;

		try {
			// 아이디로 유저 읽기
			user = userService.read(id);
			mav.addObject("user", user);
			mav.setView("/mypage/myPageLoginOK.jsp");

			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 응답으로 json 객체 보내고 컨트롤러 종료
		try {
			response.getWriter().print(obj);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mav;
	}

}
