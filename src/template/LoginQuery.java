package template;

import java.sql.ResultSet;

import enums.MemberQuery;
import factory.DataBaseFactory;

public class LoginQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("initialize override");
		map.put("sql", String.format(MemberQuery.LOGIN.toString(),
							map.get("table"),
							map.get("memId"),
							map.get("passWord")));
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
			ResultSet rs = stmt.executeQuery((String)map.get("sql"));
			
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
