package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Server;
import command.Receiver;
import enums.Action;

@WebServlet("/admin.do")
public class AdminCotroller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminController 진입");
		Receiver.init(request);
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE :
			System.out.println("무브 안으로 진입");
			if(Receiver.cmd.getAction().equals(Receiver.cmd.getPage())) {
				Server.redirect(request, response, "");
			}else {
				Server.forward(request, response);
			}
			break;
		case LIST :			
			System.out.println("memberList 진입");
			Server.forward(request, response);
			break;
		case SEARCH :
			System.out.println("searchMemberByWord 진입");
			Server.forward(request, response);
			break;
		case RETRIVE :
			System.out.println("searchMemberById 진입");
			Server.forward(request, response);
			break;
		case UPDATE :
			System.out.println("memberUpdate 진입");
			Server.redirect(request, response, "/member.do?action=move&page=mypage");
			break;
		case DELETE :
			System.out.println("memberDelete 진입");
			Server.redirect(request, response, "");
			break;
		default :
			Server.redirect(request, response, "");
			break;
		}
	}
}
