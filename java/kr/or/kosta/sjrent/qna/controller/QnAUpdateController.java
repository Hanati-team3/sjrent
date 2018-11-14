package kr.or.kosta.sjrent.qna.controller;

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
import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.service.QnAService;
import kr.or.kosta.sjrent.qna.service.QnAServiceImpl;


/**
 * QnA 수정 컨트롤러
 * @author 윤형철, 남수현
 */

public class QnAUpdateController implements Controller {
	//컨트롤러 사용을 위한 객체 선언
	private QnAService qnaService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 사용을 위한 객체 생성
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		qnaService = (QnAService) factory.getBean(QnAServiceImpl.class);
		// 업데이트 할 정보 받아오기
		int qna_seq = 0;
		if(request.getParameter("qna_seq")!=null) {
			qna_seq = Integer.parseInt(request.getParameter("qna_seq"));
		}else {
			mav.setView("/qna/qnaIndex.rent");
			return mav;
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		QnA qna = new QnA();
		boolean isUpdate = false;
		
		
		qna.setNumber(qna_seq);
		qna.setTitle(title);
		qna.setContent(content);
		
		try {
			// qna 업데이트
			isUpdate = qnaService.update(qna);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// QnA 수정 실패시 응답으로 fail 보냄
		if (isUpdate == false) {
			try {
				response.getWriter().print("fail");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// QnA 수정 성공시 응답으로 success 보냄
		else {
			mav.addObject("qna", qna);
			mav.setView("/qna/qna_update.jsp");
			try {
				response.getWriter().print("sucess");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mav;
	}

}