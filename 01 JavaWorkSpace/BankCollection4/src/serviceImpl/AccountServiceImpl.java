package serviceImpl;

import java.util.*;
import domain.*;
import service.*;

public class AccountServiceImpl implements AccountService {
	private static AccountService instance = new AccountServiceImpl();	
	public static AccountService getInstance() {return instance;}
	private AccountServiceImpl() {};
	

	@Override
	public void creatAccount(AccountBean account) {
		account.setAccountNum("");
		account.setAccountType("");
		account.setCreateDate("");
		addList(account);
		
	}
	
	@Override
	public void creatMinusAccount(MinusAccountBean account) {
		account.setAccountNum("");
		account.setAccountType("");
		account.setCreateDate("");
		account.setLimit("");
		addList(account);
	}

	@Override
	public void addList(AccountBean account) {
		//list.add(account);
		
	}

	@Override
	public void updatePw(AccountBean account) {
		AccountBean temp = new AccountBean();
		String oldPw = account.getPw().split("/")[0];
		String newPw = account.getPw().split("/")[1];
		//temp = list.get(list.indexOf(findById(account)));
		if(temp.getPw().equals(oldPw)) {
			temp.setPw(newPw);
			//list.add(list.indexOf(temp),temp);
		}
	}

	@Override
	public void deleteAccount(AccountBean account) {
		AccountBean temp = new AccountBean();
		String pw = account.getPw().split("/")[0];
		String confirmPw = account.getPw().split("/")[1];
		//temp = list.get(list.indexOf(findById(account)));
		if((pw.equals(temp.getPw())) && (confirmPw.equals(temp.getPw()))) {
			//list.remove(temp);
		}
	}

}
