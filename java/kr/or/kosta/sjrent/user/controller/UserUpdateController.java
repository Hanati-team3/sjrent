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
import sun.nio.cs.HistoricallyNamedCharset;

/**
 * 
 * 회원정보 수정 역할을 수행하는 컨트롤러
 * 
 * @author 윤형철
 *
 */

public class UserUpdateController implements Controller {
	// 컨트롤러 사용을 위한 객체 선언
	private UserService userService;
	private JSONObject obj;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		// 컨트롤러 사용을 위한 객체 생성
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);

		User user = new User();
		boolean isUpdate = false;

		
		// 회원수정시에 들어오는 param
		if(request.getParameter("id") != null) {
					
			// param 값 받기
			String id = (String) request.getAttribute("loginId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String cellphone = request.getParameter("cellphone");			
			
			// user에 받아 온 값 넣기
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setCellphone(cellphone);
			
			
			try {
				// 유저 업데이트
				isUpdate = userService.update(user);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			if (isUpdate == false) {
				mav.setView("/sjrent/mypage/update.jsp");
			}
			else {
				mav.addObject("id", id);
				mav.addObject("name", name);
				mav.addObject("password", password);
				mav.addObject("email", email);
				mav.addObject("cellphone", cellphone);
				mav.setView("/mypage/updateUser_result.jsp");
			}
		}
		return mav;
	}
}