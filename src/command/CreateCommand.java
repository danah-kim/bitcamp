package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command{
	
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		System.out.println("도메인 확인 : "+ domain);
		System.out.println("액션확인 : " + action);
		System.out.println("페이지확인 : " + page);
		execute();
	}

	@Override
	public void execute() {
		System.out.println("도메인값 확인 : "+ domain.toUpperCase());
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
			System.out.println("조인 안으로 진입");
			MemberBean member = new MemberBean();
			member.setMemId(request.getParameter("id").toUpperCase());
			member.setPassWord(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			member.setTeamId(request.getParameter("teamid"));
			member.setRoll(request.getParameter("roll"));
			member.setAge(request.getParameter("age"));
			member.setGender(request.getParameter("gender"));
			member.setSubject(ParamMap.getValues(request, "subject"));
			MemberServiceImpl.getInstance().createMember(member);
			break;
		default:
			break;
		}
		super.execute();
	}
}
