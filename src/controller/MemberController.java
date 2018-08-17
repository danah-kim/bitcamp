package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Receiver;
import command.Server;
import enums.Action;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case ADD :
			Server.redirect(request, response, "/member.do?action=move&page=login");
			break;
		case RETRIEVE :
			Server.forward(request, response);
			break;
		case MODIFY :
			Server.redirect(request, response, "/member.do?action=move&page=retrieve");
			break;
		case FILEUPLOAD :
			Server.redirect(request, response, "/member.do?action=move&page=retrieve");
			break;
		case REMOVE :
			Server.redirect(request, response, "/common.do?action=move&page=main");
			break;
		case MOVE :
				Server.forward(request, response);
			break;
		case LOGIN :
			if(request.getAttribute("match").equals("TRUE")) {
				Server.forward(request, response);
			}else {
				Server.redirect(request, response, "/member.do?action=move&page=login");
			}
			break;
		case LOGOUT :
			Server.redirect(request, response, "/common.do?action=move&page=main");
			break;
		default :
			Server.redirect(request, response, "");
			break;
		}
	}

}
