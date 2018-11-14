package kr.or.kosta.sjrent.review.service;

import java.util.List;

import kr.or.kosta.sjrent.review.domain.Review;

public interface ReviewService {
	/**
	 * 리뷰 객체로 정보를 받아서 db에 리뷰 insert
	 * @param review insert 할 리뷰 정보가 담긴 리뷰 객체
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean create(Review review) throws Exception;
	
	/**
	 * 리뷰 번호로 리뷰 읽기
	 * @param number 읽어 올 리뷰 번호
	 * @return 읽어 온 리뷰 정보가 담긴 리뷰 객체
	 * @throws Exception
	 */
	public Review read(int number) throws Exception;

	/**
	 * 리뷰 객체로 db에 리뷰 업데이트
	 * @param review 업데이트 할 리뷰 정보
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean update(Review review) throws Exception;
	
	/**
	 * 리뷰 번호 받아서 리뷰 삭제
	 * @param number 삭제 할 리뷰 번호
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean delete(int number) throws Exception;

	/**
	 * 유저 아이디 기반으로 리뷰객체 리스트 받아오기
	 * @param userId 받아 올 유저 아이디
	 * @return 반한 된 리뷰 리스트
	 * @throws Exception
	 */
	public List<Review> listById(String userId) throws Exception;
	
	/**
	 * 모델 명으로 리뷰 리스트 받아오기
	 * @param modelName 리뷰 리스트를 받아 올 모델명
	 * @return 받아온 리뷰 리스트
	 * @throws Exception
	 */
	public List<Review> listByModel(String modelName) throws Exception;
	
	/**
	 * 모델 명과 페이지 번호, 출력 리스트 사이즈로 리뷰 리스트 받아오기
	 * @param page 출력할 페이지
	 * @param listSize 출력할 리스트 사이즈
	 * @param modelName 가져올 모델 이름
	 * @return 가져온 리뷰 리스트
	 * @throws Exception
	 */
	public List<Review> listByModelByPage(int page, int listSize, String modelName) throws Exception;

	/**
	 * 유저 아이디와 페이지 번호, 출력 리스트 사이즈로 리뷰 리스트 받아오기
	 * @param page 출력할 페이지
	 * @param listSize 출력할 리스트 사이즈
	 * @param userId 가져올 유저 아이디
	 * @return 가져온 리뷰 리스트
	 * @throws Exception
	 */
	public List<Review> listByUserByPage(int page, int listSize, String userId) throws Exception;

	/**
	 * 모델 네임 기반 리뷰 총 숫자
	 * @param modelName 해당 모델 이름
	 * @return 해당 모델 리뷰 숫자
	 * @throws Exception
	 */
	public int countByModel(String modelName) throws Exception;
	
	/**
	 * 유저 아이디 기반 리뷰 숫자
	 * @param userId 해당 유저 아이디
	 * @return 해당 유저 리뷰 리스트
	 * @throws Exception
	 */
	public int countByUser(String userId) throws Exception;
}
