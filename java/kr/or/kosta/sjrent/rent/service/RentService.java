package kr.or.kosta.sjrent.rent.service;

import java.util.List;

import kr.or.kosta.sjrent.rent.domain.Rent;

public interface RentService {
	/**
	 * 렌트 객체에 담긴 정보로 db에 rent insert
	 * @param rent 정보가 담긴 객체
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean create(Rent rent) throws Exception;
	
	/**
	 * rent sequence number로 rent 읽어오기
	 * @param number 값을 읽어올 sequence number
	 * @return 읽어 온 렌트 정보가 담긴 렌트 객체
	 * @throws Exception
	 */
	public Rent read(int number) throws Exception;

	/**
	 * 렌트 객체에 담긴 정보로 dv에 렌트 업데이트
	 * @param rent 렌트 정보가 단긴 겍체
	 * @throws Exception
	 */
	public void update(Rent rent) throws Exception;
	
	/**
	 * 렌트 sequence number로 rent 삭제
	 * @param number 삭제 할 rent sequence umber
	 * @throws Exception
	 */
	public void delete(int number) throws Exception;

	/**
	 * 렌트 페이징 처리 해서 해당 페이지 렌트 리스트 가져오기
	 * @param page 가져올 렌트 페이지
	 * @param listSize 페이지 당 출력 사이즈
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> listAll(int page, int listSize) throws Exception;

	/**
	 * 특정 유저 아이디에 해당하는 렌트 리스트 페이징 처리해서 가져오기
	 * @param userId 렌트 리스트를 가져 올 유저 아이디
	 * @retur 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> listByUser(String userId) throws Exception;

	/**
	 * 특정 유저 아이디에 해당하는 취소 렌트 목록 가져오기
	 * @param userId 유저 아이디
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> CancellistByUser(String userId) throws Exception;

	/**
	 * 특정 유저 아이디에 해당하는 취소되지 않은 렌트 목록 가져오기
	 * @param userId 유저 아이디
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> UncancellistByUser(String userId) throws Exception;

	/**
	 * 특정 유저 아이디에 해당하는 과거 렌트 리스트 가져오기
	 * @param userId 유저 아이디
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> pastListByUser(String userId) throws Exception;

	/**
	 * 특정 유저 아이디에 해당하는 다가올 렌트 리스트 가져오기
	 * @param userId 유저 아이디
	 * @return 해당 렌트 리스트
	 * @throws Exception
	 */
	public List<Rent> upComingListByUser(String userId) throws Exception;
	
	/**
	 * 특정 유저 예약 취소 처리하기
	 * @param number 취소 처리 할 예약 sequence number
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean cancel(int number) throws Exception;
	
	/**
	 * 차 번호를 바탕으로 해당 모델 이름 가져오기
	 * @param carNumber 모델 이름을 가져올 차 번호
	 * @return 해당 모델 이름
	 * @throws Exception
	 */
	public String modelNameByCarNum(String carNumber) throws Exception;
}
