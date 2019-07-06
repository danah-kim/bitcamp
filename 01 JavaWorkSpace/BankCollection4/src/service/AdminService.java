package service;

import java.util.List;

import domain.*;

public interface AdminService {
	public void createStaff(StaffBean staff);
	public List<MemberBean> memberList();
	public List<MemberBean> memberNameSearch(String name);
	public MemberBean memberIDSearch(MemberBean member);
	public List<AccountBean> accountList();
	public List<AccountBean> accountSearchByName(String name);
	public AccountBean accountSearchId(AccountBean id);
	public String createAccountNo();
	public String createDate();
}
