package kr.or.kosta.sjrent.insurance.domain;

public class Insurance {
	// 보험 sequence number
	private int number;
	// 보험 이름
	private String name;
	// 보험 가격
	private int price;
	// 보험 조건
	private String compensationLimit;
	
	public Insurance() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public String getCompensationLimit() {
		return compensationLimit;
	}

	public void setCompensationLimit(String compensationLimit) {
		this.compensationLimit = compensationLimit;
	}

	@Override
	public String toString() {
		return "Insurance [number=" + number + ", name=" + name + ", price=" + price + ", compensationLimit="
				+ compensationLimit + "]";
	}

	
	
}
