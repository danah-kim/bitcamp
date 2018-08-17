package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RemoveCommand extends Command {	
	public RemoveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
			case MEMBER :
				MemberBean member = new MemberBean();
				member.setMemId(((MemberBean)request.getSession().getAttribute("user")).getMemId());
				member.setPassWord(request.getParameter("pw1"));
				MemberServiceImpl.getInstance().remove(member);
				request.getSession().invalidate();
				break;
			case ADMIN :
				break;
			default:
				break;
		}
		super.execute();
	}
}
