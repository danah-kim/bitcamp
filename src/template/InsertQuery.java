package template;

import enums.MemberQuery;
import factory.DataBaseFactory;

public class InsertQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("initialize override");
		map.put("sql", String.format(MemberQuery.INSERT.toString(),
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
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2, member.getPassWord());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getSsn());
			pstmt.setString(5, member.getAge());
			pstmt.setString(6, member.getTeamId());
			pstmt.setString(7, member.getRoll());
			pstmt.setString(8, member.getGender());
			pstmt.setString(9, member.getSubject());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		System.out.println("endPlay override");
		try {
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
