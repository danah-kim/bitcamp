package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

public class AccountController {

	public void account() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		account = new AccountBean();
		account.setName(JOptionPane.showInputDialog("이름"));
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("비밀번호"));
		service.creatAccount(account);
	}

	public void minus_account() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		account = new MinusAccountBean();
		account.setName(JOptionPane.showInputDialog("이름"));
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("비밀번호"));
		((MinusAccountBean) account).setLimit(JOptionPane.showInputDialog("대출 한도"));
		service.creatAccount(account);
	}

	public void list() {
		AccountService service = new AccountServiceImpl();
		JOptionPane.showMessageDialog(null, service.list());
	}

	public void minus_list() {
		AccountService service = new AccountServiceImpl();
		JOptionPane.showMessageDialog(null, service.list());
	}

	public void findById() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("비밀번호"));
		JOptionPane.showMessageDialog(null, service.findById(account).toString());
	}

	public void findByName() {
		AccountService service = new AccountServiceImpl();
		JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
	}

	public void updatePw() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("기존 비밀번호") + "/" + JOptionPane.showInputDialog("새비밀번호"));
		//JOptionPane.showMessageDialog(null, service.updatePw(account));
	}

	public void delete() {
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("비밀번호") + "/" + JOptionPane.showInputDialog("비밀번호 재확인"));
		//JOptionPane.showMessageDialog(null, service.deleteAccount(account));
	}
}
