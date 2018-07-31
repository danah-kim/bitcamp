package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Term;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resources{
		CONTEXT, CSS, JS, IMG
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0;
		for(Resources r : Resources.values()) {
			request.getSession()
			.setAttribute(r.toString().toLowerCase(),
					(i==0)?
							request.getContextPath() :
							request.getContextPath()+"/resources/"+r.toString().toLowerCase());
			 i++;
			}
		// session정보를 context에 저장해서 request에 담음 각 페이지에서 선언 안해도 되도록 만듬
		/*request.getSession().setAttribute(Domain.CONTEXT.toString(), request.getContextPath());*/
		/*request.getSession().setAttribute("context", request.getContextPath());*/
		/*HttpSession session = request.getSession();
		session.setAttribute("context", request.getContextPath());*/
		request.getRequestDispatcher(Term.WEBPATH.toString()+Term.MAIN.toString()).forward(request, response);
		/*request.getRequestDispatcher("WEB-INF/view/main.jsp").forward(request, response);*/
	}
}
