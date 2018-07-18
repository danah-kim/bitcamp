package dao;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.DBConstant;
import enums.MemberQuery;
import enums.Vendor;
import factory.DataBaseFactory;

public class MemberDaoImpl implements MemberDao{
	private static MemberDao instance = new MemberDaoImpl ();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl () {		
	}
	@Override
	public void insertMember(MemberBean member) {
		member.setAge(String.valueOf(2018 - Integer.parseInt("19"+member.getSsn().split("-")[0].substring(0, 2)) + 1));
		try {
			int rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(MemberQuery.INSERT_MEMBER.toString(),
							member.getMemId(), member.getPassWord(), member.getName(), member.getSsn(),member.getAge(), member.getTeamId(), member.getRoll()));
			/*ResultSet rs = DataBaseFactory
					.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.INSERT_MEMBER.toString(),
							member.getMemId(), member.getPassWord(), member.getName(), member.getSsn(),member.getAge()));*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<MemberBean> selectAllMember() {
		List<MemberBean> list = new ArrayList<>();
		MemberBean member = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SELECT_ALL_MEMBER.toString()));
			while(rs.next()) {
				member = new MemberBean();
				member.setMemId(rs.getString("MEM_ID"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setPassWord(rs.getString("PASSWORD"));
				member.setSsn(rs.getString("SSN"));
				list.add(member);
			}
			/*if(countMember()==list.size()) {
				System.out.println("전체리스트인원 호출성공\n");
			}else{
				System.out.println("전체리스트인원 호출 실패\n");
			}*/
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<MemberBean> selectBySearchWord(String word) {
		String condition = word.split("/")[0];
		String teamId = word.split("/")[1];
		List<MemberBean> list = new ArrayList<>();
		MemberBean member = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SELECT_BY_WORD.toString(),condition,teamId));
			while(rs.next()) {
				member = new MemberBean();
				member.setMemId(rs.getString("MEM_ID"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setPassWord(rs.getString("PASSWORD"));
				member.setSsn(rs.getString("SSN"));
				list.add(member);
			}
		} catch (Exception e) {
		}
		return list;
	}
	@Override
	public MemberBean selectById(MemberBean id) {
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SELECT_BY_ID.toString(),id.getMemId()));
			if(rs.next()) {
				do {
					id.setTeamId(rs.getString("TEAM_ID"));
					id.setName(rs.getString("NAME"));
					id.setAge(rs.getString("AGE"));
					id.setRoll(rs.getString("ROLL"));
					id.setPassWord(rs.getString("PASSWORD"));
					id.setSsn(rs.getString("SSN"));
					} while(rs.next());
			}else {
				id = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public int countMember() {
		int count = 0;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.COUNT_MEMBER.toString()));
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return count;
	}
	@Override
	public void updateMember(MemberBean member) {
		String oldPass = member.getPassWord().split("/")[0];
		String newPass = member.getPassWord().split("/")[1];
		member = selectById(member);
		if(oldPass.equals(member.getPassWord())) {
			member.setPassWord(newPass);
			try {
				int rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
						.getConnection()
						.createStatement()
						.executeUpdate(String.format(MemberQuery.UPDATE_MEMBER.toString(),
								member.getPassWord(),
								member.getMemId()));
			} catch (Exception e) {
			}
		}
		else {
			member = null;
		}
	}
	@Override
	public void deleteMember(MemberBean member) {
		try {
			int rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(MemberQuery.DELETE_MEMBER.toString(),
							member.getMemId()));
			System.out.println(rs);
		} catch (Exception e) {
		}
		
	}
	@Override
	public MemberBean login(MemberBean bean) {
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(
									MemberQuery.LOGIN.toString(),
									bean.getMemId(),
									bean.getPassWord()));
			if(rs.next()) {
				do{
					bean.setTeamId(rs.getString("TEAM_ID"));
					bean.setName(rs.getString("NAME"));
					bean.setAge(rs.getString("AGE"));
					bean.setRoll(rs.getString("ROLL"));
					bean.setSsn(rs.getString("SSN"));
				}while(rs.next());} 
			else {
					bean = null;
			}
		}catch (Exception e) {
				e.printStackTrace();
		}		
		return bean;
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
