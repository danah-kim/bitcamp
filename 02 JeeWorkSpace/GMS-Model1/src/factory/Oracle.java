package factory;

import java.sql.*;

public class Oracle implements Database{
	private Connection con;
	private String driver, url, id, pass;
	public Oracle(String driver,
			String url,
			String id,
			String pass) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this. pass = pass;
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
