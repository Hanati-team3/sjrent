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
	//private XMLObjectFactory factory;
	//private JSONArray jsonArray;
	//private ObjectToJson otj;
	private QnAService qnaService;
	private ModelAndView mav;
	
	@Override 
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException {
        
		mav = new ModelAndView(); 
		XMLObjectFactory factory =  (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		qnaService = (QnAService) factory.getBean(QnAServiceImpl.class);
		
        List<QnA> list = null; 
        int listSize = 10; 
        int page = 1;
        int count = 0; 
        
        System.out.println("리퀘스트에 담은 페이지 정보 : " + request.getParameter("page"));
        
        if ((String)request.getParameter("page")!= null) {
			try {
				list = qnaService.listByPage(page, listSize);
				count = qnaService.count(); 
				System.out.println("여기까지온다ㅏㅏㅏㅏㅏ");
			} catch (Exception e) {
				throw new ServletException("QnAService.list() 예외 발생", e); 
			} 
        } else {
        	mav.setView("/qna/qna_index.jsp");
        	return mav; 
        }
        
        mav.addObject("count", count); 
        mav.addObject("list", list);
        mav.setView("/qna/qna_index.jsp"); 
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
	
	
	
	
	 
	  
	 