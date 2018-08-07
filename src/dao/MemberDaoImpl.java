package dao;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.DBConstant;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.DataBaseFactory;
import template.SearchQuery;
import template.UpdateQuery;
import template.CountQuery;
import template.DeleteQuery;
import template.InsertQuery;
import template.ListQuery;
import template.LoginQuery;
import template.PaginationQuery;
import template.QueryTemplate;
import template.RetriveQuery;
import template.SearchJoinQuery;

public class MemberDaoImpl implements MemberDao{
	private static MemberDao instance = new MemberDaoImpl ();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl () {		
	}
	@Override
	public void insertMember(MemberBean member) {
		QueryTemplate query = new InsertQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("memId", member.getMemId());
		map.put("passWord", member.getPassWord());
		map.put("name", member.getName());
		map.put("ssn", member.getSsn());
		map.put("age", member.getAge());
		map.put("teamId", member.getTeamId());
		map.put("roll", member.getRoll());
		map.put("gender", member.getGender());
		query.play(map);
		member = query.getMember();
	}
	@Override
	public List<MemberBean> selectAllMember() {
		List<MemberBean> list = new ArrayList<>();
		QueryTemplate query = new ListQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		query.play(map);
		
		for(Object e: query.getList()) {
			list.add((MemberBean)e);
		}
		
		return list;
	}
	@Override
	public List<MemberBean> selectList(Map<?, ?> param) {
		List<MemberBean> list = new ArrayList<>();
		QueryTemplate query= new PaginationQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("startRow", param.get("startRow"));
		map.put("endRow", param.get("endRow"));
		System.out.println("=====시작행========="+param.get("startRow"));
		System.out.println("=====종료행========="+param.get("endRow"));
		query.play(map);
		
		for(Object e: query.getList()) {
			list.add((MemberBean)e);
		}
		
		return list;
	}
	@Override
	public List<MemberBean> selectBySearchWord(String word) {
		QueryTemplate q = (word.split("/")[0].equals("teamName")) ? new SearchJoinQuery() : new SearchQuery();
		HashMap<String, Object> map = new HashMap<>();
		List<MemberBean> list = new ArrayList<>();
		map.put("column", word.split("/")[0]);
		map.put("value", word.split("/")[1]);
		map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
		}
		
		return list;
	}
	@Override
	public MemberBean selectById(MemberBean id) {
		QueryTemplate query = new RetriveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("value", id.getMemId());
		query.play(map);
		id = query.getMember();

		return id;
	}
	@Override
	public int countMember() {
		int count = 0;
		QueryTemplate query = new CountQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		query.play(map);
		count = query.getNum();
		
		return count;
	}
	@Override
	public void updateMember(MemberBean member) {
		QueryTemplate query = new UpdateQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("passWord", member.getPassWord());
		map.put("teamId", member.getTeamId());
		map.put("roll", member.getRoll());
		map.put("memId", member.getMemId());
		query.play(map);
	}
	@Override
	public void deleteMember(MemberBean member) {
		QueryTemplate query = new DeleteQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("memId", member.getMemId());
		map.put("passWord", member.getPassWord());
		query.play(map);
	}
	@Override
	public boolean login(MemberBean bean) {
		boolean flag = false;
		QueryTemplate query = new LoginQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("memId", bean.getMemId());
		map.put("passWord", bean.getPassWord());
		query.play(map);
		flag = query.isFlag();

		return flag;
	}
	@Override
	public boolean iDDualCheck(String id) {
		ResultSet rs = null;
		try {
			rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(
									MemberQuery.IDDUALCHECK.toString()
									,id));
		} catch (Exception e) {
		}
		return rs != null;
	}
}
