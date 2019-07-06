package template;

import enums.ImageQuery;
import enums.MemberQuery;

public class DeleteQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "MEMBER" :
			map.put("sql", String.format(MemberQuery.DELETE.toString(),
					map.get("table")));
			break;
		case "IMAGE" :
			map.put("sql", String.format(ImageQuery.DELETE.toString(),
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
				break;
			case "IMAGE" :
				pstmt.setString(1, (String) map.get("memId"));
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
