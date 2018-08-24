package com.gms.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

public class DataSourceTest {
	@Inject
	private DataSource ds;
	
	public void testConection()throws Exception{
		try(Connection con = ds.getConnection()) {
			 System.out.print("DB확인!!!!"+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
