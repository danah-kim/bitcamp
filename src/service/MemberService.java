package service;

import java.util.List;

import domain.MemberBean;

public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> memberList();
	public List<MemberBean> findByTeam(MemberBean member);
	public MemberBean findByID(MemberBean member);
	public int countMember();
	public void modifyMember(MemberBean member);
	public void removeMember(MemberBean member);
}
