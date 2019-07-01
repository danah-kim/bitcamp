package domain;

public class MinusAccountBean extends AccountBean {
	public final static String ACCOUNT_TYPE = "마이너스통장";
	public int limit;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = -limit;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
