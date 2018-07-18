package command;

public class UpdateCommand extends Command {
	public UpdateCommand(String domain, String action, String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
