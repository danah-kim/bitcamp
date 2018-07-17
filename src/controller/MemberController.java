package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController Enter");
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
		
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		switch (action) {
		case "move" :
			request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
