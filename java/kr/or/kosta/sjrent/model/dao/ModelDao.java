package kr.or.kosta.sjrent.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.params.ModelParams;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface ModelDao {

	/**
	 * model 정보가 담긴 model 객체 받아서 db model insert
	 * @param model 정보가 담긴 model 객체
	 * @throws Exception
	 */
	public void create(Model model) throws Exception;
	
	/**
	 * 모델 네임으로 해당 모델 정보 받아 객체로 반환
	 * @param name 정보를 읽어 올 모델 네임
	 * @return 정보가 담긴 모델 객체
	 * @throws Exception
	 */
	public Model read(String name) throws Exception;

	/**
	 * 모델 정보가 담긴 모델 객체를 받아서 모델 수정
	 * @param model 수정할 모델 객체
	 * @throws Exception
	 */
	public void update(Model model) throws Exception;
	
	/**
	 * 특정 모델 네임 모델 삭제
	 * @param name 삭제할 모델 이름
	 * @throws Exception
	 */
	public void delete(String name) throws Exception;

	/**
	 * 모델 전체 리스트 가져오기
	 * @return 모델 전체 리스트
	 * @throws Exception
	 */
	public List<Model> listAll() throws Exception;

	/**
	 * 모델 리스트 페이징 처리해서 가져오기
	 * @param page 페이지
	 * @param listSize 페이지당 출력 숫자
	 * @return 해당 모델 리스트
	 * @throws Exception
	 */
	public List<Model> listByPage(int page, int listSize) throws Exception;
	
	/**
	 * 검색 값에 다른 모델 리스트 출력
	 * @param page 페이지
	 * @param listSize 페이지당 출력 사이즈
	 * @param startDate 렌트 시작일
	 * @param endDate 렌트 종료일
	 * @param fuelType 연료 종류
	 * @param seater 인승
	 * @param transmission 변속기(수동, 자동(
	 * @param navigation 네비게이션
	 * @param cameraRear 후방 카메라
	 * @param blackBox 블랙박스
	 * @return 해당 모델 리스트
	 * @throws Exception
	 */
	public List<Model> listBySearch(int page, int listSize, String startDate, String endDate, String fuelType, int seater,
			String transmission, String navigation, String cameraRear, String blackBox) throws Exception;
	
	/**
	 * modelParams에 담긴 값으로 검색하여 모델 리스트 반환
	 * @param modelParams 검색할 modelParams
	 * @return 해당 모델 리스트
	 * @throws Exception
	 */
	public List<Model> listBySearch(ModelParams modelParams) throws Exception;

	/**
	 * 검색 값에 따른 모델 숫자
	 * @param page
	 * @param listSize
	 * @param startDate 렌트 시작일
	 * @param endDate 렌트 종료일
	 * @param fuelType 연료 종류
	 * @param seater 인승
	 * @param transmission 변속기(수동, 자동(
	 * @param navigation 네비게이션
	 * @param cameraRear 후방 카메라
	 * @param blackBox 블랙박스
	 * @return 해당 모델 리스트
	 * @throws Exception
	 */
	public int countBySearch(int page, int listSize, String startDate, String endDate, String fuelType, int seater,
			String transmission, String navigation, String cameraRear, String blackBox) throws Exception;
	
	/**
	 * modelParams에 담긴 값으로 검색하여 검색량 반환
	 * @param modelParams 검색할 modelParams
	 * @return 검색량
	 * @throws Exception
	 */
	public int countBySearch(ModelParams modelParams) throws Exception;
	
	/**
	 * 인기 모델 리스트
	 * @param 출력값
	 * @return 해당 모델 리스트
	 * @throws Exception
	 */
	public List<Model> popularModel(int num) throws Exception;
	
	/**
	 * 추천 모델 리스트
	 * @param num 추천 숫자
	 * @return 해당 모델 리스트
	 * @throws Exception
	 */
	public List<Model> recommendModel(int num) throws Exception;
	
	/**
	 * 모델 대여 횟수 변경
	 * @param name 모델 이름
	 * @param num 변경할 횟수
	 * @return 성공 실패
	 * @throws Exception
	 */
	public boolean changeCount(String name, int num) throws Exception;
	
	/**
	 * 특정 일에 해당 모델의 이용 가능한 차 리스트
	 * @param startDate
	 * @param endDate
	 * @param modelName
	 * @return
	 * @throws Exception
	 */
	public List<String> checkEnableCar(String startDate, String endDate, String modelName) throws Exception;
	
	/**
	 * 특정 모델의 사용 불가능 일자 받아오기(이번델 제외 앞으로 3달까지)
	 * @param modelName 일자를 받아올 모델 이름
	 * @key : return 차번호 , value : 모델 이름 리스트
	 * @throws Exception
	 */
	public List<Map<String,Object>> periodByModelName(String modelName) throws Exception;
	
	/**
	 * 모델 이름 별 위시아이템 포함 횟수 가져오기
	 * @param modelName 가져올 모델 이름
	 * @return 위시아이템 포함 횟수
	 * @throws Exception
	 */
	public int countWishItemByModelName(String modelName) throws Exception;

}
