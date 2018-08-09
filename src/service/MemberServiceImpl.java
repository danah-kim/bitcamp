package service;


import java.util.List;
import java.util.Map;

import dao.MemberDaoImpl;
import domain.*;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	
	@Override
	public void add(MemberBean member) {
		MemberDaoImpl.getInstance().insert(member);
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDaoImpl.getInstance().selectSome(param);
	}
	@Override
	public MemberBean retrieve(String word) {
		return MemberDaoImpl.getInstance().selectOne(word);
	}
	@Override
	public int count() {
		return MemberDaoImpl.getInstance().count();
	}
	@Override
	public void modify(Map<?, ?> param) {
		MemberDaoImpl.getInstance().update(param);
	}
	@Override
	public void remove(MemberBean member) {
		MemberDaoImpl.getInstance().delete(member);
	}
	@Override
	public boolean login(MemberBean member) {
		return MemberDaoImpl.getInstance().login(member);
	}
	
}
