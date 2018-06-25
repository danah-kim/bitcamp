package service;

import domain.AccountBean;

public interface AccountService {
	public void createAccount(AccountBean account);
	public void createMinusAccount(AccountBean account);
	public AccountBean searchAccountById(AccountBean account);
	public String updateAccountPw(AccountBean account);
	public String deleteAccount(AccountBean account);
}
