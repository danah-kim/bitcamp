package service;

import domain.*;
import java.util.List;
import java.util.Map;

public interface AccountService {
	public void creatAccount(AccountBean account);
	public void creatMinusAccount(MinusAccountBean account);
	public void addList(AccountBean account);
	public String createAccountNum();
	public String createDate();
	public List<AccountBean> list();
	public AccountBean findById(AccountBean id);
	public List<AccountBean> findByName(String name);
	public void updatePw(AccountBean account);
	public void deleteAccount(AccountBean account);
}
