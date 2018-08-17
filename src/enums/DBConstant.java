package enums;

public enum DBConstant{
	ORACLE_DRIVER, MYSQL_DRIVER, MARIADB_DRIVER, MSSQL_DRIVER, ORACLE_URL, MYSQL_URL, MARIADB_URL, MSSQL_URL, USERNAME, PASSWORD;
	@Override
	public String toString() {
		String db = "";
		switch(this) {
		case ORACLE_DRIVER :
			db = "oracle.jdbc.driver.OracleDriver";
			break;
		case MYSQL_DRIVER :
			db = "com.mysql.jdbc.Driver";
			break;
		case MARIADB_DRIVER :
			db = "org.mariadb.jdbc.Driver";
			break;
		case MSSQL_DRIVER :
			db = "";
			break;
		case ORACLE_URL :
			db = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		case MYSQL_URL :
			db = "jdbc:mysql://localhost:3306/DBNAME";
			break;
		case MARIADB_URL :
			db = "jdbc:mariadb://localhost:3306/xe";
			break;
		case MSSQL_URL :
			db = "";
			break;
		case USERNAME :
			db = "danah";
			break;
		case PASSWORD :
			db = "1234";
			break;
		default :
			break;
		}
		return db;
	}
}