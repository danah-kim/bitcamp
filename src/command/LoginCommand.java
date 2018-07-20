package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		MemberBean member = new MemberBean();
		member.setMemId(request.getParameter("user_id"));
		member.setPassWord(request.getParameter("user_pw"));
		if(MemberServiceImpl.getInstance().login(member)) {
			System.out.println("값이 있음");
			request.setAttribute("match", "TRUE");
			request.setAttribute("user", MemberServiceImpl.getInstance().findByID(member));
		}else {
			System.out.println("값이 없음");
			request.setAttribute("match", "FALSE");
		}
	}
}
