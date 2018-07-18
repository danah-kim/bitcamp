package command;

import enums.Action;

public class Commander{
	public static  Command order(String domain, String action, String page){
		Command cmd = null;
		switch (Action.valueOf(action.toUpperCase())) {
			case MOVE :
				System.out.println("=== move 진입 ===");
				cmd = new MoveCommand(domain, action, page);
			case JOIN : 
				System.out.println("=== join 진입 ===");
				cmd = new CreateCommand(domain, action, page);
				break;
			case LIST :
				System.out.println("=== list 진입 ===");
				cmd = new ListCommand(domain, action, page);
				break;
			case SEARCH :
				System.out.println("=== search 진입 ===");
				cmd = new FindByWordCommand(domain, action, page);
				break;
			case RETRIVE :
				System.out.println("=== retrive 진입 ===");
				cmd = new FindByIDCommand(domain, action, page);
				break;
			case COUNT :
				System.out.println("=== count 진입 ===");
				cmd = new CountCommand(domain, action, page);
				break;
			case UPDATE :
				System.out.println("=== update 진입 ===");
				cmd = new UpdateCommand(domain, action, page);
				break;
			case DELETE :
				System.out.println("=== delete 진입 ===");
				cmd = new DeleteCommand(domain, action, page);
				break;
			case LOGIN :
				System.out.println("=== login 진입 ===");
				cmd = new LoginCommand(domain, action, page);
				break;
			default :
				break;
		}
			return cmd;
	}
}

