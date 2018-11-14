package kr.or.kosta.sjrent.rent.domain;

public class Rent {
	
	// 렌트 sequence number
	private int seq;
	// 렌트에 사용된 보험 번호
	private int insuranceNumber;
	// 렌트 유저 번호
	private int userSeq;
	// 렌트 유저 아이디
	private String userId;
	// 렌트 차 번호
	private String carNumber;
	// 렌트 시작일
	private String startDate;
	// 렌트 종료일
	private String endDate;
	// 차 수령 장소
	private String pickupPlace;
	// 렌트 총액
	private int paidAmount;
	// 렌트 결제 방법
	private String paymentOption;
	// 렌트 취소 여부
	private int isCanceled;
	
	public Rent() {
		super();
	}

	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(int insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
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

	public String getPickupPlace() {
		return pickupPlace;
	}

	public void setPickupPlace(String pickupPlace) {
		this.pickupPlace = pickupPlace;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public int getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(int isCanceled) {
		this.isCanceled = isCanceled;
	}

	@Override
	public String toString() {
		return "Rent [seq=" + seq + ", insuranceNumber=" + insuranceNumber + ", userSeq=" + userSeq + ", userId="
				+ userId + ", carNumber=" + carNumber + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", pickupPlace=" + pickupPlace + ", paidAmount=" + paidAmount + ", paymentOption=" + paymentOption
				+ ", isCanceled=" + isCanceled + "]";
	}

	
	
	

}
