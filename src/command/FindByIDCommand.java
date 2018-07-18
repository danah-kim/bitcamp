package command;

public class FindByIDCommand extends Command {
	public FindByIDCommand(String domain, String action, String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
