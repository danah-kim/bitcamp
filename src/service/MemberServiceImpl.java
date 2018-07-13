package service;

import java.util.List;
import dao.MemberDaoImpl;
import domain.*;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	@Override
	public void createMember(MemberBean member) {
		findByID(member);
		member.setAge(createAge(member));
		MemberDaoImpl.getInstance().insertMember(member);
	}
	@Override
	public List<MemberBean> memberList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MemberBean> findByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean findByID(MemberBean id) {
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
	@Override
	public MemberBean login(MemberBean member) {
		return MemberDaoImpl.getInstance().login(member);
	}
	@Override
	public String createAge(MemberBean member) {
		String year = "19"+member.getSsn().split("-")[0].substring(0, 2);
		int result = 2018 - Integer.parseInt(year) + 1 ;
		return String.valueOf(result);
	}

}
