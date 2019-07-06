package service;

import java.util.List;
import java.util.Map;

import domain.MemberBean;
import domain.StaffBean;
import domain.UserBean;

public interface MemberService {
	public void createUser(UserBean user);
	public void createStaff(StaffBean staff);
	public Map<String, MemberBean> list();
	public List<MemberBean> findByName(String name);
	public MemberBean findById(MemberBean member);
	public void updatePassWord(MemberBean member);
	public void deleteMember(MemberBean member);
}
