package kr.or.kosta.sjrent.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.service.ModelService;
import kr.or.kosta.sjrent.model.service.ModelServiceImpl;

/**
 * 추천 차량 display
 * @author 남수현
 */
public class ModelRecommendController implements Controller {
	// 컨트롤러 사용을 위한 객체 선언
	private ModelService modelService;
	private ModelAndView mav;
	private XMLObjectFactory factory;
	private JSONObject obj;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 사용을 위한 객체 생성
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		obj = new JSONObject();
		// result 값 수신
		String result = request.getParameter("result");
		Model resultModel = null;
		try {
			// 추천 모델 받아오기
			resultModel = modelService.recommend(result);
		} catch (Exception e1) {
		}
		if(resultModel!=null) {
			// 모델 명과 사진, 사진 파일을 가져오기 위한 타입 받아오기
			obj.put("modelName", resultModel.getName());
			obj.put("picture", resultModel.getPicture());
			obj.put("type", resultModel.getType());
		}
		try {
			// ajax로 송신
			response.getWriter().print(obj);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}