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
		this.pstmt = null;
		this.list = new ArrayList<>();
		this.map = map;
		this.map.put("Vender", Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME);
		this.map.put("password", DBConstant.PASSWORD);
		initialize();
		startPlay();
		endPlay();
	}
	
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
}
