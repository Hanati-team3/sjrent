package kr.or.kosta.sjrent.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
 * 아이디 중복확인 컨트롤러
 * 
 * @author 윤형철
 *
 */

public class UserCheckIdController implements Controller {
	// 컨트롤러 처리를 위해 서비스 민 object 객체, modelandview 선언
	private UserService userService;
	private JSONObject obj;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 처리를 위해 서비스 및 object 객체, modelandview 생성
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);

		// 유저 아이디
		String id = request.getParameter("id");
		
		boolean isExistId = false;
		try {
			// 아이디 중복 여부 확인
			isExistId = userService.isExistId(id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 중복아이디 없을시 success 보냄
		if (isExistId == false) {
			try {
				response.getWriter().print("success");	
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// 중복아이디 존재시 fail 보냄
		else {
			try {
				response.getWriter().print("fail");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mav;
	}

}