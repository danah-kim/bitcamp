package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.ImageQuery;
import enums.MemberQuery;

public class SearchQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
			case "MEMBER" :
				map.put("sql", (map.get("column").equals("")) ?
						String.format(MemberQuery.LIST.toString(), 
						map.get("table"))
						: String.format(MemberQuery.SEARCH.toString(), 
						map.get("table"), map.get("column")));
				break;
			case "IMAGE" :
				map.put("sql", String.format((map.get("column").equals("")) ?
									ImageQuery.LIST.toString()
									: ImageQuery.SEARCH.toString(),
									map.get("table")));
				break;
			default:
				break;
		}
	}

	@Override
	void startPlay() {
		try {
			int j = 0;
			switch (map.get("table").toString()) {
			case "MEMBER" :
				if(map.get("column").equals("")){
					j++;
					pstmt.setString(j, map.get("startRow").toString());
					j++;
					pstmt.setString(j, map.get("endRow").toString());
				}else {
					j++;
					pstmt.setString(j, (map.get("column").toString().equals("NAME")) ?
											"%" + map.get("value").toString() + "%"
											: map.get("value").toString());
					j++;
					pstmt.setString(j, map.get("startRow").toString());
					j++;
					pstmt.setString(j, map.get("endRow").toString());
				}
				break;
			case "IMAGE" :
				if(map.get("column").equals("")){
					j++;
					pstmt.setString(j, map.get("startRow").toString());
					j++;
					pstmt.setString(j, map.get("endRow").toString());
				}else {
					j++;
					pstmt.setString(j, map.get("value").toString());
					j++;
					pstmt.setString(j, map.get("startRow").toString());
					j++;
					pstmt.setString(j, map.get("endRow").toString());
				}
				break;
			default:
				break;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean member = null;
			while (rs.next()) {
				member = new MemberBean();
				member.setMemId(rs.getString("MEM_ID"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setPassWord(rs.getString("PASS_WORD"));
				member.setSsn(rs.getString("SSN"));
				member.setGender(rs.getString("GENDER"));
				//member.setSubject(rs.getString("SUBJECT"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
