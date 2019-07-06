package domain;

public class AccountBean {
	public static final String BANK_NAME = "비트뱅크";
	public final static String ACCOUNT_TYPE = "기본통장";
	protected int money;
	protected String name, uid, pw, createDate, accountType, accountNum;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String toString() {
		return String.format(
				"======================\n%s \n%s \n이름: %s\n계좌번호: %s\n생성날짜: %s\n아이디 : %s\n비밀번호 : **** \n======================",
				BANK_NAME, ACCOUNT_TYPE, name, accountNum, createDate, uid);
	}

}
