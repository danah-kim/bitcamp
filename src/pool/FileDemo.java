package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final String PATH = "/Users/danah/Documents/sample.txt";		
		try {
			File file = new File(PATH);
			FileWriter fw = new FileWriter(file, true);
			FileReader fr = new FileReader(file);
			BufferedWriter writer = new BufferedWriter(fw);
			BufferedReader reader = new BufferedReader(fr);
			while (true) {
				System.out.println("[메뉴] 1. 전송 2. 읽기 0.종료");
				switch (s.next()) {
				case "1":
					System.out.println("메세지입력");
					writer.write(s.next());
					writer.newLine();
					writer.flush();
					break;
				case "2" :
					System.out.println("메세지보기");
					String msg = "";
					while ((msg = reader.readLine()) != null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				case "0" :
					return;
				default:
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileName fn = new FileName(PATH);
		System.out.println("파일명 : " + fn.getFileName());
		System.out.println("확장자 : " + fn.getExt());
	}
}
class FileName{ 
	// inner class는 public을 갖지 않음 
	// 이 클래스 내부에서만사용하고자 하기 때문 → 1회성 사용 클래스 
	// 다른 곳에서 계속 사용한다면 독립시켜야 함 
	private String path, sep, ext, fileName;
	public FileName(String path) {
		this.path = path;
		this.sep = File.separator;
		this.fileName = path.substring(path.lastIndexOf('/')+1, path.length());
		//this.fileName = path.substring(path.lastIndexOf('/')+1, path.indexOf("."));
		this.ext = path.substring(path.lastIndexOf('.')+1, path.length());// substring() 사용
		// lastIndexOf() 
		// substring() 사용
	}
	public String getPath() {
		return path;
	}
	public String getSep() {
		return sep;
	}
	public String getExt() {
		return ext;
	}
	public String getFileName() {
		return fileName;
	}
}

