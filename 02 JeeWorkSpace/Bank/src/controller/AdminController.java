package controller;

import javax.swing.JOptionPane;

import domain.*;
import serviceImpl.*;

public class AdminController {
	private static AdminController instance = new AdminController();
	public static AdminController getInstance() {return instance;}
	private AdminController() {}
	

	public void createStaff(StaffBean staff) {
		System.out.println("==========멤버 컨트롤러==========");
		System.out.println("화면에서 넘어온 객체 :"+ staff);
		AdminServiceImpl.getInstance().createStaff(staff);
		
		/*MemberBean member;
		member = new StaffBean();
		member.setName(JOptionPane.showInputDialog("이름"));
		member.setId(JOptionPane.showInputDialog("아이디"));
		member.setPw(JOptionPane.showInputDialog("비밀번호"));
		member.setSsn(JOptionPane.showInputDialog("주민번호"));
		member.setAdd(JOptionPane.showInputDialog("주소"));
		member.setPhone(JOptionPane.showInputDialog("연락처"));
		member.setEmail(JOptionPane.showInputDialog("이메일"));
		AdminServiceImpl.getInstance().createStaff((StaffBean) member);
*/	}
	
	public void listMember() {
		JOptionPane.showMessageDialog(null, AdminServiceImpl.getInstance().listMember());
	}
	
	public void searchMemberByName() {
		JOptionPane.showMessageDialog(null, AdminServiceImpl.getInstance().searchMemberByName(JOptionPane.showInputDialog("이름")));
	}
	
	public void listAccount() {
		JOptionPane.showMessageDialog(null, AdminServiceImpl.getInstance().listAccount());
	}
	
	public void SearchAccountByName() {
		JOptionPane.showMessageDialog(null, AdminServiceImpl.getInstance().searchAccountByName(JOptionPane.showInputDialog("이름")));
	}

}
