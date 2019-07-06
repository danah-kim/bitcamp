package service;

import domain.MemberBean;
import domain.StaffBean;
import domain.UserBean;

public interface MemberService {
	public void creteUser(UserBean user);
	public void cresStaff(StaffBean staff);
	public MemberBean[]	list();
	public MemberBean[]	serch(String param);
	public MemberBean findById(MemberBean member);
	public void update(MemberBean bean);
	public void delete(MemberBean bean);
}
