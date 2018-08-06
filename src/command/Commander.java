package command;

import javax.servlet.http.HttpServletRequest;

import enums.Action;

public class Commander{
	public static  Command order(HttpServletRequest request){
		System.out.println("commander 진입");
		Command cmd = null;
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
			case MOVE :
				System.out.println("=== move 진입 ===");
				cmd = new MoveCommand(request);
				break;
			case JOIN : 
				System.out.println("=== join 진입 ===");
				cmd = new CreateCommand(request);
				break;
			case LIST :
				System.out.println("=== list 진입 ===");
				cmd = new ListCommand(request);
				break;
			case SEARCH :
				System.out.println("=== search 진입 ===");
				cmd = new SearchCommand(request);
				break;
			case RETRIVE :
				System.out.println("=== retrive 진입 ===");
				cmd = new RetriveCommand(request);
				break;
			case UPDATE :
				System.out.println("=== update 진입 ===");
				cmd = new UpdateCommand(request);
				break;
			case DELETE :
				System.out.println("=== delete 진입 ===");
				cmd = new DeleteCommand(request);
				break;
			case LOGIN :
				System.out.println("=== login 진입 ===");
				cmd = new LoginCommand(request);
				break;
			default :
				break;
		}
			return cmd;
	}
}

