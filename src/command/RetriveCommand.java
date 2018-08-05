package command;

import javax.servlet.http.HttpServletRequest;

import enums.Domain;

public class RetriveCommand extends Command {
	private Stock stock = new Stock();
	
	public RetriveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
		case ADMIN :
			stock.retrive(request);
			break;
		default:
			break;
		}
		super.execute();
	}
}
