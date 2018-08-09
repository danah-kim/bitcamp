package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DataBaseFactory;

public class SearchQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("initialize override");
		System.out.println(map.get("******condition*****"));
		switch ((String) map.get("condition")) {
		case "" :
			
			map.put("sql", String.format(MemberQuery.LIST.toString(),
					map.get("table")));
			break;
		case "name" :
			/*case "teamName" :
			map.put("sql", String.format(MemberQuery.SELECT_JOIN_WORD.toString(),
					map.get("table"),
					map.get("condition")));
			break;*/
		case "gender" :
		case "roll" :
			map.put("sql", String.format(MemberQuery.SEARCH.toString(),
					map.get("table"),
					map.get("colum")));
			break;
		default:
			break;
		}
		
		
	}

	@Override
	void startPlay() {
		System.out.println("=================");
		System.out.println(map.get("sql"));
		System.out.println(map.get("startRow"));
		System.out.println(map.get("endRow"));
		System.out.println("=================");
		try {
			pstmt = DataBaseFactory.createDataBase2(map)
					.getConnection()
					.prepareStatement((String)map.get("sql"));
			pstmt.setString(1, map.get("value").toString());
			pstmt.setString(2, map.get("startRow").toString());
			pstmt.setString(3, map.get("endRow").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		System.out.println("endPlay override");
		try {
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member = new MemberBean();
				member.setMemId(rs.getString("MEM_ID"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setGender(rs.getString("GENDER"));
				member.setRoll(rs.getString("ROLL"));
				member.setPassWord(rs.getString("PASS_WORD"));
				member.setSsn(rs.getString("SSN"));
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
