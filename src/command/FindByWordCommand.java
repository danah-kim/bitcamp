package command;

public class FindByWordCommand extends Command {
	public FindByWordCommand(String domain, String action, String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
