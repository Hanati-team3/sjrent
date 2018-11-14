package kr.or.kosta.sjrent.insurance.service;

import java.util.List;

import kr.or.kosta.sjrent.insurance.domain.Insurance;

public interface InsuranceService {
	
	/**
	 * 특정 보험 번호의 보험 정보 읽어오기
	 * @param number 정보를 받아올 보험 번호
	 * @return 해당 보험 정보가 담긴 보험 객체
	 * @throws Exception
	 */
	public Insurance read(int number) throws Exception;

	/**
	 * 전체 보험 정보 가져오기
	 * @return 전체 보험 정보
	 * @throws Exception
	 */
	public List<Insurance> listAll() throws Exception;
}
