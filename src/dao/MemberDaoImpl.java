package dao;

import java.util.List;

import domain.MemberBean;

public class MemberDaoImpl implements MemberDao{
	private static MemberDao instance = new MemberDaoImpl ();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl () {}
	@Override
	public void insertMember(MemberBean Member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> selectAllMember() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MemberBean> selectBySearchWord(MemberBean word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean selectBySeq(MemberBean id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateMember(MemberBean Member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteMember(MemberBean Member) {
		// TODO Auto-generated method stub
		
	}
	
	
}
