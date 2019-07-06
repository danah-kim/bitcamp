package template;

import java.sql.ResultSet;

import enums.MemberQuery;

public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(MemberQuery.COUNT.toString(),
							map.get("table")));
	}

	@Override
	void startPlay() {
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
					num = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
