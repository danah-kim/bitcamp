package factory;

import java.util.Map;

import enums.DBConstant;
import enums.Vendor;

public class DataBaseFactory {
	public static Database createDataBase(Vendor v, String id, String pass) {
		Database database = null;
		switch(v) {
			case ORACLE :
				database = new Oracle(DBConstant.ORACLE_DRIVER.toString(), DBConstant.ORACLE_URL.toString(), id, pass);
				break;
			case MYSQL :
				database = new MySQL(DBConstant.MYSQL_DRIVER.toString(), DBConstant.MYSQL_URL.toString(), id, pass);
				break;
			case MARIADB :
				database = new MariaDB(DBConstant.MARIADB_DRIVER.toString(), DBConstant.MARIADB_URL.toString(), id, pass);
				break;
			case MSSQL :
				database = new MySQL(DBConstant.MSSQL_DRIVER.toString(), DBConstant.MSSQL_URL.toString(), id, pass);
				break;
			default :
				break;
		}
		return database;
	}
	public static Database createDataBase2(Map<String, Object> map) {
		Database database = null;
		switch((Vendor)map.get("vendor")) {
			case ORACLE :
				database = new Oracle(DBConstant.ORACLE_DRIVER.toString(), DBConstant.ORACLE_URL.toString(),
						(String)map.get("username"),
						(String)map.get("password")
				);
				break;
			case MYSQL :
				database = new MySQL(DBConstant.MYSQL_DRIVER.toString(), DBConstant.MYSQL_URL.toString(),
						(String)map.get("username"),
						(String)map.get("password")
				);
				break;
			case MARIADB :
				database = new MariaDB(DBConstant.MARIADB_DRIVER.toString(), DBConstant.MARIADB_URL.toString(),
						(String)map.get("username"),
						(String)map.get("password")
				);
				break;
			case MSSQL :
				database = new MySQL(DBConstant.MSSQL_DRIVER.toString(), DBConstant.MSSQL_URL.toString(),
						(String)map.get("username"),
						(String)map.get("password")
				);
				break;
			default :
				break;
		}
		return database;
	}
}
