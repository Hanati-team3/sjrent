package kr.or.kosta.sjrent.user.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;

/**
 * /user/list.rent에 대한 요청 처리 컨트롤러
 * 불필요하여 미구현
 * @author 남수현
 */
public class UserListController implements Controller {
	
	private UserService userService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 처리를 위해 서비스 및 object 객체, modelandview 생성
		ModelAndView mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		userService = (UserService)factory.getBean(UserServiceImpl.class);
		
		List<User> list = null;
		
		mav.addObject("list", list);
		mav.setView("/user/list.jsp");
		return mav;

	}

}
