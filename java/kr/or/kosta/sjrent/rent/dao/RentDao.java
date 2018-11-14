package kr.or.kosta.sjrent.rent.dao;

import java.util.List;

import kr.or.kosta.sjrent.rent.domain.Rent;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface RentDao {
	
	/**
	 * 렌트 정보가 단김 객체로 렌트 db에 rent insert
	 * @param rent 렌트 정보가 담긴 객체
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean create(Rent rent) throws Exception;
	
	/**
	 * 렌트 번호로 특정 렌트 정보 가져오기
	 * @param rentSeq 렌트 정보를 가져 올 렌트 번호
	 * @return 해당 번호의 렌트 정보가 담긴 객체
	 * @throws Exception
	 */
	public Rent read(int rentSeq) throws Exception;

	/**
	 * 렌트 정보가 담긴 객체로 db에 rent update
	 * @param rent 렌트 정보가 담긴 렌트 객체
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean update(Rent rent) throws Exception;
	
	/**
	 * 특정 렌트 번호로 렌트 삭제
	 * @param number 삭제할 렌트 번호
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean delete(int number) throws Exception;

	/**
	 * 렌트 리스트 페이징 처리해서 가져오기
	 * @param page 가져올 페이지
	 * @param listSize 페이지 당 출력 사이즈
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> listAll(int page, int listSize) throws Exception;

	/**
	 * 특정 유저의 렌트 리스트 가져오기
	 * @param userId 리스트를 가져올 유저 아이디
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> listByUserId(String userId) throws Exception;

	/**
	 * 특정 유저의 취소 혹은 취소하지 않은 리스트 가져오기
	 * @param userId 리스트를 가져올 유저 아이디
	 * @param isCanceled 취소 여부
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> listByUserId(String userId, int isCanceled) throws Exception;

	/**
	 * 특정 유저의 과거 예약 리스트 가져오기
	 * @param userId 값을 가져 올 유저 아이디
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> pastListByUserId(String userId) throws Exception;
	
	/**
	 * 특정 유저의 다가올 예약 리스트 가져오기
	 * @param userId 값을 가져올 유저 아이디
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> upComingListByUserId(String userId) throws Exception;

	/**
	 * 특정 번호의 렌트 취소
	 * @param number 취소할 렌트 번호
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean cancel(int number) throws Exception;
	
	/**
	 * 차 이름으로 모델 이름 가져오기
	 * @param carNumber 모델 이름을 가져오고자 하는 차 번호
	 * @return 해당 차의 모델 이름
	 * @throws Exception
	 */
	public String modelNameByCarNum(String carNumber) throws Exception;
}
