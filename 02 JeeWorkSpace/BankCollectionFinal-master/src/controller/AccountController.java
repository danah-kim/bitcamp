package controller;

import javax.swing.JOptionPane;

import domain.*;
import serviceImpl.*;

public class AccountController {
	private static AccountController instance = new AccountController();
	public static AccountController getInstance() {return instance;}
	private AccountController() {}

	
	public void createAccount(AccountBean account) {
		AccountServiceImpl.getInstance().createAccount(account);
		System.out.println("==========멤버 컨트롤러==========");
		System.out.println("화면에서 넘어온 객체 :"+ account);
		
		
		/*AccountBean account = new AccountBean();
		account.setName(JOptionPane.showInputDialog("이름"));
		account.setId(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("비밀번호"));
		AccountServiceImpl.getInstance().createAccount(account);*/
	}

	public void createMinusAccount() {
		AccountBean account = new MinusAccountBean();
		//account.setName(JOptionPane.showInputDialog("이름"));
		//account.setId(JOptionPane.showInputDialog("아이디"));
		//account.setPw(JOptionPane.showInputDialog("비밀번호"));
		((MinusAccountBean) account).setLimit(Integer.parseInt(JOptionPane.showInputDialog("대출 한도")));
		AccountServiceImpl.getInstance().createMinusAccount(account);
	}
	
	public void searchAccountByID() {
		AccountBean account = new AccountBean();
		//account.setId(JOptionPane.showInputDialog("아이디"));
		JOptionPane.showMessageDialog(null, AccountServiceImpl.getInstance().searchAccountById(account).toString());
	}

	public void updateAccountPw() {

		AccountBean account;
		account = new AccountBean();
		//account.setId(JOptionPane.showInputDialog("아이디"));
		//account.setPw(JOptionPane.showInputDialog("기존 비밀번호") + "/" + JOptionPane.showInputDialog("새 비밀번호"));
		JOptionPane.showMessageDialog(null, AccountServiceImpl.getInstance().updateAccountPw(account));
	}

	public void deleteAccount() {
		AccountBean account = new AccountBean();
		//account.setId(JOptionPane.showInputDialog("아이디"));
		//account.setPw(JOptionPane.showInputDialog("비밀번호") + "/" + JOptionPane.showInputDialog("비밀번호 재확인"));
		JOptionPane.showMessageDialog(null, AccountServiceImpl.getInstance().deleteAccount(account));
	}

}
