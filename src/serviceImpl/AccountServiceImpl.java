package serviceImpl;

import domain.*;
import service.*;

public class AccountServiceImpl implements AccountService{
	private static AccountService instance = new AccountServiceImpl();	
	public static AccountService getInstance() {return instance;}
	private AccountServiceImpl() {};


	@Override
	public void createAccount(AccountBean account) {
		//account.setAccountNo(createAccountNo());
			account.setAccountType(AccountBean.ACCOUNT_TYPE);
		//account.setCreateDate(createAccountDate());
		//list.add(account);
		
	}

	@Override
	public void createMinusAccount(AccountBean account) {
		//account.setAccountNo(createAccountNo());
			account.setAccountType(MinusAccountBean.ACCOUNT_TYPE);
		//account.setCreateDate(createAccountDate());
		//list.add(account);
		
	}

	@Override
	public AccountBean searchAccountById(AccountBean account) {
		AccountBean temp = new AccountBean();

		/*for (AccountBean e : list) {
			if (account.getId().equals(e.getId())) {
				temp = e;
				break;
			}
		}*/
		return temp;
	}

	@Override
	public String updateAccountPw(AccountBean account) {
		String msg = "변경 실패";
		AccountBean temp = new AccountBean();
		String oldPw = account.getPw().split("/")[0];
		String newPw = account.getPw().split("/")[1];
		//temp = list.get(list.indexOf(searchAccountById(account)));

		if (temp.getId() == null) {
			msg = "아이디가 존재하지 않습니다.";
		} else {
			if (temp.getPw().equals(oldPw)) {
				temp.setPw(newPw);
				//list.add(list.indexOf(temp), temp);
				msg = "변경 성공";
			}
		}
		return msg;
	}

	@Override
	public String deleteAccount(AccountBean account) {
		String msg = "삭제 실패";
		AccountBean temp = new AccountBean();
		String pw = account.getPw().split("/")[0];
		String confrimPw = account.getPw().split("/")[1];
		//temp = list.get(list.indexOf(searchAccountById(account)));

		if (account.getId() == null) {
			msg = "아이디가 존재하지 않습니다.";
		} else {
			if (pw.equals(temp.getPw()) && pw.equals(confrimPw)) {
				//list.remove(temp);
				msg = "삭제 완료";
			}
		}
		return msg;
	}

}
