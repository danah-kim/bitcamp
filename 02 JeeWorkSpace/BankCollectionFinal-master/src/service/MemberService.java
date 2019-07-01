package service;

import domain.*;

public interface MemberService {
	public void createUser(UserBean user);
	public String login(MemberBean member);
	public String updateMemberPw(MemberBean member);
	public String deleteMember(MemberBean member);
}
