package com.gms.web.exam;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
//@RunWith(SpringJunit4ClassRunner.class)
public class DataSourceTest {
	@Inject
	private DataSource ds;
	
	@Test
	public void testConection()throws Exception {
		try(Connection con = ds.getConnection()) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
