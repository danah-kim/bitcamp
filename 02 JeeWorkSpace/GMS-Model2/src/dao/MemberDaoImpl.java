package dao;

import java.util.*;
import domain.*;
import enums.Domain;
import template.*;

public class MemberDaoImpl implements MemberDao{
	private static MemberDao instance = new MemberDaoImpl ();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl () {}
	private QueryTemplate query = null;
	
	@Override
	public void insert(MemberBean member) {
		query = new InsertQuery();
		HashMap<String, Object> map = new HashMap<>();
		String[] arr1 = {"table", "memId", "passWord", "name", "ssn",
							"age", "teamId", "roll", "gender"//, "subject"
						};
		String[] arr2 = {Domain.MEMBER.toString(), (String) member.getMemId(), 
							(String) member.getPassWord(), (String) member.getName(),
							(String) member.getSsn(), (String) member.getAge(),
							(String) member.getTeamId(), (String) member.getRoll(),
							(String) member.getGender()//, member.getSubject().getSubName()
							};
		for(int i = 0; i < arr1.length; i++){
			map.put(arr1[i],arr2[i]);
		}
		query.play(map);
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		HashMap<String, Object> map = new HashMap<>();
		List<MemberBean> list = new ArrayList<>();
		String[] arr1 = {"table", "column", "value", "startRow", "endRow"};
		String[] arr2 = {Domain.MEMBER.toString(), (String) param.get("column"),
							(String) param.get("value"), String.valueOf(param.get("startRow")),
							String.valueOf(param.get("endRow"))
						};
		for(int i = 0; i < arr1.length; i++){
			map.put(arr1[i],arr2[i]);
		}
		query= new SearchQuery();
		query.play(map);
		for(Object e: query.getList()) {
			list.add((MemberBean)e);
		}
		return list;
	}
	@Override
	public MemberBean selectOne(String word) {
		MemberBean member = new MemberBean();
		query = new RetrieveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("value", word);
		query.play(map);
		member = (MemberBean) query.getO();
		return member;
	}
	@Override
	public int count() {
		int count = 0;
		query = new CountQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		query.play(map);
		count = query.getNum();
		
		return count;
	}
	@Override
	public void update(Map<?, ?> param) {
		query = new UpdateQuery();
		HashMap<String, Object> map = new HashMap<>();
		String[] arr1 = {"table", "memId", "passWord", "teamId", "roll"};
		String[] arr2 = {Domain.MEMBER.toString(),
							(String) param.get("memId"),
							(String) param.get("passWord"),
							(String) param.get("teamId"),
							(String) param.get("roll")};
		for(int i = 0; i < arr1.length; i++){
			map.put(arr1[i],arr2[i]);
		}
		query.play(map);
	}
	@Override
	public void delete(MemberBean member) {
		query = new DeleteQuery();
		HashMap<String, Object> map = new HashMap<>();
		String[] arr1 = {"table", "memId", "passWord"};
		String[] arr2 = {Domain.MEMBER.toString(), member.getMemId(),
							member.getPassWord()};
		for(int i = 0; i < arr1.length; i++){
			map.put(arr1[i],arr2[i]);
		}
		query.play(map);
	}
	@Override
	public boolean login(MemberBean member) {
		boolean flag = false;
		query = new LoginQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("memId", member.getMemId());
		map.put("passWord", member.getPassWord());
		query.play(map);
		flag = query.isFlag();

		return flag;
	}

}
