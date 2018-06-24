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
		return "StaffBean [accessNum=" + accessNum + ", id=" + id + ", pw=" + pw + ", name=" + name + ", ssn=" + ssn
				+ ", add=" + add + ", phone=" + phone + ", email=" + email + "]";
	}

}
