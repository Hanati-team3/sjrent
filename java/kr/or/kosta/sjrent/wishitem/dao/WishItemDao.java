package kr.or.kosta.sjrent.wishitem.dao;

import java.util.List;

import kr.or.kosta.sjrent.wishitem.domain.WishItem;

/**
 * 위시아이템 db 접근을 위한 dao 규약
 * @author 남수현
 *
 */
public interface WishItemDao {

	/**
	 * wishItem 객체 정보 db insert
	 * @param wishItem
	 * @return 성공, 실패
	 * @throws Exception
	 */
	public boolean create (WishItem wishItem) throws Exception;

	/**
	 * wishItemNumber에 해당하는 wishItem 정보 wishitem 객체로 반환
	 * @param wishItemNumber 찾을 wishitem 번호
	 * @return 찾아 진 wishitem 정보를 wishitem 객체로 return
	 * @throws Exception
	 */
	public WishItem read (int wishItemNumber) throws Exception;

	/**
	 * wishItem 객체 받아서 db에 wishitem 업데이트 
	 * @param wishItem 업데이트 할 wishitem 객체
	 * @throws Exception
	 */
	public void update (WishItem wishItem) throws Exception;

	/**
	 * 특정 wishitemnumber wishitem 삭제
	 * @param wishItemNumber
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean delete (int wishItemNumber) throws Exception;

	/**
	 * 위시 아이템 전체 리스트 반환
	 * @return 위시 아이템 리스트
	 * @throws Exception
	 */
	public List<WishItem> listAll() throws Exception;

	/**
	 * 특정 유저의 wishitem list 반환
	 * @param userId
	 * @return 특정 유저의 wish item
	 * @throws Exception
	 */
	public List<WishItem> listByUser(String userId) throws Exception;
}
