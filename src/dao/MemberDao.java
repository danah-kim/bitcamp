package dao;

import java.util.List;

import domain.*;

public interface MemberDao {
	public void insertMember (MemberBean Member);
	public List<MemberBean> selectAllMember();
	public List<MemberBean> selectBySearchWord(MemberBean word);
	public MemberBean selectBySeq(MemberBean id);
	public int countMember();
	public void updateMember(MemberBean Member);
	public void deleteMember(MemberBean Member);
}
