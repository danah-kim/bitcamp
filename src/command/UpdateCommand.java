package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("mypage");
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())){
			case MEMBER :
				System.out.println("업데이트!!");
				MemberBean member = new MemberBean();
				member.setMemId(((MemberBean)request.getSession().getAttribute("user")).getMemId());
				member.setPassWord(request.getParameter("new_pw"));
				member.setTeamId(request.getParameter("teamid"));
				member.setRoll(request.getParameter("roll"));
				MemberServiceImpl.getInstance().modifyMember(member);
				request.getSession().setAttribute("user", MemberServiceImpl.getInstance().findByID(member));
				break;
			default :
				break;
		}
		super.execute();
	}
}
