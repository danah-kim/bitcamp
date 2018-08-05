package command;


import javax.servlet.http.HttpServletRequest;

import enums.Domain;

public class CountCommand extends Command {
	private Stock stock = new Stock();
	
	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction("move");
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
		case ADMIN :
			stock.count(request);
			break;
		default:
			break;
		}
		super.execute();
	}
}
