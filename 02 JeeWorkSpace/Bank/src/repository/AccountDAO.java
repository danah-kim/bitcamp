package repository;

import domain.*;
import java.util.List;

public interface AccountDAO {
	public void insertAccount(AccountBean account);
	public List<AccountBean> selsecAccountList();
	public List<AccountBean> selsectAccountByName(String name);
	public AccountBean selectAccountByID(String id);
	public int countAccounts();
	public String updateAccount(AccountBean account);
	public String deleteAccount(AccountBean account);
}
