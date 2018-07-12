package dao;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.Vendor;
import factory.DataBaseFactory;
import factory.Database;
import factory.Oracle;
import pool.DBConstant;;

public class MemberDaoImpl implements MemberDao{
	private static MemberDao instance = new MemberDaoImpl ();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl () {		
	}
	@Override
	public void insertMember(MemberBean member) {
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format("INSERT INTO MEMBER VALUES('"
					+ member.getMemId()
					+ "', '"
					+ member.getTeamId()
					+ "', '"
					+ member.getName()
					+ "', '"
					+ member.getAge()
					+ "', '"
					+ member.getRoll()
					+ "', '"
					+ member.getPassWord()
					+ "', '"
					+ member.getSsn()
					+ "')"));
			System.out.println(String.format("INSERT INTO MEMBER VALUES('"
					+ member.getMemId()
					+ "', '"
					+ member.getTeamId()
					+ "', '"
					+ member.getName()
					+ "', '"
					+ member.getAge()
					+ "', '"
					+ member.getRoll()
					+ "', '"
					+ member.getPassWord()
					+ "', '"
					+ member.getSsn()
					+ "')"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<MemberBean> selectAllMember() {
		List<MemberBean> list = null;
		try {
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format("SELECT * FROM MEMBER"));
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
			ResultSet rs = DataBaseFactory.createDataBase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(
							"SELECT * "
									 + "FROM MEMBER "
									 + "WHERE MEM_ID LIKE '"
									 + bean.getMemId()
									 + "' AND PASSWORD LIKE '"
									 + bean.getPassWord()
									 + "'"));
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
