package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.Domain;
import factory.DataBaseFactory;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(
				" SELECT "
				+ ColumnFinder.find(Domain.MEMBER)
				+ " FROM %s"
				+ " WHERE %s "
				// ?는 preparedstatement 사용한부분
				+ " LIKE ? ",
				map.get("table"),
				map.get("column")));
	}

	@Override
	void startPlay() {
		System.out.println("=================");
		System.out.println(map.get("sql"));
		System.out.println(map.get("value"));
		String aa = "%" + map.get("value").toString()+"%";
		System.out.println("=================");
		try {
			pstmt = DataBaseFactory.createDataBase2(map)
					.getConnection()
					.prepareStatement((String)map.get("sql"));
			pstmt.setString(1, "%" + map.get("value").toString()+"%");
		} catch (Exception e) {
			e.printStackTrace();
		}
				

	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
			while (rs.next()) {
				mem = new MemberBean();
				mem.setMemId(rs.getString("MEM_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setGender(rs.getString("GENDER"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassWord(rs.getString("PASSWORE"));
				mem.setSsn(rs.getString("SSN"));
				list.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
