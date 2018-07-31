package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER, COUNT_MEMBER, SELECT_ALL_MEMBER, SELECT_BY_ID, UPDATE_MEMBER, DELETE_MEMBER, IDDUALCHECK, SELECT_BY_WORD;
	@Override
	public String toString() {
		String query = "";
		// this는 객체를 의미 여기서는 상수를 의미
		switch(this) {
		case LOGIN :
			query = "SELECT * " 
					+ "FROM MEMBER " 
					+ "WHERE MEM_ID LIKE '%s' " 
					+ "AND PASSWORD LIKE '%s' ";
			break;
		case INSERT_MEMBER :
			query = "INSERT INTO MEMBER "
					+ "(MEM_ID, PASSWORD, NAME, SSN, AGE, TEAM_ID, ROLL) "
					+ "VALUES "
					+ "('%s','%s','%s','%s','%s','%s','%s') ";
			break;
		case SELECT_ALL_MEMBER :
			query = "SELECT * FROM MEMBER";
			break;
		case COUNT_MEMBER :
			query = "SELECT COUNT(*) AS COUNT "
					+ "FROM MEMBER";
			break;
		case SELECT_BY_ID :
			query = "SELECT * "
					+ "FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'";
			break;
		case UPDATE_MEMBER :
			query = "UPDATE MEMBER "
					+ "SET PASSWORD = '%s', "
					+ "TEAM_ID = '%s', "
					+ "ROLL='%s' "
					+ "WHERE MEM_ID LIKE '%s' ";
			break;
		case DELETE_MEMBER :
			query = "DELETE MEMBER "
					+ "WHERE MEM_ID LIKE '%s' "
					+ "AND PASSWORD LIKE '%s'";
			break;
		case IDDUALCHECK :
			query = "SELECT MEM_ID "
					+ "FROM MEMBER "
					+ "WHERE MEM_ID LIKE '%s'";
			break;
		case SELECT_BY_WORD :
			query = "SELECT * "
					+ "FROM MEMBER "
					+ "WHERE %s LIKE '%s'";
		default :
			break;
		}
		return query;	
	}
}
