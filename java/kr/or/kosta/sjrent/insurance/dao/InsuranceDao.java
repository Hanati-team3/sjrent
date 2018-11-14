package kr.or.kosta.sjrent.insurance.dao;

import java.util.List;

import kr.or.kosta.sjrent.insurance.domain.Insurance;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface InsuranceDao {
	
	/**
	 * 보험 정보를 담은 객체로부터 db에 보험 insert
	 * @param insurance insert한 보험 정보를 담은 보험 객체
	 * @throws Exception
	 */
	public void create(Insurance insurance) throws Exception;
	
	/**
	 * 특정 보험 번호로 보험 읽어오기
	 * @param number 보험 번호
	 * @return 해당 보험 정보
	 * @throws Exception
	 */
	public Insurance read(int number) throws Exception;

	/**
	 * 보험 객체 저보로 보험 업데이트
	 * @param insurance 업데이트 할 보험 객체
	 * @throws Exception
	 */
	public void update(Insurance insurance) throws Exception;
	
	/**
	 * 특정 보험 번호의 보험 삭제
	 * @param number 삭제할 보험 번호
	 * @throws Exception
	 */
	public void delete(int number) throws Exception;

	/**
	 * 보험 전체 정보
	 * @return 보험 전체 정보 리스트
	 * @throws Exception
	 */
	public List<Insurance> listAll() throws Exception;
}
