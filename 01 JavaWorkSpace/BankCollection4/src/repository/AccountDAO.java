package repository;

import domain.*;
import java.util.*;

public interface AccountDAO {
	public void inseartAccount(AccountBean account);
	public List<AccountBean> selectAccountList();
	public List<AccountBean> selectAccountByName();
	public AccountBean selectAccountByID(String id);
	public int countAccounts();
	public void updateAccount(AccountBean account);
	public void deleteAccount(AccountBean account);
}
