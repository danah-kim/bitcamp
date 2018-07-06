package service;

import java.util.List;
import domain.*;

public class MemberServiceImpl implements MemberService{
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {return instance;}
	private MemberServiceImpl() {}
	@Override
	public void createMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> memberList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MemberBean> findByTeam(MemberBean member) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean findByID(MemberBean member) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	

}
