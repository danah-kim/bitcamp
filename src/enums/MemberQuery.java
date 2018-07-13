package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER, SELECTALLMEMBER;
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
					+ "(MEM_ID, PASSWORD, NAME, SSN, AGE) "
					+ "VALUES "
					+ "('%s','%s','%s','%s','%s') ";
			break;
		case SELECTALLMEMBER :
			query = "SELECT * FROM MEMBER";
		default :
			break;
		}
		return query;	
	}
}
