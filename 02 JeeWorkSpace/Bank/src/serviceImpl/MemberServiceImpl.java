package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import service.*;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {};
	
	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		//list.add(user);
	}

	@Override
	public String login(MemberBean member) {
		String msg = "로그인 실패";

		/*for (int i = 0; i < list.size(); i++) {
				if (member.getId().equals(list.get(i).getId()) && member.getPw().equals(list.get(i).getPw())) {
				msg = "로그인 성공";
				break;
			}
		}*/
		return msg;
	}

	@Override
	public String updateMemberPw(MemberBean member) {
		String msg = "변경 실패";
		MemberBean temp = new MemberBean();
		String oldPw = member.getPw().split("/")[0];
		String newPw = member.getPw().split("/")[1];
		//temp = list.get(list.indexOf(searchMemberById(member)));

		/*for (int i = 0; i < list.size(); i++) {
			if (temp.getId() == null) {
				msg = "아이디가 존재하지 않습니다.";
			} else {
				if (oldPw.equals(temp.getPw()) && !oldPw.equals(newPw)) {
					temp.setPw(newPw);
					list.add(list.indexOf(temp), temp);
					msg = "변경 성공";
				}
			}
		}*/
		return msg;
	}
	
	@Override
	public String deleteMember(MemberBean member) {
		String msg = "삭제 실패";
		MemberBean temp = new MemberBean();
		String pw = member.getPw().split("/")[0];
		String confrimPw = member.getPw().split("/")[1];
		//temp = list.get(list.indexOf(searchMemberById(member)));

		if (temp.getUserId() == null) {
			msg = "아이디가 존재하지 않습니다.";
		} else {
			/*for (int i = 0; i < list.size(); i++) {
				if (pw.equals(list.get(i).getPw()) && pw.equals(confrimPw)) {
					list.remove(temp);
					msg = "삭제 완료";
					break;
				}
			}*/
		}
		return msg;
	}

}
