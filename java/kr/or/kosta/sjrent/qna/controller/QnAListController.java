package kr.or.kosta.sjrent.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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
 * /qna/qnaList.rent에 대한 요청 처리 컨트롤러
 * @author 윤형철, 남수현
 *
 */
public class QnAListController implements Controller {
	
	private QnAService qnaService;
	private JSONObject obj;
	private ModelAndView mav;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		System.out.println("들어오나?????????????");
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		qnaService = (QnAService) factory.getBean(QnAServiceImpl.class);
		List<QnA> list = null;
		int listSize = 10;
		int page = 1;
		
		System.out.println("리퀘스트에 담은 페이지 정보 : "+request.getParameter("page"));
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		try {
			list = qnaService.listByPage(page, listSize);
		} catch (Exception e) {
			throw new ServletException("QnAService.list() 예외 발생", e);
		}
		int count = 0;
		try {
			count = qnaService.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.setView("/qna/qna_index.jsp");
		return mav;

	}

}
