package command;

import javax.servlet.http.HttpServletRequest;

public class Receiver {
	// 값을 받을 때 마다 command 인스턴스 객체를 통해 값을 전달하고 그에 대한 결과를 받아 전달하기 때문에 static
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		System.out.println("Receiver 진입");
		System.out.println("도메인 : " + request.getServletPath()
												.substring(1, request.getServletPath()
												.indexOf(".")));
		System.out.println("액션: " + request.getParameter("action"));
		System.out.println("페이지: " + request.getParameter("page"));
		// 스크립틀릿에서 받은 값을 저장하지 말고 바로 전달하여 commander에서 실행할 클래스를 선택
		cmd = Commander.order(request);
	}
}
