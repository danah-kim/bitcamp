package enums;

import template.ColumnFinder;

public enum MemberQuery {
	INSERT,
	LIST, SEARCH, RETRIEVE, COUNT, 
	UPDATE,
	DELETE, 
	LOGIN, SEARCH_TEAM;
	
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case INSERT :
			query = " INSERT INTO %s ("
					+ ColumnFinder.find(Domain.MEMBER)
					+ ") VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			break;
		case LIST :
			query = " SELECT T.* "
					+ "FROM(SELECT @ROWNUM:=@ROWNUM+1 SEQ, M.* "
					+ "FROM %s M, (SELECT @ROWNUM:=0) TMP "
					+ "ORDER BY SEQ DESC)T "
					+ "WHERE T.SEQ BETWEEN ? AND ?";
			break;
		case SEARCH :
			query = " SELECT T.* "
					+ "FROM(SELECT @ROWNUM:=@ROWNUM+1 SEQ, M.* "
					+ "FROM %s M, (SELECT @ROWNUM:=0) TMP "
					+ "WHERE %s LIKE ? ORDER BY SEQ DESC)T "
					+ "WHERE T.SEQ BETWEEN ? AND ?";
			break;
		case RETRIEVE :
			query = " SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ "WHERE MEM_ID "
					+ "LIKE ?";
			break;
		case COUNT :
			query = " SELECT COUNT(*) AS count "
					+ "FROM %s";
			break;
		case UPDATE :
			query = " UPDATE "
					+ "%s SET PASS_WORD = ?, "
					+ "TEAM_ID = ?, "
					+ "ROLL = ? "
					+ "WHERE MEM_ID LIKE ? ";
			break;
		case DELETE :
			query = " DELETE "
					+ "FROM %s "
					+ "WHERE MEM_ID LIKE ? "
					+ "AND PASS_WORD LIKE ?";
			break;
		case LOGIN :
			query = " SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ "WHERE MEM_ID LIKE ? " 
					+ "AND PASS_WORD LIKE ? ";
			break;
		default :
			break;
		}
		return query;	
	}
}
