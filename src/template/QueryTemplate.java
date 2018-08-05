package template;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.DBConstant;
import enums.Vendor;
import lombok.Data;

@Data
public abstract class QueryTemplate {
	HashMap<String, Object>map;
	List<Object> list;
	PreparedStatement pstmt;
	public final void play(HashMap<String, Object> map) {
		System.out.println("Query Template 진입");
		this.pstmt = null;
		this.list = new ArrayList<>();
		this.map = map;
		this.map.put("vendor", Vendor.ORACLE);
		System.out.println(this.map.get("vendor"));
		this.map.put("username", DBConstant.USERNAME.toString());
		System.out.println(this.map.get("username"));
		this.map.put("password", DBConstant.PASSWORD.toString());
		System.out.println(this.map.get("password"));
		initialize();
		startPlay();
		endPlay();
	}
	
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
}
