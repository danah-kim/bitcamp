package template;

import java.sql.ResultSet;

import enums.MemberQuery;
import factory.DataBaseFactory;

public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("initialize override");
		map.put("sql", String.format(MemberQuery.COUNT.toString(),
							map.get("table")));
	}

	@Override
	void startPlay() {
		System.out.println("=================");
		System.out.println(map.get("sql"));
		System.out.println("=================");
		try {
			pstmt = DataBaseFactory.createDataBase2(map)
					.getConnection()
					.prepareStatement((String)map.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		System.out.println("endPlay override");
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
