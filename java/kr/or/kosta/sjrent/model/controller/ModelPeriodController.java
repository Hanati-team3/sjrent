package kr.or.kosta.sjrent.model.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.converter.ObjectToJson;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.service.ModelService;
import kr.or.kosta.sjrent.model.service.ModelServiceImpl;

/**
 * 모델 이름을 인자로 받아 특정 모델의 상세 정보를 View로 보내는 컨트롤러
 * 
 * @author 남수현
 *
 */
public class ModelPeriodController implements Controller{
	// 컨트롤러 사용을 위한 객체 선언
	private ModelService modelService;
	private ModelAndView mav;
	private XMLObjectFactory factory;
	private Logger logger = Logger.getLogger(ModelPeriodController.class);
	private ObjectToJson otj;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 사용을 위한 객체 생성
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		otj = new ObjectToJson();
		// 인자로 받는 차 종 이름
		String modelName = request.getParameter("modelName");
		if(modelName == null) {
			return null;
		}
		//값을 담기 위한 JSONObject 선언 
		JSONObject resultObject = new JSONObject();
		JSONObject jo = new JSONObject();
		try {
			// 차 이름으로 가능 일자 받기
			Map<String, ArrayList<String>> result = modelService.periodByModelName(modelName);
			jo.putAll(result);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			// 모델 이름으로 모델 정보 받아서 가능 일자와 함께 보내기
			Model model = modelService.read(modelName);
			response.setCharacterEncoding("utf-8");
			resultObject.put("period", jo);
			resultObject.put("model", otj.ObjectToJsonObject(model));
			response.getWriter().print(resultObject);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}