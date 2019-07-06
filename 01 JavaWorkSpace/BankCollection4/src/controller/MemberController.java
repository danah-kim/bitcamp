package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

public class MemberController {
	private static MemberController instance = new MemberController();	
	public static MemberController getInstance() {return instance;}
	private MemberController() {}

	public void join(UserBean member) {
		System.out.println("========== 멤버 컨트롤러 ==========");
		System.out.println("화면에서 넘어온 객체 : " + member);
		MemberServiceImpl.getInstance().createUser(member);
	}

	public void update() {
		MemberBean member = null; // encapsulation
		member = new StaffBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("기존 비밀번호") + "/" + JOptionPane.showInputDialog("새비밀번호"));
		MemberServiceImpl.getInstance().createUser(member);
	}
	
	public void withdrawal() {
		MemberBean member = null;
		member = new StaffBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setUid(JOptionPane.showInputDialog("기존 비밀번호"));
		MemberServiceImpl.getInstance().createUser(member);
	}

}
