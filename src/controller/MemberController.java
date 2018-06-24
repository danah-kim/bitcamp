package controller;

import javax.swing.JOptionPane;

import domain.*;
import serviceImpl.*;

public class MemberController {
	public static MemberController instance = new MemberController();
	public static MemberController getInstance() {return instance;}
	private MemberController() {}

	public void createUser(UserBean user) {
		System.out.println("==========멤버 컨트롤러==========");
		System.out.println("화면에서 넘어온 객체 :"+ user);
		MemberServiceImpl.getInstance().createUser(user);
		
		/*MemberBean member = new UserBean();
		member.setName(JOptionPane.showInputDialog("이름"));
		member.setId(JOptionPane.showInputDialog("아이디"));
		member.setPw(JOptionPane.showInputDialog("비밀번호"));
		member.setSsn(JOptionPane.showInputDialog("주민번호"));
		member.setAdd(JOptionPane.showInputDialog("주소"));
		member.setPhone(JOptionPane.showInputDialog("연락처"));
		member.setEmail(JOptionPane.showInputDialog("이메일"));
		MemberServiceImpl.getInstance().createUser((UserBean) member);*/
	}
	
	public String login() {
		String msg = "로그인 실패";

		/*for (MemberBean e : list) {
				if (member.getId().equals(e.getId()).getId()) && member.getPw().equals(e.getId().getPw())) {
				msg = "로그인 성공";
				break;
			}
		}*/
		return msg;
	}

	public void updateMemberPw() {

		MemberBean member;
		member = new MemberBean();
		member.setId(JOptionPane.showInputDialog("아이디"));
		member.setId(JOptionPane.showInputDialog("기존 비밀번호") + "/" + (JOptionPane.showInputDialog("새 비밀번호")));
		JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().updateMemberPw(member));
	}

	public void deleateMember() {
		MemberBean member = new MemberBean();
		member.setId(JOptionPane.showInputDialog("아이디"));
		member.setId(JOptionPane.showInputDialog("Pass?"));
		member.setPw(JOptionPane.showInputDialog("비밀번호") + "/" + JOptionPane.showInputDialog("비밀번호 재확인"));
		JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().deleteMember(member));
	}
	
}
