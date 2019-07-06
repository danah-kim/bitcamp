package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

public class MemberController {

	public void join() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; // encapsulation
		member = new UserBean();
		member.setName(JOptionPane.showInputDialog("이름"));
		member.setSsn(JOptionPane.showInputDialog("주민 번호"));
		member.setPhone(JOptionPane.showInputDialog("연락처"));
		member.setEmail(JOptionPane.showInputDialog("이메일"));
		member.setAddr(JOptionPane.showInputDialog("주소"));
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("비밀번호"));
		service.createUser((UserBean) member);
	}

	public void add() {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null; // encapsulation
		member = new StaffBean();
		member.setName(JOptionPane.showInputDialog("이름"));
		member.setSsn(JOptionPane.showInputDialog("주민 번호"));
		member.setPhone(JOptionPane.showInputDialog("연락처"));
		member.setEmail(JOptionPane.showInputDialog("이메일"));
		member.setAddr(JOptionPane.showInputDialog("주소"));
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("비밀번호"));
		service.createStaff((StaffBean) member);
	}

	public void list() {
		MemberService service = new MemberServiceImpl();
		JOptionPane.showMessageDialog(null, service.list());
	}

	public void find_By_Id() {
	}

	public void fIND_BY_NAME() {
	}

	public void count() {
	}

	public void update() {
		MemberService service = new MemberServiceImpl(); // 추상화
		MemberBean member = null; // encapsulation
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("기존 비밀번호") + "/" + JOptionPane.showInputDialog("새비밀번호"));
	}

	public void WITHDRAWAL() {
		MemberService service = new MemberServiceImpl(); // 추상화
		MemberBean member = null; // encapsulation
	}
}
