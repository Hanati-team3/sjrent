package kr.or.kosta.sjrent.wishitem.service;

import java.util.List;

import kr.or.kosta.sjrent.wishitem.domain.WishItem;

public interface WishItemService {
	/**
	 * wishItem 객체를 받아서 db에 wishitem 쓰기
	 * @param wishItem 쓸 wishItem
	 * @return 성공 : 0 , 실패 : 1
	 * @throws Exception
	 */
	public boolean create (WishItem wishItem) throws Exception;

	/**
	 * 위시 아이템 넘버로 위시 아이템 읽어오기
	 * @param wishItemNumber
	 * @return 읽어온 정보가 담긴 wishitem 객체
	 * @throws Exception
	 */
	public WishItem read (int wishItemNumber) throws Exception;

	/**
	 * 위시 아이템 넘버로 위시 아이템 삭제
	 * @param wishItemNumber
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean delete (int wishItemNumber) throws Exception;

	/**
	 * 유저 기반으로 wishitem list 가져오기
	 * @param userId wishitem을 가져올 유저 아이디
	 * @return 해당 유저의 wishitem List
	 * @throws Exception
	 */
	public List<WishItem> listByUser(String userId) throws Exception;
}
