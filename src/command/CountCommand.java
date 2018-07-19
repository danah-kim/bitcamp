package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberBean;
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
		switch(Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER :
			request.setAttribute("count", MemberServiceImpl.getInstance().countMember());	
			break;
		default:
			break;
		}
		super.execute();
	}
}
