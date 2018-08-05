package template;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.MemberBean;
import enums.DBConstant;
import enums.Vendor;
import lombok.Data;

@Data
public abstract class QueryTemplate {
	protected HashMap<String, Object>map;
	protected List<Object> list;
	protected MemberBean member;
	protected int num;
	protected boolean flag;
	protected PreparedStatement pstmt;
	protected Statement stmt;
	
	public final void play(HashMap<String, Object> map) {
		System.out.println("Query Template 진입");
		this.pstmt = null;
		this.stmt = null;
		this.list = new ArrayList<>();
		this.member = new MemberBean();
		this.num = 0;
		this.flag = false;
		this.map = map;
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME.toString());
		this.map.put("password", DBConstant.PASSWORD.toString());
		initialize();
		startPlay();
		endPlay();
	}
	
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
}
