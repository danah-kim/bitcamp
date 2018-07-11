package dao;

import java.sql.*;
import java.util.List;

import domain.MemberBean;

public class MemberDaoImpl implements MemberDao{
	private static MemberDao instance = new MemberDaoImpl ();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl () {}
	@Override
	public void insertMember(MemberBean Member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> selectAllMember() {
		// TODO Auto-generated method stub
		return null;
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
	public void updateMember(MemberBean Member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteMember(MemberBean Member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberBean login(MemberBean bean) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "danah", "1234");
			Statement stmt = con.createStatement();
			String sql = "SELECT * "
						 + "FROM MEMBER "
						 + "WHERE MEM_ID LIKE '"
						 + bean.getMemId()
						 + "' AND PASSWORD LIKE '"
						 + bean.getPassWord()
						 + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
			do{
				bean.setTeamId(rs.getString("TEAM_ID"));
				bean.setName(rs.getString("NAME"));
				bean.setAge(rs.getString("AGE"));
				bean.setRoll(rs.getString("ROLL"));
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
