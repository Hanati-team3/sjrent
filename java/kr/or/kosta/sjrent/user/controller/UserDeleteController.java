package kr.or.kosta.sjrent.user.controller;

import java.io.IOException;

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
 * 
 * 회원정보 삭제 역할을 수행하는 컨트롤러
 * 
 * @author 윤형철
 *
 */

public class UserDeleteController implements Controller {
	// 컨트롤러 처리를 위해 서비스 민 object 객체, modelandview 선언
	private ModelAndView mav;
	private UserService userService;
	private JSONObject obj;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		// 컨트롤러 처리를 위해 서비스 및 object 객체, modelandview 생성
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);

		String id = (String) request.getAttribute("loginId");
		boolean isDelete = false;

		try {
			// 유저 삭제
			isDelete = userService.delete(id);
			// 쿠키 삭제
			if (isDelete == true) {
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("loginId")) {
							cookie.setPath("/");
							cookie.setMaxAge(0);
							response.addCookie(cookie);
							request.removeAttribute("loginId");
						}
					}
				}
				// 메인 페이지로
				mav.setView("/index.jsp");
			} else {
				// 로그인 확인 페이지로
				mav.setView("/sjrent/mypage/myPageLoginOK.jsp");
			}
			return mav;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		return mav;

	}

}
