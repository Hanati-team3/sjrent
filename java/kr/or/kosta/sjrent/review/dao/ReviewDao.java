package kr.or.kosta.sjrent.review.dao;

import java.util.List;
import kr.or.kosta.sjrent.review.domain.Review;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface ReviewDao {
	
	/**
	 * 받아온 리뷰 객체 정보로 DB에 리뷰 Insert
	 * @param review 받아 온 리뷰 객체
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean create(Review review) throws Exception;
	
	/**
	 * 리뷰 sequence로 리뷰 가져오기
	 * @param number 가져올 리뷰 sequence num
	 * @return 받아온 리뷰 정보가 담긴 리뷰 객체
	 * @throws Exception
	 */
	public Review read(int number) throws Exception;

	/**
	 * 리뷰 객체로 넘어온 정보로 리뷰 수정
	 * @param review 수정할 리뷰 정보가 담긴 리뷰 객체
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean update(Review review) throws Exception;
	
	/**
	 * 리뷰 sequence num으로 리뷰 삭제
	 * @param number 삭제할 리뷰 sequence num
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean delete(int number) throws Exception;

	/**
	 * 유저 아이디로 리뷰 리스트 가져오기
	 * @param userId 리뷰 리스트를 읽어 올 유저 아이디
	 * @return 리뷰 리스트
	 * @throws Exception
	 */
	public List<Review> listById(String userId) throws Exception;

	/**
	 * 모델 이름으로 리뷰 리스트 가져오기
	 * @param modelName 가져올 모델 이름
	 * @return 리뷰 리스트
	 * @throws Exception
	 */
	public List<Review> listByModel(String modelName) throws Exception;

	/**
	 * 모델 이름으로 리뷰 리스트 페이징 처리 해서 가져오기
	 * @param page 가져올 페이지
	 * @param listSize 페이지 당 출력 리스트 크기
	 * @param modelName 가져올 모델 이름
	 * @return 해당 리뷰 리스트
	 * @throws Exception
	 */
	public List<Review> listByModelByPage(int page, int listSize, String modelName) throws Exception;

	/**
	 * 모델 이름에 따른 리뷰 총 숫자
	 * @param modelName count할 모델 이름
	 * @return 해당 모델 리뷰 숫자
	 * @throws Exception
	 */
	public int countByModel(String modelName) throws Exception;
	
	/**
	 * 유저 이름으로 리뷰 리스트 페이징 처리 해서 가져오기
	 * @param page 가져올 페이지
	 * @param listSize 페이지 당 출력 리스트 크기
	 * @param userId 가져올 유저 아이디
	 * @return 해당 리뷰 리스트
	 * @throws Exception
	 */
	public List<Review> listByUserByPage(int page, int listSize, String userId) throws Exception;
	
	/**
	 * 유저 아이디에 다른 리뷰 총 숫자
	 * @param userId count할 유저 아이디
	 * @return 해당 유저 리뷰 숫자
	 * @throws Exception
	 */
	public int countByUser(String userId) throws Exception;
	
}
