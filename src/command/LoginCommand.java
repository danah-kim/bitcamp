package command;

public class LoginCommand extends Command {
	public LoginCommand(String domain, String action, String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
