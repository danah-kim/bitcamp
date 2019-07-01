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

	@Override
	public String toString() {
		return "MinusAccountBean [" + BANK_NAME + ", money=" + money + ", name=" + name + ", id=" + id + ", pw=" + pw + ", createDate="
				+ createDate + ", accountType=" + accountType + ", accountNo=" + accountNo + ", limit=" + limit + "]";
	}

}
