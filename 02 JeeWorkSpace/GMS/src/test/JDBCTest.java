package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
	public static void main(String[] args) {
		try {
			// 클래스파일이 없는 인스턴스로 동적인 클래스로 클래스를 생성하지 않아도 클래스처럼 하위 코딩을 사용하겠음. 
			// 드라이버는 이 객체 내에서만 사용 하면 되므로 정적일 필요가 없음
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// SQL연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "danah", "1234");
			// 쿼리문
			String sql = "SELECT COUNT(*) AS count FROM TAB";
			// Statements : DB에 명령문 전달, 수행, 결과를 받아오는 함수
			// factory Pattern
			Statement stmt = conn.createStatement();
			// executeQuery(String) : SELECT문을 전송할 때 사용하는 메소드, ResultSet 자료형의 데이터 반환 
			// ResultSet : SELECT에 의해서 처리된 데이터베이스의 값을 처리하는 객체
			// Sting타입을 SQL타입으로 변환하여 쿼리실행하여 얻은 검색 결과를 순서 없이 가져와 인스턴스에 담음
			ResultSet rs = stmt.executeQuery(sql);
			// 결과를 저장하기 위한 변수 생성
			String count = ""; 
			// next( ) : ResultSet에 저장된 select문 실행결과응 행단위로 1행씩 넘겨 다음행이 있으면 true(진행), 없으면 false(종료) 반환하는 함수 
			while(rs.next()) {
				// getString(String) : 해당 문자에 해당하는 열에 있는 데이터를 String 타입으로 가져오는 함수
				count = rs.getString("count");
			}
			System.out.println("테이블갯수"+count);
			
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery("SELECT * FROM TAB");
			List<String> list = new ArrayList<>();
			//
			int i = 0;
			while(rs2.next()) {
				list.add(rs2.getString("TNAME"));
				i++;
			}
			System.out.println("테이블갯수"+list);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
