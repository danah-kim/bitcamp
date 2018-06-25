package repositoryImpl;

import java.util.List;

import domain.AccountBean;
import repository.AccountDAO;

public class AccountDAOImpl implements AccountDAO{
	private static AccountDAO instance = new AccountDAOImpl();
	public static AccountDAO getInstance() {return instance;}
	private AccountDAOImpl() {}

	@Override
	public void insertAccount(AccountBean account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AccountBean> selsecAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountBean> selsectAccountByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountBean selectAccountByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String updateAccount(AccountBean account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAccount(AccountBean account) {
		// TODO Auto-generated method stub
		return null;
	}

}
