package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command {
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
			case MEMBER :
				MemberBean member = new MemberBean();
				member.setMemId(request.getParameter("delete_id"));
				member.setPassWord(request.getParameter("delete_password"));
				MemberServiceImpl.getInstance().removeMember(member);
				break;
			default:
				break;
		}
		super.execute();
	}
}
