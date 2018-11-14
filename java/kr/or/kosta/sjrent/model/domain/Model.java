package kr.or.kosta.sjrent.model.domain;

public class Model {

	// 모델명
	private String name;
	// 연로 타입
	private String fuelType;
	// 연비
	private double fuelEfficiency;
	// 인승
	private int seater;
	// 변속기
	private String transmission;
	// 네비게이션
	private int navigation;
	// 후방카메라
	private int cameraRear;
	//연식
	private int year;
	//하이패스
	private int highpass;
	// 블랙박스
	private int blackBox;
	// 기타옵션
	private String options;
	// 모델 그림 위치
	private String picture;
	// 모델 타입(소형, 중형, 대형)
	private String type;
	// 주중 가격
	private int weekdayPrice;
	// 주말 가격
	private int weekendPrice;
	// 모델 평점
	private double evalScore;
	// 모델 대여 횟수
	private int rentalCount;
	// 모델 리뷰 숫자
	private int reviewCount;
	
	public Model() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}
	public void setFuelEfficiency(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}
	public int getSeater() {
		return seater;
	}
	public void setSeater(int seater) {
		this.seater = seater;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public int getNavigation() {
		return navigation;
	}
	public void setNavigation(int navigation) {
		this.navigation = navigation;
	}
	public int getCameraRear() {
		return cameraRear;
	}
	public void setCameraRear(int cameraRear) {
		this.cameraRear = cameraRear;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHighpass() {
		return highpass;
	}
	public void setHighpass(int highpass) {
		this.highpass = highpass;
	}

	public int getBlackBox() {
		return blackBox;
	}
	public void setBlackBox(int blackBox) {
		this.blackBox = blackBox;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getWeekdayPrice() {
		return weekdayPrice;
	}
	public void setWeekdayPrice(int weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}
	public int getWeekendPrice() {
		return weekendPrice;
	}
	public void setWeekendPrice(int weekendPrice) {
		this.weekendPrice = weekendPrice;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getEvalScore() {
		return evalScore;
	}
	public void setEvalScore(double evalScore) {
		this.evalScore = evalScore;
	}
	public int getRentalCount() {
		return rentalCount;
	}
	public void setRentalCount(int rentalCount) {
		this.rentalCount = rentalCount;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	@Override
	public String toString() {
		return "Model [name=" + name + ", fuelType=" + fuelType + ", fuelEfficiency=" + fuelEfficiency + ", seater="
				+ seater + ", transmission=" + transmission + ", navigation=" + navigation + ", cameraRear="
				+ cameraRear + ", year=" + year + ", highpass=" + highpass + ", blackBox=" + blackBox + ", options="
				+ options + ", picture=" + picture + ", type=" + type + ", weekdayPrice=" + weekdayPrice
				+ ", weekendPrice=" + weekendPrice + ", evalScore=" + evalScore + ", rentalCount=" + rentalCount
				+ ", reviewCount=" + reviewCount + "]";
	}
	
}
