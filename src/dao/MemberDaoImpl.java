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
		try {
			int rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(MemberQuery.INSERT_MEMBER.toString(),
							member.getMemId(), member.getPassWord(), member.getName(), member.getSsn(),member.getAge(), member.getTeamId(), member.getRoll(), member.getGender()));
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
				member.setGender(rs.getString("GENDER"));
				member.setSubject(rs.getString("SUBJECT"));
				list.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<MemberBean> selectBySearchWord(String word) {
		String[] arr = word.split("/");
		List<MemberBean> list = new ArrayList<>();
		MemberBean member = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SELECT_BY_WORD.toString(),arr[0],arr[1]));
			while(rs.next()) {
				member = new MemberBean();
				member.setMemId(rs.getString("MEM_ID"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setGender(rs.getString("GENDER"));
				member.setSubject(rs.getString("SUBJECT"));
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
					id.setGender(rs.getString("GENDER"));
					id.setSubject(rs.getString("SUBJECT"));
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
		try {
			int rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(MemberQuery.UPDATE_MEMBER.toString(),
							member.getPassWord(),
							member.getTeamId(),
							member.getRoll(),
							member.getMemId()));
		} catch (Exception e) {
			
		}
	}
	@Override
	public void deleteMember(MemberBean member) {
		member = selectById(member);
		if(member.getPassWord().equals(member.getPassWord())){
			try {
				int rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
						.getConnection()
						.createStatement()
						.executeUpdate(String.format(MemberQuery.DELETE_MEMBER.toString(),
								member.getMemId(),
								member.getPassWord()));
				System.out.println(rs);
			} catch (Exception e) {
			}
		} else {
			
		}
	}
	@Override
	public boolean login(MemberBean bean) {
		boolean flag = false;
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
				flag = true;
			}
		}catch (Exception e) {
				e.printStackTrace();
		}		
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
