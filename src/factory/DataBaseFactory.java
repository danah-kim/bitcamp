package factory;

import enums.Vendor;
import pool.DBConstant;

public class DataBaseFactory {
	public static Database createDataBase(Vendor v, String id, String pass) {
		Database database = null;
		switch(v) {
			case ORACLE :
				database = new Oracle(DBConstant.ORACLE_DRIVER, DBConstant.ORACLE_URL, id, pass);
				break;
			case MYSQL :
				database = new Oracle(DBConstant.MYSQL_DRIVER, DBConstant.MYSQL_URL, id, pass);
				break;
			case MARIADB :
				database = new Oracle(DBConstant.MARIADB_DRIVER, DBConstant.MARIADB_URL, id, pass);
				break;
			case MSSQL :
				database = new Oracle(DBConstant.MSSQL_DRIVER, DBConstant.MSSQL_URL, id, pass);
				break;
			default :
				break;
		}
		return database;
	}
}
