package command;

import javax.servlet.http.HttpServletRequest;

import enums.Domain;

public class CreateCommand extends Command{
	private Stock stock = new Stock();
	
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		System.out.println("도메인 확인 : "+ domain);
		System.out.println("액션확인 : " + action);
		System.out.println("페이지확인 : " + page);
		execute();
	}

	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
			stock.create(request);
			break;
		default:
			break;
		}
		super.execute();
	}
}
