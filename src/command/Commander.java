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
			case ADD : 
				System.out.println("=== join 진입 ===");
				cmd = new CreateCommand(request);
				break;
			case SEARCH :
				System.out.println("=== list 진입 ===");
				cmd = new SearchCommand(request);
				break;
			/*case SEARCH :
				System.out.println("=== search 진입 ===");
				cmd = new SearchCommand(request);
				break;*/
			case RETRIVE :
				System.out.println("=== retrive 진입 ===");
				cmd = new RetriveCommand(request);
				break;
			case MODIFY :
				System.out.println("=== update 진입 ===");
				cmd = new ModifyCommand(request);
				break;
			case REMOVE :
				System.out.println("=== delete 진입 ===");
				cmd = new RemoveCommand(request);
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

