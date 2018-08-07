package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DataBaseFactory;

public class SearchJoinQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("SearchJoinQuery 진입");
		map.put("sql", String.format(MemberQuery.SELECT_JOIN_WORD.toString(),
										map.get("table"),
										map.get("condition")));
	}

	@Override
	void startPlay() {
		System.out.println("=================");
		System.out.println(map.get("sql"));
		System.out.println(map.get("value"));
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
		System.out.println("endPlay override");
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
				mem.setPassWord(rs.getString("PASS_WORD"));
				mem.setSsn(rs.getString("SSN"));
				list.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
