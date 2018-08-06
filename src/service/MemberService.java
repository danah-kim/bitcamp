package service;

import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> memberList();
	public List<MemberBean> getList(Map<?, ?> param);
	public List<MemberBean> findByWord(String word);
	public MemberBean findByID(MemberBean id);
	public int countMember();
	public void modifyMember(MemberBean member);
	public void removeMember(MemberBean member);
	public boolean login(MemberBean member);
	public boolean iDDualCheck(String id);
}
