package template;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import enums.DBConstant;
import enums.Vendor;
import factory.DataBaseFactory;
import lombok.Data;

@Data
public abstract class QueryTemplate {
	protected HashMap<String, Object> map;
	protected PreparedStatement pstmt;
	protected List<Object> list;
	protected Object o;
	protected int num;
	protected boolean flag;
	
	
	
	public final void play(HashMap<?, ?> param) {
		this.map = new HashMap<>();
		this.list = new ArrayList<>();
		this.o = null;
		this.num = 0;
		this.flag = false;
		this.map.put("vendor", Vendor.MARIADB);
		this.map.put("username", DBConstant.USERNAME.toString());
		this.map.put("password", DBConstant.PASSWORD.toString());
		Iterator<?> keys = param.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			this.map.put(key, param.get(key));
		}
		initialize();
		pstmtInit();
		startPlay();
		endPlay();
	}
	
	public void pstmtInit() {
		try {
			this.pstmt = DataBaseFactory.createDataBase2(map)
					.getConnection()
					.prepareStatement((String)map.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
}