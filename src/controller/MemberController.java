package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Receiver;
import command.Carrier;
import enums.Action;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController Enter");
		// 클라이언트의 요청을 Receiver의 init 메소드로 전달
		Receiver.init(request);
		System.out.println("액션: " + Receiver.cmd.getAction());
		// Receiver.cmd.getAction().toUpperCase : cmd에 들어있는 action 값을 대문자로 가져옴
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE :
			System.out.println("무브 안으로 진입");
			// 요청과 응답을 Carrier의 send 메소드로 전달
			if(Receiver.cmd.getAction().equals(Receiver.cmd.getPage())) {
				Carrier.redirect(request, response, "");
			}else {
				Carrier.forward(request, response);
			}
			break;
		case JOIN :
			System.out.println("Join 들어옴");
			Carrier.redirect(request, response, "/member.do?action=move&page=user_login_form");
			break;
		case LIST :			
			System.out.println("memberList 들어옴");
			Carrier.forward(request, response);
			break;
		case SEARCH :
			System.out.println("searchMemberByTeam 들어옴");
			Carrier.forward(request, response);
			break;
		case RETRIVE :
			System.out.println("searchMemberById 들어옴");
			Carrier.forward(request, response);
			break;
		case COUNT :
			System.out.println("memberCount 들어옴");
			Carrier.forward(request, response);
			break;
		case UPDATE :
			System.out.println("memberUpdate 들어옴");
			Carrier.redirect(request, response, "/member.do?action=move&page=mypage");
			break;
		case DELETE :
			System.out.println("memberDelete 들어옴");
			Carrier.redirect(request, response, "");
			break;
		case LOGIN :
			System.out.println("login 들어옴");
			if(request.getAttribute("match").equals("TRUE")) {
				System.out.println("로그인성공");
				// command는 Java의 영역이기 때문에 session의 영역이 아님
				request.getSession().setAttribute("user", request.getAttribute("user"));
				/*Receiver.cmd.setPage("mypage");
				Receiver.cmd.execute();*/
				Carrier.forward(request, response);
			}else {
				System.out.println("로그인실패");
				Carrier.redirect(request, response, "/member.do?action=move&page=user_login_form");
			}
			break;
		default :
			Carrier.redirect(request, response, "");
			break;
		}
		
		/*실제 프로젝트가 들어있는 경로
		System.out.println("request.getRealPath() : " + request.getRealPath(""));
		프로젝트 경로 -> 도메인
		System.out.println("request.getContextPath() : " + request.getContextPath());
		파일 경로 -> 페이지 경로
		System.out.println("request.getServletPath() : " + request.getServletPath());
		프로젝트와 파일 경로 -> URL
		System.out.println("request.getRequestURL() : " + request.getRequestURI());
		
		System.out.println("request.getRemoteAddr() : " + request.getRemoteAddr());*/
		
/*		String page = request.getParameter("page");
		MemberBean member = null;
		List<MemberBean> list = null;
		switch (request.getParameter("action")) {
		case "action" :
			request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);
			System.out.println("move 들어옴");
			break;
		case "join" :
			member = new MemberBean();
			member.setMemId(request.getParameter("join_id"));
			member.setPassWord(request.getParameter("join_pw"));
			member.setName(request.getParameter("join_name"));
			member.setSsn(request.getParameter("join_birth")+request.getParameter("join_gender"));
			member.setTeamId("");
			member.setRoll("");
			MemberServiceImpl.getInstance().createMember(member);
			System.out.println("join 들어옴");
			break;
		case "memberList":
			list = MemberServiceImpl.getInstance().memberList();
			System.out.println("memberList 들어옴");
			break;
		case "searchMemberByTeam":
			list = MemberServiceImpl.getInstance().findByWord("TEAM_ID"+"/"+request.getParameter("search_team_id"));
			System.out.println("searchMemberByTeam 들어옴");
			break;
		case "searchMemberById":
			member = new MemberBean();
			member.setMemId(request.getParameter("search_id"));
			member = MemberServiceImpl.getInstance().findByID(member);
			System.out.println("searchMemberById 들어옴");
			break;
		case "memberCount":
			list = MemberServiceImpl.getInstance().memberList();
			System.out.println("memberCount 들어옴");
			break;
		case "memberUpdate":
			member = new MemberBean();
			member.setMemId(request.getParameter("update_id"));
			member.setPassWord(request.getParameter("update_old_password")+"/"+request.getParameter("update_new_password"));
			MemberServiceImpl.getInstance().modifyMember(member);
			System.out.println("memberUpdate 들어옴");
			break;
		case "memberDelete":
			member = new MemberBean();
			member.setMemId(request.getParameter("delete_id"));
			member.setPassWord(request.getParameter("delete_password"));
			MemberServiceImpl.getInstance().removeMember(member);
			System.out.println("memberDelete 들어옴"+member);
			break;
		case "login":
			member = new MemberBean();
			member.setMemId(request.getParameter("user_id"));
			member.setPassWord(request.getParameter("user_pw"));
			member = MemberServiceImpl.getInstance().login(member);
			System.out.println("login 들어옴");
			break;
		}
		request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);*/

/*		// 호출받으면 파라미터 값(실제경로입력)으로 연결
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/user_login_form.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 요청과 응답을 같이 보냄(요청과 응답내역 동시 확인 가능)
		rd.forward(request, response);*/
		
		/*String path = request.getServletPath();
		
		switch(path) {
		case "/member/user_login_form.do" : 
			request.getRequestDispatcher("/WEB-INF/view/member/user_login_form.jsp").forward(request, response);	
			break;
		case "/member/user_login_result.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/user_login_result.jsp").forward(request, response);	
		case "/admin/admin_login.do" :
			request.getRequestDispatcher("/WEB-INF/view/admin/admin_login.jsp").forward(request, response);
			break;
		case "/member/join_form.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/join_form.jsp").forward(request, response);
			break;
		case "/member/join_result.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/join_result.jsp").forward(request, response);
			break;
		case "/member/member_list.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/member_list.jsp").forward(request, response);
			break; 
		case "/main.do" :
			request.getRequestDispatcher("../../../main.jsp").forward(request, response);
			break;
		case "/member/search_team_form.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/search_team_form.jsp").forward(request, response);
			break;
		case "/member/search_team_result.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/search_team_result.jsp").forward(request, response);
			break;
		case "/member/search_id_form.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/search_id_form.jsp").forward(request, response);
			break;
		case "/member/search_id_result.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/search_id_result.jsp").forward(request, response);
			break;
		case "/member/update_form.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/update_form.jsp").forward(request, response);
			break;
		case "/member/update_result.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/update_result.jsp").forward(request, response);
			break;
		case "/member/delete_form.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/delete_form.jsp").forward(request, response);
			break;
		case "/member/delete_result.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/delte_result.jsp").forward(request, response);
			break;
		}*/
	}

}
