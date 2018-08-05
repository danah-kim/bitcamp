package template;

import enums.MemberQuery;
import factory.DataBaseFactory;

public class InsertQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("initialize override");
		map.put("sql", String.format(MemberQuery.INSERT_MEMBER.toString(),
							map.get("table"),
							map.get("memId"),
							map.get("passWord"),
							map.get("name"),
							map.get("ssn"),
							map.get("age"),
							map.get("teamId"),
							map.get("roll"),
							map.get("gender")
							));
	}

	@Override
	void startPlay() {
		System.out.println("=================");
		System.out.println(map.get("sql"));
		System.out.println("=================");
		try {
			stmt = DataBaseFactory.createDataBase2(map)
					.getConnection()
					.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		System.out.println("endPlay override");
		try {
			int rs = stmt.executeUpdate((String)map.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
