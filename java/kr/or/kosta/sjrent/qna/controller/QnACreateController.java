package kr.or.kosta.sjrent.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.service.QnAService;
import kr.or.kosta.sjrent.qna.service.QnAServiceImpl;
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;


/**
 * qna 생성 컨트롤러
 * 
 */
public class QnACreateController implements Controller {
	// 컨트롤러 사용을 위한 객체 선언
	private QnAService qnaService;
	private UserService userService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 사용을 위한 객체 생성
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		qnaService = (QnAService) factory.getBean(QnAServiceImpl.class);
		userService = (UserService) factory.getBean(UserServiceImpl.class);
		
		// 로그인 된 아이디 정보 받기
		String loginId = (String) request.getAttribute("loginId");
		User user = new User();
		int userSeq = 0;
		try {
			user = userService.read(loginId);
		} catch (Exception e2) {
			mav.addObject("message", "needLogin");
			mav.setView("/qna/qnaIndex.rent");
		}
		if(user!=null) {
			userSeq = user.getSeq();
		}else {
			mav.addObject("message", "needLogin");
			mav.setView("/qna/qnaIndex.rent");
		}
		// 넘어온 값 받기
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String answer = request.getParameter("answer");
		// QnA 객체 생성 후 값 넣기
		QnA qna = new QnA();
		qna.setUserSeq(userSeq);
		qna.setUserId(loginId);
		qna.setTitle(title);
		qna.setContent(content);
		qna.setAnswer(answer);
		boolean isCreate = false;
		try {
			//DB에 해당 정보 넣기
			isCreate = qnaService.create(qna);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// QnA 생성 실패시 응답으로 fail 보냄
		if (isCreate == false) {
			try {
				response.getWriter().print("fail");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// QnA 생성 성공시 응답으로 success 보냄
		else {
			mav.addObject("qna", qna);
			mav.setView("/qna/qnaIndex.rent");
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mav;
	}

}