package domain;

public class StaffBean extends MemberBean {
	private String accessNum;

	public String getAccessNum() {
		return accessNum;
	}

	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}

	public String toSting() {
		return "< 회원 정보 >\n아이디 :" + uid + "\n" + "비밀번호 : ****" + "\n" + "이름 :" + name + "\n" + "주민번호 : ******-*******"
				+ "\n" + "주소 :" + addr + "\n" + "연락처 :" + phone + "\n" + "이메일 :" + email + "\n" + "접근 번호 : " + accessNum
				+ "\n\n";

	}
}
