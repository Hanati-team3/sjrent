package kr.or.kosta.sjrent.user.dao;

import kr.or.kosta.sjrent.user.domain.User;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface UserDao {
	
	/**
	 * 유저 객체 정보에 맞춰 DB에 유저 Insert
	 * @param user 입력 할 유저 정보 객체
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean create(User user) throws Exception;
	
	/**
	 * 유저 아이디로부터 유저 정보 읽어오기
	 * @param id 읽어 올 유저 아이디
	 * @return 받아온 유저 정보를 담은 유저 객체
	 * @throws Exception
	 */
	public User read(String id) throws Exception;

	/**
	 * 전화번호로 유저 받아오기
	 * @param cellphone 받아올 전화번호
	 * @return 받아온 유저 정보를 담은 유저 객체
	 * @throws Exception
	 */
	public User readByCellphone(String cellphone) throws Exception;
	
	/**
	 * 이메일로 유저 받아오기
	 * @param email 받아올 유저 이메일
	 * @return 받아온 유저 정보를 담은 유저 객체
	 * @throws Exception
	 */
	public User readByEmail(String email) throws Exception;
	
	/**
	 * 유저 정보 업데이트
	 * @param user 업데이트 할 유저 정보가 담긴 유저 객체
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean update(User user) throws Exception;
	
	/**
	 * 유저 아이디로 유저 삭제
	 * @param id 삭제 할 유저 아이디
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean delete(String id) throws Exception;
	
	/**
	 * 아이디와 패스워드가 모두 일치하는 유저 가져오기
	 * @param id 확인 할 아이디
	 * @param passwd 확인 할 비밀번호
	 * @return 찾아온 유저
	 * @throws Exception
	 */
	public User certify(String id, String passwd) throws Exception;
	
	/**
	 * 아이디 존재 여부 확인
	 * @param id 확인 할 아이디
	 * @return 존재 유무
	 * @throws Exception
	 */
	public boolean isExistId(String id) throws Exception;

	/**
	 * 이메일 존재 여부 확인
	 * @param email 확인 할 이메일
	 * @return 존재 유무
	 * @throws Exception
	 */
	public boolean isExistEmail(String email) throws Exception;

	/**
	 * 특정 아이디 유저에 포인트 증감
	 * @param id 증감 시킬 유저 아이디
	 * @param point 증감 시킬 포인트 값
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean addPoint(String id, int point) throws Exception;

	/**
	 * 유저 아이디로 유저 포인트 확인
	 * @param id 확인 할 유저 아이디
	 * @return 유저 포인트 값
	 * @throws Exception
	 */
	public int checkPoint(String id) throws Exception;
}
