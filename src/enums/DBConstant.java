package enums;

/* 클래스로 상수 만들기
 	public class DRIVERConstant {
	public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String MYSQL_DRIVER = "";
	public static final String MARIADB_DRIVER = "";
	public static final String MSSQL_DRIVER = "";
	public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String MYSQL_URL = "";
	public static final String MARIADB_URL = "";
	public static final String MSSQL_URL = "";
	public static final String USERNAME = "danah";
	public static final String PASSWORD = "1234";
}*/

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
			db = "";
			break;
		case MARIADB_DRIVER :
			db = "";
			break;
		case MSSQL_DRIVER :
			db = "";
			break;
		case ORACLE_URL :
			db = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		case MYSQL_URL :
			db = "";
			break;
		case MARIADB_URL :
			db = "";
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
		}
		return db;
	}
}