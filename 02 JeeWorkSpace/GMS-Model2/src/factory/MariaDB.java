package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class MariaDB implements Database{
	private Connection con;
	private String driver, url, id, pass;
	public MariaDB(String driver,
			String url,
			String id,
			String pass) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pass = pass;
	}

	@Override
	public Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(
					url, 
					id, 
					pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
