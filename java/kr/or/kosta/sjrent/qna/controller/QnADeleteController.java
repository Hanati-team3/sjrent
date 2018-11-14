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
 * qna 삭제 컨트롤러
 * @author 윤형철
 *
 */

public class QnADeleteController implements Controller {
	// 컨트롤러 사용을 위한 객체 선언
	private QnAService qnaService;
	private JSONObject obj;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 사용을 위한 객체 생성
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		qnaService = (QnAService) factory.getBean(QnAServiceImpl.class);

		// 삭제 할 qna sequence number 수신
		int qna_seq = Integer.parseInt(request.getParameter("qna_seq"));
		boolean isDelete = false;
		
		try {
			//해당 nubmer qna 삭제
			isDelete = qnaService.delete(qna_seq);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// QnA 삭제 실패시 응답으로 fail 보냄
		if (isDelete == false) {
			obj.put("result", "fail");
			try {
				response.getWriter().print(obj);
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// QnA 삭제 성공시 응답으로 success 보냄
		else {
			mav.setView("/qna/qnaIndex.rent");
			obj.put("result", "success");
		}
		return mav;
	}

}