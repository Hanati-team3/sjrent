package kr.or.kosta.sjrent.user.controller;

import java.io.IOException;
import java.util.List;

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
 * 로그아웃 역할을 수행하는 컨트롤러
 * @author 유예겸
 *
 */

public class UserLogoutController implements Controller {
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		mav = new ModelAndView();
		
		// 로그인 된 유저 쿠키 삭제(로그아웃 처리)
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
		mav.setView("redirect:/sjrent/index.jsp");
		return mav;
	}

}
