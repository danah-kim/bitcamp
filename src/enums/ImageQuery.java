package enums;


public enum ImageQuery {
	INSERT,
	LIST, SEARCH, RETRIEVE, COUNT, 
	UPDATE,
	DELETE;
	
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case INSERT :
			query = " INSERT INTO %s "
					+ "(IMG_NAME, EXTENSION, MEM_ID) "
					+ "VALUES "
					+ "(?, ?, ?) ";
			break;
		case LIST : 
			query = " SELECT * "
					+ "FROM %s "
					+ "ORDER BY IMG_SEQ DESC"
					+ "LIMIT ?, ?";
					//+ "LIMIT (? - 1) * ?, ?";
			break;
		case SEARCH :
			query = " SELECT * "
					+ "FROM %s "
					+ "ORDER BY IMG_SEQ DESC "
					+ "WHERE MEM_ID LIKE ? "
					+ "LIMIT ?, ?";
					//+ "LIMIT (? - 1) * ?, ?"; // LIMIT 시작위치, 개수
			break;
		case RETRIEVE :
			query = " SELECT "
					+ "IMG_SEQ, IMG_NAME, EXTENSION, MEM_ID "
					+ " FROM %s "
					+ "WHERE MEM_ID LIKE ? "
					+ "ORDER BY IMG_SEQ DESC "
					+ "LIMIT 1";
			break;
		case COUNT :
			query = " SELECT COUNT(*) AS count "
					+ "FROM %s";
			break;
		case UPDATE :
			query = " UPDATE "
					+ "%s SET IMG_NAME = ?, "
					+ "EXTENSION = ?, "
					+ "WHERE MEM_ID LIKE ? ";
			break;
		case DELETE :
			query = " DELETE "
					+ "FROM %s "
					+ "WHERE MEM_ID LIKE ? ";
			break;
		default :
			break;
		}
		return query;	
	}
}
