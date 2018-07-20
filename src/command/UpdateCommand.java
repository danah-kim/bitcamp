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
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())){
			case MEMBER :
				System.out.println("업데이트!!");
				MemberBean member = new MemberBean();
				member.setMemId(request.getParameter("update_id"));
				member.setPassWord(request.getParameter("update_old_password")+"/"+request.getParameter("update_new_password"));
				MemberServiceImpl.getInstance().modifyMember(member);
				break;
			default :
				break;
		}
		super.execute();
	}
}
