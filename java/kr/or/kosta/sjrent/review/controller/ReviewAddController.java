package kr.or.kosta.sjrent.review.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.exception.RentException;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.common.fileRename.ReviewFileRename;
import kr.or.kosta.sjrent.common.listener.ServletContextLoadListener;
import kr.or.kosta.sjrent.review.domain.Review;
import kr.or.kosta.sjrent.review.service.ReviewService;
import kr.or.kosta.sjrent.review.service.ReviewServiceImpl;
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;

/**
 * Review add 처리
 * @author 남수현
 */
public class ReviewAddController implements Controller {
	// 컨트롤러 사용을 위한 객체 선언
	private XMLObjectFactory factory;
	private ReviewService reviewService;
	private UserService userService;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 컨트롤러 사용을 위한 객체 생성
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		reviewService = (ReviewService) factory.getBean(ReviewServiceImpl.class);
		userService = (UserService) factory.getBean(UserServiceImpl.class);
		User user = new User();
		String loginId = (String) request.getAttribute("loginId");
		try {
			// 로그인 되어 있는 유저 받아오기
			user = userService.read(loginId);
		} catch (Exception e1) {
			throw new RentException("is not logined page");
		}	
		// 파일 저장 경로
		String root = "C:\\KOSTA187\\";
	    String savePath = root + "images\\review";
	 
	    // 업로드 파일명
	    String uploadFile = "";
	 
	    // 실제 저장할 파일명
	    String newFileName = "";

	    
		String modelName = null;
		String title = null;
		String content = null;
		String picture = null;
		String evalScoreS = null;
		// 파일 최대 사이즈
		int size = 10*1024*1024;
		// 파일 리네임 규칙 생성
		ReviewFileRename rfr = new ReviewFileRename();
		rfr.setUserSeq(user.getSeq());
		
		try{
			// 필요한 값 수신
		    MultipartRequest multi=new MultipartRequest(request,savePath,size,"utf-8",rfr);
			modelName = multi.getParameter("modelName");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			evalScoreS = multi.getParameter("evalScore");
		    Enumeration files = multi.getFileNames();
		    String file = (String)files.nextElement();
		    picture = multi.getFilesystemName(file);
		}catch(Exception e){
		    e.printStackTrace();
		}
		
		int evalScore = 0;
		if (evalScoreS != null && !evalScoreS.equals("")) {
			evalScore = Integer.parseInt(evalScoreS);
		}

		int userNumber = user.getSeq();
		String userId = user.getId();

		// 리뷰 객체에 값 setting
		Review review = new Review();
		review.setUserNumber(userNumber);
		review.setUserId(userId);
		review.setTitle(title);
		review.setPicture(picture);
		review.setModelName(modelName);
		review.setEvalScore(evalScore);
		review.setContent(content);
		mav = new ModelAndView();
		try {
			//리뷰 생성 및 메시지, mav 처리
			if (reviewService.create(review)) {
				mav.addObject("message", "create_success");
			} else {
				mav.addObject("message", "create_fail");
			}
		} catch (Exception e) {
			mav.addObject("message", "create_error:"+e);
		}
		mav.setView("/rent/list.rent");
		return mav;
	}

}
