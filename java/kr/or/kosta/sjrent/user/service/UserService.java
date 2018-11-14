package kr.or.kosta.sjrent.user.service;

import java.util.List;

import kr.or.kosta.sjrent.user.domain.User;

/**
 * 고객의 요구사항을 반영한 도메인(개발하고자 하는 업무영역)별 비즈니스 메소드 선언
 * 복잡한 트랜잭션 처리, 예외처리 등
 * @author 남수현
 */
public interface UserService {
	
	/**
	 * 유저 객체 받아서 DB에 유저 입력
	 * @param 입력할 유저 객체
	 * @return 성공 여부
	 * @throws Exception
	 */
	public boolean create(User user) throws Exception;
	
	/**
	 * ID로 유저 읽기
	 * @param id 읽어 올 아이디
	 * @return 읽은 유저 객체
	 * @throws Exception
	 */
	public User read(String id) throws Exception;

	/**
	 * 핸드폰 번호로 유저 읽기
	 * @param cellphone 검색 할 전화번호
	 * @return 검색 된 유저 객체
	 * @throws Exception
	 */
	public User readByCellphone(String cellphone) throws Exception;

	/**
	 * 이메일 번호로 유저 읽기
	 * @param email 검색 할 이메일
	 * @return 검색 된 유저 객체
	 * @throws Exception
	 */
	public User readByEmail(String email) throws Exception;
	
	/**
	 * 유저 객체 받아서 유저 update
	 * @param user 업데이트 할 유저 객체
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean update(User user) throws Exception;
	
	/**
	 * @param id 삭제 할 유저 아이디
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean delete(String id) throws Exception;
	
	/**
	 * 유저 아이디와 패스워드로 완전히 일치하는 유저 객체 반환
	 * @param id 확일 할 아이디
	 * @param password 확인 할 비밀번호
	 * @return 찾은 유저 객체
	 * @throws Exception
	 */
	public User certify(String id, String password) throws Exception;
	
	/**
	 * 아이디 유무 확인
	 * @param id 확인할 아이디
	 * @return 아이디 유무
	 * @throws Exception
	 */
	public boolean isExistId(String id) throws Exception;

	/**
	 * 이메일 유무 확인
	 * @param email 확인할 이메일
	 * @return 이메일 유무
	 * @throws Exception
	 */
	public boolean isExistEmail(String email) throws Exception;

	/**
	 * 입력 된 값만틈 포인트 변화 후 결과 포인트 반환(마이너스 값 입력 시 감소) 변경 실패 시 -9999 반환
	 * @param id
	 * @param point
	 * @return
	 * @throws Exception
	 */
	public int addPoint(String id, int point)throws Exception;
	
	/**
	 * 현재 해당 유저 포인트 확인
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int checkPoint(String id)throws Exception;
	
}
