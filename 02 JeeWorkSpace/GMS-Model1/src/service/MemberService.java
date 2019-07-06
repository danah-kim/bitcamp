package service;

import java.util.List;

import domain.MemberBean;

public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> memberList();
	public List<MemberBean> findByWord(String word);
	public MemberBean findByID(MemberBean id);
	public int countMember();
	public void modifyMember(MemberBean member);
	public void removeMember(MemberBean member);
	public MemberBean login(MemberBean member);
	public String createAge(MemberBean member);
	public boolean iDDualCheck(String id);
}
