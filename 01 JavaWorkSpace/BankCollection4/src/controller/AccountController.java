package controller;

import javax.swing.JOptionPane;
import domain.*;
import serviceImpl.*;

public class AccountController {
	private static AccountController instance = new AccountController();
	public static AccountController getInstance() {return instance;}
	private AccountController() {}


	public void account() {
		AccountBean account;
		account = new AccountBean();
		account.setName(JOptionPane.showInputDialog("이름"));
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("비밀번호"));
		AccountServiceImpl.getInstance().creatAccount(account);
	}

	public void minus_account() {
		AccountBean account;
		account = new MinusAccountBean();
		account.setName(JOptionPane.showInputDialog("이름"));
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("비밀번호"));
		((MinusAccountBean) account).setLimit(JOptionPane.showInputDialog("대출 한도"));
		AccountServiceImpl.getInstance().creatAccount(account);
	}

	public void updatePw() {
		AccountBean account;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("기존 비밀번호") + "/" + JOptionPane.showInputDialog("새비밀번호"));
		AccountServiceImpl.getInstance().updatePw(account);
	}

	public void deleteAccount() {
		AccountBean account=null;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("비밀번호") + "/" + JOptionPane.showInputDialog("비밀번호 재확인"));
	}
}
