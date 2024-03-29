package domain;

public class UserBean extends MemberBean {
	private String creditRating;

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	@Override
	public String toString() {
		return "UserBean [creditRating=" + creditRating + ", userId=" + userId + ", pw=" + pw + ", name=" + name + ", ssn="
				+ ssn + ", addr=" + addr + ", phone=" + phone + ", email=" + email + "]";
	}

}
