package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RetriveCommand extends Command {
	public RetriveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		System.out.println("도메인 : "+domain+"액션 : "+action+"페이지 : "+page);
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
		case ADMIN :
			System.out.println("아이디검색 안으로 진입");		
			System.out.println(domain);
			MemberBean member = new MemberBean();
			member.setMemId(request.getParameter("search_id").toUpperCase());
			request.setAttribute("id", MemberServiceImpl.getInstance().findByID(member));
			break;
		default:
			break;
		}
		super.execute();
	}
}
