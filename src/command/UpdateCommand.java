package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;

public class UpdateCommand extends Command {
	private Stock stock = new Stock();
	
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
			case ADMIN :
				System.out.println("updatecommand ID : " + ((MemberBean) request.getSession().getAttribute("user")).getMemId());
				stock.update(request);
				break;
			default :
				break;
		}
		super.execute();
	}
}
