package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

public class AdminController {
	private static AdminController instance = new AdminController();
	public static AdminController getInstance() {return instance;}
	private AdminController() {}

	
	public void add() {
		MemberBean member = null; 
		member = new StaffBean();
		member.setName(JOptionPane.showInputDialog("이름"));
		member.setSsn(JOptionPane.showInputDialog("주민 번호"));
		member.setPhone(JOptionPane.showInputDialog("연락처"));
		member.setEmail(JOptionPane.showInputDialog("이메일"));
		member.setAddr(JOptionPane.showInputDialog("주소"));
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("비밀번호"));
		AdminServiceImpl.getInstance().createStaff((StaffBean) member);
	}

	public void memberList() {
		//JOptionPane.showMessageDialog(null, service.list());
	}
	public void findMemberByName() {
		//JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
	}


	public void findMemberById() {
		MemberBean member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("비밀번호"));
		// 찾아야 함 JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().findById(member).toString());
	}

	public void accountList() {
		//JOptionPane.showMessageDialog(null, service.list());
	}

	public void findById() {
		AccountBean account;
		account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPw(JOptionPane.showInputDialog("비밀번호"));
		//JOptionPane.showMessageDialog(null, service.findById(account).toString());
	}
	
	public void findByName() {
		//JOptionPane.showMessageDialog(null, service.findByName((JOptionPane.showInputDialog("Name?"))));
	}
	
}