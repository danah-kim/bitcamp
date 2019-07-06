package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.*;
import domain.*;
import service.*;

public class AccountServiceImpl implements AccountService {
	List<AccountBean> list;
	
	public AccountServiceImpl() {
		list = new ArrayList<>();
	}

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
		list.add(account);
		
	}

	@Override
	public String createAccountNum() {
		String num = "";

		for (int i = 0; i < 3; i++) {
			num += (i == 2) ? String.format("%03d", (int) (Math.random() * 999))
					: String.format("%03d", (int) (Math.random() * 999)) + "-";
		}
		return num;
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	@Override
	public List<AccountBean> list() {
		return list;
	}

	@Override
	public AccountBean findById(AccountBean id) {
		AccountBean temp = new AccountBean();
		for(int i = 0; i<list.size(); i++) {
			if(id.equals(list.get(i))) {
				temp = list.get(i);
				break;
			}
		}
		return temp;
	}

	@Override
	public List<AccountBean> findByName(String name) {
		List<AccountBean> arr = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			if(name.equals(list.get(i).getName())) {
				arr.add(list.get(i));
			}
		}
		return arr;
	}

	@Override
	public void updatePw(AccountBean account) {
		AccountBean temp = new AccountBean();
		String oldPw = account.getPw().split("/")[0];
		String newPw = account.getPw().split("/")[1];
		temp = list.get(list.indexOf(findById(account)));
		if(temp.getPw().equals(oldPw)) {
			temp.setPw(newPw);
			list.add(list.indexOf(temp),temp);
		}
	}

	@Override
	public void deleteAccount(AccountBean account) {
		AccountBean temp = new AccountBean();
		String pw = account.getPw().split("/")[0];
		String confirmPw = account.getPw().split("/")[1];
		temp = list.get(list.indexOf(findById(account)));
		if((pw.equals(temp.getPw())) && (confirmPw.equals(temp.getPw()))) {
			list.remove(temp);
		}
	}

}
