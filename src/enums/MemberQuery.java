package enums;

import template.ColumnFinder;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER, COUNT_MEMBER, SELECT_ALL_MEMBER, SELECT_BY_ID, UPDATE_MEMBER, DELETE_MEMBER, IDDUALCHECK, SELECT_BY_WORD;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case LOGIN :
			query = "SELECT " + ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ "WHERE MEM_ID LIKE '%s' " 
					+ "AND PASS_WORD LIKE '%s' ";
			break;
		case INSERT_MEMBER :
			query = "INSERT INTO %s "
					+ "(MEM_ID, PASS_WORD, NAME, SSN, AGE, TEAM_ID, ROLL, gender) "
					+ "VALUES "
					+ "('%s','%s','%s','%s','%s','%s','%s','%s') ";
			break;
		case SELECT_ALL_MEMBER :
			query = "SELECT " + ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s";
			break;
		case SELECT_BY_WORD :
			query = "SELECT " + ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ "WHERE %s "
					// ?는 preparedstatement 사용한부분
					+ "LIKE ? ";
			break;
		
		case SELECT_BY_ID :
			query = "SELECT " + ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ "WHERE MEM_ID LIKE '%s'";
			break;
		case COUNT_MEMBER :
			query = "SELECT COUNT(*) AS COUNT "
					+ "FROM %s";
			break;
		case UPDATE_MEMBER :
			query = "UPDATE %s "
					+ "SET PASS_WORD = '%s', "
					+ "TEAM_ID = '%s', "
					+ "ROLL='%s' "
					+ "WHERE MEM_ID LIKE '%s' ";
			break;
		case DELETE_MEMBER :
			query = "DELETE %s "
					+ "WHERE MEM_ID LIKE '%s' "
					+ "AND PASS_WORD LIKE '%s'";
			break;
		case IDDUALCHECK :
			query = "SELECT MEM_ID "
					+ "FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'";
			break;
		
		default :
			break;
		}
		return query;	
	}
}
