package domain;

public class MinusAccountBean extends AccountBean {
	public final static String ACCOUNT_TYPE = "마이너스통장";
	public int limit;

	public void setLimit(String limit) {
		this.limit = Integer.parseInt(limit);
	}

	public int getLimit() {
		return limit;
	}

	public String toString() {
		return String.format("======================\n%s \n%s \n이름: %s\n계좌번호: %s\n생성날짜: %s\n아이디 : %s\n비밀번호 : ****\n대출 한도 : %d\n======================", BANK_NAME,
				ACCOUNT_TYPE, name, accountNum, createDate, uid, limit);
	}
}
