package service;

import java.util.List;
import domain.MemberBean;

public interface MemberService {
	public void createUser(MemberBean user);
	public String login(MemberBean member);
	public void updatePassWord(MemberBean member);
	public void deleteMember(MemberBean member);
}
