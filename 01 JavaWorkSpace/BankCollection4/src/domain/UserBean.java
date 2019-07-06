package domain;

public class UserBean extends MemberBean {
	private String creditRating;

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public String toString() {
		return "< 회원 정보 >\n아이디 : " + uid + "\n" + "비밀번호 : ****" + "\n" + "이름 :" + name + "\n" + "주민번호 : ******-*******"
				+ "\n" + "주소 :" + addr + "\n" + "연락처 :" + phone + "\n" + "이메일 :" + email + "\n" + "신용 등급 : "
				+ creditRating + "\n\n";
	}

}
