package command;

import javax.servlet.http.HttpServletRequest;

public class Sentry {
	// 하나의 메소드만 처리하도록 static
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		System.out.println("센트리 : "
				+ servletPath.substring(1, servletPath.indexOf(".")));
		
		cmd = Commander.order(
				// servletPath = @webServlet("/member.do")안에 있는 /member.do
				// servletPath.substring(0, servletPath.indexOf(".")) = /
				// servletPath.substring(1, servletPath.indexOf(".")) = member
				// member를 command로
				servletPath.substring(1, servletPath.indexOf(".")),
				// action의 값을 command로 보냄
				request.getParameter("action"),
				// page의 값 command로 보냄
				request.getParameter("page"));
	}
}
