package command;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import proxy.ParamMap;
import proxy.Proxy;
import service.MemberServiceImpl;

public class AddCommand extends Command{
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}

	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
			MemberBean member = new MemberBean();
			member.setMemId(request.getParameter("id"));
			member.setPassWord(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			member.setTeamId(request.getParameter("teamid"));
			member.setRoll(request.getParameter("roll"));
			member.setAge(request.getParameter("age"));
			member.setGender(request.getParameter("gender"));
			Proxy pxy = new Proxy();
			HashMap<String,Object>map = new HashMap<>();
			map.put("mission", "checkbox");
			map.put("request", request);
			pxy.carrayOut(map);
			ParamMap pm = pxy.getParamMap();
			//SubjectBean subject = new SubjectBean();
			//member.setSubject(subject);
			//member.getSubject().setSubjectSeq((String)pm.getText());
			MemberServiceImpl.getInstance().add(member);
			break;
		default:
			break;
		}
		super.execute();
	}
}
