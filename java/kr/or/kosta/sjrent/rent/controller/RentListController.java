package kr.or.kosta.sjrent.rent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.service.ModelService;
import kr.or.kosta.sjrent.model.service.ModelServiceImpl;
import kr.or.kosta.sjrent.rent.domain.Rent;
import kr.or.kosta.sjrent.rent.service.RentService;
import kr.or.kosta.sjrent.rent.service.RentServiceImpl;
import kr.or.kosta.sjrent.review.service.ReviewService;
import kr.or.kosta.sjrent.review.service.ReviewServiceImpl;

/**
 * user id를 인자로 받아서 조회 타입에 따라 예약 목록을 list 객체에 담고 rent/rent_list.jsp로 보내는 컨트롤러
 * @author 유예겸, 남수현
 *
 */
public class RentListController implements Controller {
	// 컨트롤러 사용을 위한 객체 선언
	private XMLObjectFactory factory;
	private RentService rentService;
	private ModelService modelService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 사용을 위한 객체 생성
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		rentService = (RentService) factory.getBean(RentServiceImpl.class);
		modelService = (ModelService) factory.getBean(ModelServiceImpl.class);
		mav = new ModelAndView();

		String id = (String) request.getAttribute("loginId");
	
		//list 출력 타입에 따라 분기. all은 해당 유저 전체 예약, cancel은 취소 된 예약, uncancel은 취소하지 않느 예약 past는 과거 예약, upComing은 사용 가능한 예약
		String type = request.getParameter("type");
		List<Rent> list = null;
		// 추가 정보 전달을 위한 모델명 리스트와 모델 타입 리스트 선언 및 생성
		List<String> modelNames = new ArrayList<String>();
		List<String> modelTypes = new ArrayList<String>();
		if(type != null) {
			// 조건에 따라 검색하여 해당 값 넣어주기
			if(type.equals("all")) {
				try {
					list = rentService.listByUser(id);
					for(int i = 0; i < list.size(); i++) {
						String modelName = rentService.modelNameByCarNum(list.get(i).getCarNumber());
						modelNames.add(modelName);
						Model model = modelService.read(modelName);
						modelTypes.add(model.getType());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(type.equals("cancel")) {
				try {
					list = rentService.CancellistByUser(id);
					for(int i = 0; i < list.size(); i++) {
						String modelName = rentService.modelNameByCarNum(list.get(i).getCarNumber());
						modelNames.add(modelName);
						Model model = modelService.read(modelName);
						modelTypes.add(model.getType());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(type.equals("uncancel")) {
				try {
					list = rentService.UncancellistByUser(id);
					for(int i = 0; i < list.size(); i++) {
						String modelName = rentService.modelNameByCarNum(list.get(i).getCarNumber());
						modelNames.add(modelName);
						Model model = modelService.read(modelName);
						modelTypes.add(model.getType());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(type.equals("past")) {
				try {
					list = rentService.pastListByUser(id);
					for(int i = 0; i < list.size(); i++) {
						String modelName = rentService.modelNameByCarNum(list.get(i).getCarNumber());
						modelNames.add(modelName);
						Model model = modelService.read(modelName);
						modelTypes.add(model.getType());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(type.equals("upComing")) {
				try {
					list = rentService.upComingListByUser(id);
					for(int i = 0; i < list.size(); i++) {
						String modelName = rentService.modelNameByCarNum(list.get(i).getCarNumber());
						modelNames.add(modelName);
						Model model = modelService.read(modelName);
						modelTypes.add(model.getType());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}{
			try {
				// 아무런 조건이 없을 시 다가올 예약 리스트 반환
				list = rentService.upComingListByUser(id);
//				list = rentService.listByUser(id);
				for(int i = 0; i < list.size(); i++) {
					String modelName = rentService.modelNameByCarNum(list.get(i).getCarNumber());
					modelNames.add(modelName);
					Model model = modelService.read(modelName);
					modelTypes.add(model.getType());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.addObject("modelNames", modelNames);
		mav.addObject("modelTypes", modelTypes);
		mav.addObject("list", list);
		mav.setView("/rent/rent_list.jsp");
		return mav;
	}

}
