package com.gms.web.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MariadbConn {
	public String exam() {
		Connection conn;
		Statement stmt;
		String result = "";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mariadb", "mariadb", "mariadb");
            stmt = conn.createStatement();
 
            String sql = " SELECT * "
            			+ "FROM MEMBER "
            			+ "WHERE USERID LIKE 'H5'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                result = rs.getString("NAME");
            }else {
            	result = "연결실패";
            }
            System.out.println("결과 : "+result);
         } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}
}
