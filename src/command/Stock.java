package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import service.MemberServiceImpl;

public class Stock {
	private MemberBean member = null;
	
	public void create(HttpServletRequest request) {
		member = new MemberBean();
		member.setMemId(request.getParameter("id").toUpperCase());
		member.setPassWord(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setSsn(request.getParameter("ssn"));
		member.setTeamId(request.getParameter("teamid"));
		member.setRoll(request.getParameter("roll"));
		member.setAge(request.getParameter("age"));
		member.setGender(request.getParameter("gender"));
		member.setSubject(ParamMap.getValues(request, "subject"));
		MemberServiceImpl.getInstance().create(member);
	}
	
	public void list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		int pageNum = (request.getParameter("pageNum")==null) ? 1 : Integer.parseInt(request.getParameter("pageNum"));
		
		PageProxy pxy = new PageProxy();
		pxy.carraryOut(pageNum);
		Pagination page = pxy.getPagination();

		map.put("startRow", String.valueOf(page.getStartRow()));
		map.put("endRow", String.valueOf(page.getEndRow()));
		request.setAttribute("page", page);
		
		request.setAttribute("list", MemberServiceImpl.getInstance().search(map));
	}
	
	public void search(HttpServletRequest request) {
		System.out.println("조건 : "+request.getParameter("condition")+" 내용 : "+request.getParameter("word"));
		
		String condtion = (request.getParameter("condition").toString().equals("teamName"))
				? "TEAM_NAME"
				: request.getParameter("condition");
		String word = request.getParameter("word");
		
		if(request.getParameter("condition").toString().equals("none")) {
			condtion = " ";
			word = " ";
		}	
		request.setAttribute("list", MemberServiceImpl.getInstance().search(condtion.toUpperCase()+"/"+word.toUpperCase()));
	}
	
	public void retrive(HttpServletRequest request) {
		member = new MemberBean();
		member.setMemId(request.getParameter("condition").toUpperCase());
		request.setAttribute("member", MemberServiceImpl.getInstance().retrieve(member));
	}
	
	public void count(HttpServletRequest request) {
		request.getSession().setAttribute("count", MemberServiceImpl.getInstance().count());
	}
	
	public void update(HttpServletRequest request) {
		member = new MemberBean();
		member.setMemId(((MemberBean)request.getSession().getAttribute("user")).getMemId());
		System.out.println("stock ID:" + member.getMemId());
		member.setPassWord(request.getParameter("new_pw"));
		member.setTeamId(request.getParameter("teamid"));
		member.setRoll(request.getParameter("roll"));
		MemberServiceImpl.getInstance().modify(member);
		request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retrieve(member));
	}
	
	public void delete(HttpServletRequest request) {
		member = new MemberBean();
		member.setMemId(((MemberBean)request.getSession().getAttribute("user")).getMemId());
		member.setPassWord(request.getParameter("pw1"));
		MemberServiceImpl.getInstance().remove(member);
		request.getSession().invalidate();
	}
	
	public void login(HttpServletRequest request) {
		member = new MemberBean();
		member.setMemId(request.getParameter("id").toUpperCase());
		member.setPassWord(request.getParameter("pw"));
		
		if(MemberServiceImpl.getInstance().login(member)) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().findByID(member));
		}else {
			request.setAttribute("match", "FALSE");
		}
	}
}
