package command;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand extends Command {
	private Stock stock = new Stock();
	
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("mypage");
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		stock.login(request);
	}
}

