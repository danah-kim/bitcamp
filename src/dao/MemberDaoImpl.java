package dao;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.DBConstant;
import enums.MemberQuery;
import enums.Vendor;
import factory.DataBaseFactory;
import factory.Database;
import factory.Oracle;;

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
							member.getMemId(), member.getPassWord(), member.getName(), member.getSsn(),member.getAge()));
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
		List<MemberBean> list = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SELECTALLMEMBER.toString()));
			int i = 0;
			while(rs.next()) {
				list.get(i);
				i++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<MemberBean> selectBySearchWord(MemberBean word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean selectById(MemberBean id) {
		try {
			ResultSet re = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME.toString(), DBConstant.PASSWORD.toString())
					.getConnection()
					.createStatement()
					.executeQuery("sql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteMember(MemberBean member) {
		// TODO Auto-generated method stub
		
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
			}
			while(rs.next());} else {
				bean = null;
			}
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}		
		return bean;
	}
}
