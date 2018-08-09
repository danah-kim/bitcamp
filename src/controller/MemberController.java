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
		System.out.println("MemberController Enter");
		Receiver.init(request);
		System.out.println("액션: " + Receiver.cmd.getAction());
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		
		case ADD :
			System.out.println("Join 들어옴");
			Server.redirect(request, response, "/member.do?action=move&page=user_login_form");
			break;
		case SEARCH :
			System.out.println("searchMemberByTeam 들어옴");
			Server.forward(request, response);
			break;
		case RETRIVE :
			System.out.println("searchMemberById 들어옴");
			Server.forward(request, response);
			break;
		case MODIFY :
			System.out.println("memberUpdate 들어옴");
			Server.redirect(request, response, "/member.do?action=move&page=mypage");
			break;
		case REMOVE :
			System.out.println("memberDelete 들어옴");
			Server.redirect(request, response, "");
			break;
		case MOVE :
			System.out.println("무브 안으로 진입");
			if(Receiver.cmd.getAction().equals(Receiver.cmd.getPage())) {
				Server.redirect(request, response, "");
			}else {
				Server.forward(request, response);
			}
			break;
		case LOGIN :
			System.out.println("login 들어옴");
			if(request.getAttribute("match").equals("TRUE")) {
				System.out.println("로그인성공");
				Server.forward(request, response);
			}else {
				System.out.println("로그인실패");
				Server.redirect(request, response, "/member.do?action=move&page=user_login_form");
			}
			break;
		default :
			Server.redirect(request, response, "");
			break;
		}
	}

}
