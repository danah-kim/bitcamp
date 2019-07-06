package service;

import domain.AccountBean;

public interface AccountService {
	public void addList(AccountBean account);
	public AccountBean[] addList();
	public AccountBean createAccount(String name, String uid, String pw);
	public int deposit(int balance, String money);
	public int withdraw(int balance, String money);
	public String createAccountNum(String random);
	public String createRandom(int start, int end);
	public String creaDate();
	public String showResult();
}
