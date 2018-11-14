package kr.or.kosta.sjrent.wishitem.domain;

public class WishItem {
	// 위시아이템 sequence
	private int number;
	// 위시 아이템을 입력 한 유저 sequence
	private int userNumber;
	// 위시 아이템을 입력 한 유저 아이디
	private String userId;
	// 위시 아이템에 들어온 차의 모델 이름
	private String modelName;
	// 위시 아이템의 렌트 시작 날짜
	private String startDate;
	// 위시 아이템의 렌트 종료 날짜
	private String endDate;
	// 위시 아이템의 총 결제 금액
	private int amountMoney;
	// 위시 아이템의 차 모델 사진
	private String picture;
	// 위시 아이템의 차 타입(중형, 대형 등)
	private String type;
	// 위시 아이템의 차 연료 타입
	private String fuelType;
	
	public WishItem() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	public int getAmountMoney() {
		return amountMoney;
	}

	public void setAmountMoney(int amountMoney) {
		this.amountMoney = amountMoney;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "WishItem [number=" + number + ", userNumber=" + userNumber + ", userId=" + userId + ", modelName="
				+ modelName + ", startDate=" + startDate + ", endDate=" + endDate + ", amountMoney=" + amountMoney
				+ ", picture=" + picture + ", type=" + type + ", fuelType=" + fuelType + "]";
	}
}
