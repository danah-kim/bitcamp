package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/admin.do")
public class AdminCotroller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminController Enter");
		Receiver.init(request);
		System.out.println("액션: " + Receiver.cmd.getAction());
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE :
			System.out.println("무브 안으로 진입");
			if(Receiver.cmd.getAction().equals(Receiver.cmd.getPage())) {
				Carrier.redirect(request, response, "");
			}else {
				Carrier.forward(request, response);
			}
			break;
		default :
			Carrier.redirect(request, response, "");
			break;
		}
	}
}
