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
 * QnA 답글 달기 컨트롤러
 * @author 남수현
 */

public class QnAAnswerController implements Controller {
	// 컨트롤러 사용을 위한 객체 선언
	private QnAService qnaService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 사용을 위한 객체 생성
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		qnaService = (QnAService) factory.getBean(QnAServiceImpl.class);
		
		// 답변을 달 qna 번호 받기
		int qna_seq = 0;
		if(request.getParameter("qna_seq")!=null) {
			qna_seq = Integer.parseInt(request.getParameter("qna_seq"));
		}else {
			mav.setView("/qna/qnaList.jsp");
			return mav;
		}
		String answer = request.getParameter("answer");

		QnA qna = new QnA();
		boolean isUpdate = false;
		
		// qna에 받아온 넘버와 답변을 달아 업데이트
		qna.setNumber(qna_seq);
		qna.setAnswer(answer);
		
		try {
			isUpdate = qnaService.update(qna);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
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
			mav.setView("/qna/qnaList.jsp");
			try {
				response.getWriter().print("sucess");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mav;
	}

}