package template;

import enums.ImageQuery;
import enums.MemberQuery;

public class UpdateQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "MEMBER" :
			map.put("sql", String.format(MemberQuery.UPDATE.toString(),
					map.get("table")));
			break;
		case "IMAGE" :
			map.put("sql", String.format(ImageQuery.UPDATE.toString(),
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
				pstmt.setString(1, (String) map.get("passWord"));
				pstmt.setString(2, (String) map.get("teamId"));
				pstmt.setString(3, (String) map.get("roll"));
				pstmt.setString(4, (String) map.get("memId"));
				break;
			case "IMAGE" :
				pstmt.setString(1, (String) map.get("imgName"));
				pstmt.setString(2, (String) map.get("imgExtension"));
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
