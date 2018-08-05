package command;


import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import service.MemberServiceImpl;

public class SearchCommand extends Command {

	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
			case MEMBER :
			case ADMIN :
				System.out.println("검색 안으로 진입");
				System.out.println("조건 : "+request.getParameter("condition")+" 내용 : "+request.getParameter("word"));
				String condtion = (request.getParameter("condition").toString().equals("teamName")) ?
						"TEAM_ID"
						: request.getParameter("condition");
				String word = (request.getParameter("condition").toString().equals("teamName")) ?
						"(SELECT TEAM_ID FROM RPROJECT_TEAM WHERE TEAM_NAME LIKE '"+ request.getParameter("word")+"')"
						: request.getParameter("word");
				
				request.setAttribute("list", MemberServiceImpl.getInstance().findByWord(condtion.toUpperCase()+"/"+word.toUpperCase()));
				break;
			default:
				break;
		}
		super.execute();
	}
}
