package command;


import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import service.MemberServiceImpl;

public class CountCommand extends Command {
	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
		case ADMIN :
			System.out.println("카운트 안으로 진입");
			action = "move";
			request.getSession().setAttribute("count", MemberServiceImpl.getInstance().countMember());
			break;
		default:
			break;
		}
		super.execute();
	}
}
