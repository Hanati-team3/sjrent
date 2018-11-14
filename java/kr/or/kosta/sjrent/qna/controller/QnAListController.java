package kr.or.kosta.sjrent.qna.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.scripting.xmltags.IfSqlNode;
import org.json.simple.JSONArray;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.converter.ObjectToJson;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.service.QnAService;
import kr.or.kosta.sjrent.qna.service.QnAServiceImpl;
import kr.or.kosta.sjrent.review.domain.Review;

/**
 * /qna/qnaList.rent에 대한 요청 처리 컨트롤러
 * 
 * @author 윤형철, 남수현
 *
 */
public class QnAListController implements Controller {
	// 컨트롤러 사용을 위한 객체 선언
	private QnAService qnaService;
	private ModelAndView mav;
	
	@Override 
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException {
		
        // 컨트롤러 사용을 위한 객체 생성
		mav = new ModelAndView(); 
		XMLObjectFactory factory =  (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		qnaService = (QnAService) factory.getBean(QnAServiceImpl.class);
		
        List<QnA> list = null; 
        //한 페이지에 보여줄 QnA수
        int listSize = 10; 
        
        //페이지 번호
        int page = 1;
        
        //총 QnA 갯수
        int count = 0; 
        
        String pageS = (String)request.getParameter("page");
        if (pageS != null) {
        	page = Integer.parseInt(pageS);
        }
		try {
			list = qnaService.listByPage(page, listSize);
			count = qnaService.count(); 
		} catch (Exception e) {
			throw new ServletException("QnAService.list() 예외 발생", e); 
		} 
        
        mav.addObject("count", count); 
        mav.addObject("list", list);
        
        mav.setView("/community/qna_index.jsp"); 
        return mav;
  
	 
	}
}




	/**
	 * 예겸이가 작성한 코드
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 *           HttpServletResponse response) throws ServletException { factory =
	 *           (XMLObjectFactory)
	 *           request.getServletContext().getAttribute("objectFactory");
	 *           qnaService = (QnAServiceImpl)
	 *           factory.getBean(QnAServiceImpl.class); jsonArray = new JSONArray();
	 *           otj = new ObjectToJson(); List<QnA> qnaList = new ArrayList<QnA>();
	 *           int page = (request.getParameter("page") == null) ? 1 :
	 *           Integer.parseInt(request.getParameter("page")); int listSize =
	 *           (request.getParameter("listSize") == null) ? 10 :
	 *           Integer.parseInt(request.getParameter("listSize"));
	 * 
	 *           try { qnaList = qnaService.listByPage(page, listSize); } catch
	 *           (Exception e) { e.printStackTrace(); } for (QnA qna : qnaList) {
	 *           jsonArray.add(otj.ObjectToJsonObject(qna)); }
	 *           response.setCharacterEncoding("utf-8"); try {
	 *           response.getWriter().print(jsonArray);
	 *           response.getWriter().print(listSize); } catch (IOException e) { //
	 *           TODO Auto-generated catch block e.printStackTrace(); } return null;
	 *           }
	 */
	
	
	
	
	 
	  
	 