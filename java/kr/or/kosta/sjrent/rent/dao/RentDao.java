package kr.or.kosta.sjrent.rent.dao;

import java.util.List;

import kr.or.kosta.sjrent.rent.domain.Rent;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface RentDao {
	
	public boolean create(Rent rent) throws Exception;
	
	public Rent read(int rentSeq) throws Exception;

	public boolean update(Rent rent) throws Exception;
	
	public boolean delete(int number) throws Exception;

	public List<Rent> listAll(int page, int listSize) throws Exception;

	public List<Rent> listByUserId(String userId) throws Exception;

	public List<Rent> listByUserId(String userId, int isCanceled) throws Exception;

	public List<Rent> pastListByUserId(String userId) throws Exception;
	
	public List<Rent> upComingListByUserId(String userId) throws Exception;

	public boolean cancel(int number) throws Exception;
	
	public String modelNameByCarNum(String carNumber) throws Exception;
}
