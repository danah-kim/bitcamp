package template;

import enums.ImageQuery;
import enums.MemberQuery;

public class InsertQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
			case "MEMBER" :
				map.put("sql", String.format(MemberQuery.INSERT.toString(),
						map.get("table")));
				break;
			case "IMAGE" :
				map.put("sql", String.format(ImageQuery.INSERT.toString(),
						 map.get("table")));
				break;
			default:
				break;
		}
	}

	@Override
	void startPlay() {
		try {
			switch (map.get("table").toString()) {
				case "MEMBER" :
					pstmt.setString(1, (String) map.get("memId"));
					pstmt.setString(2, (String) map.get("passWord"));
					pstmt.setString(3, (String) map.get("name"));
					pstmt.setString(4, (String) map.get("ssn"));
					pstmt.setString(5, (String) map.get("age"));
					pstmt.setString(6, (String) map.get("teamId"));
					pstmt.setString(7, (String) map.get("roll"));
					pstmt.setString(8, (String) map.get("gender"));
					pstmt.setString(9, (String) map.get("subject"));
					break;
				case "IMAGE" :
					pstmt.setString(1, (String) map.get("imgname"));
					pstmt.setString(2, (String) map.get("extension"));
					pstmt.setString(3, (String) map.get("memId"));
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
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
