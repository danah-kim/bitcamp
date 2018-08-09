package template;

import enums.MemberQuery;
import factory.DataBaseFactory;

public class DeleteQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("initialize override");
		map.put("sql", String.format(MemberQuery.DELETE.toString(),
							map.get("table"),
							map.get("memId"),
							map.get("passWord")
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
