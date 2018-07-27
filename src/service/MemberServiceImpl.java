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
		MemberDaoImpl.getInstance().insertMember(member);
	}
	@Override
	public List<MemberBean> memberList() {
		return MemberDaoImpl.getInstance().selectAllMember();
	}
	@Override
	public List<MemberBean> findByWord(String word) {
		return MemberDaoImpl.getInstance().selectBySearchWord(word);
	}
	@Override
	public MemberBean findByID(MemberBean id) {
		return MemberDaoImpl.getInstance().selectById(id);
	}
	@Override
	public int countMember() {
		return MemberDaoImpl.getInstance().countMember();
	}
	@Override
	public void modifyMember(MemberBean member) {
		MemberDaoImpl.getInstance().updateMember(member);
	}
	@Override
	public void removeMember(MemberBean member) {
		MemberDaoImpl.getInstance().deleteMember(member);
	}
	@Override
	public boolean login(MemberBean member) {
		return MemberDaoImpl.getInstance().login(member);
	}

	@Override
	public boolean iDDualCheck(String id) {
		return MemberDaoImpl.getInstance().iDDualCheck(id);
	}
}
