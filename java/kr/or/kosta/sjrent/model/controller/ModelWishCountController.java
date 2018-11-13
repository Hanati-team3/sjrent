package kr.or.kosta.sjrent.model.controller;

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
 * 모델 이름을 받아서 위시리스트에 몇번 담겼는지 반환
 * 
 * @author 유예겸
 *
 */
public class ModelWishCountController implements Controller{
	private ModelService modelService;
	private ModelAndView mav;
	private XMLObjectFactory factory;
	private Logger logger = Logger.getLogger(ModelWishCountController.class);
	private ObjectToJson otj;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		otj = new ObjectToJson();
		// 인자로 받는 차 종 이름
		String modelName = request.getParameter("modelName");
		if(modelName == null) {
			logger.debug("파라미터 오류 modelName : " + modelName);
			return null;
		}
		logger.debug("modelName : " + modelName);
		try {
			int count = modelService.countWishItemByModelName(modelName);
			
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(count);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}