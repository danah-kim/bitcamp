package template;

import java.sql.ResultSet;

import enums.MemberQuery;
import factory.DataBaseFactory;

public class LoginQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(MemberQuery.LOGIN.toString(),
										map.get("table")));
	}

	@Override
	void startPlay() {
		try {
			pstmt = DataBaseFactory.createDataBase2(map)
						.getConnection()
						.prepareStatement((String)map.get("sql"));
			pstmt.setString(1, (String) map.get("memId"));
			pstmt.setString(2, (String) map.get("passWord"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
