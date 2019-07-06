package domain;

public class StaffBean extends MemberBean{
	private String accessNum;

	public String getAccessNum() {
		return accessNum;
	}

	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}

	@Override
	public String toString() {
		return "StaffBean [accessNum=" + accessNum + ", userId=" + userId + ", pw=" + pw + ", name=" + name + ", ssn=" + ssn
				+ ", addr=" + addr + ", phone=" + phone + ", email=" + email + "]";
	}

}
