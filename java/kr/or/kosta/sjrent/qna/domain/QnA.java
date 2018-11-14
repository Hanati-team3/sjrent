package kr.or.kosta.sjrent.qna.domain;

public class QnA {
	// qna sequence number
	private int number;
	// qna 작성 유저 번호
	private int userSeq;
	// qna 작성 유저 아이디
	private String userId;
	// qna 제목
	private String title;
	// qna 내용
	private String content;
	// qna 작성일
	private String date;
	// qna 답변
	private String answer;

	public QnA() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QnA [number=" + number + ", userSeq=" + userSeq + ", userId=" + userId + ", title=" + title
				+ ", content=" + content + ", date=" + date + ", answer=" + answer + "]";
	}
	
	
	

}
