package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RetriveCommand extends Command {
	public RetriveCommand(HttpServletRequest request) {
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
			System.out.println("아이디검색 안으로 진입");
			MemberBean member = new MemberBean();
			member.setMemId(request.getParameter("search_id"));
			request.setAttribute("id", MemberServiceImpl.getInstance().findByID(member));
			break;
		default:
			break;
		}
		super.execute();
	}
}
