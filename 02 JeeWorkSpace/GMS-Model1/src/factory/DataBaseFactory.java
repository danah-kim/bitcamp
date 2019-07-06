package factory;

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
				database = new Oracle(DBConstant.MYSQL_DRIVER.toString(), DBConstant.MYSQL_URL.toString(), id, pass);
				break;
			case MARIADB :
				database = new Oracle(DBConstant.MARIADB_DRIVER.toString(), DBConstant.MARIADB_URL.toString(), id, pass);
				break;
			case MSSQL :
				database = new Oracle(DBConstant.MSSQL_DRIVER.toString(), DBConstant.MSSQL_URL.toString(), id, pass);
				break;
			default :
				break;
		}
		return database;
	}
}
