package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import proxy.PageProxy;
import proxy.Pagination;
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
		MemberServiceImpl.getInstance().add(member);
	}
	
	public void search(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		int pageNum = (request.getParameter("pageNum")==null) ? 1 : Integer.parseInt(request.getParameter("pageNum"));
		
		PageProxy pxy = new PageProxy();
		pxy.carraryOut(pageNum);
		Pagination page = pxy.getPagination();

		map.put("startRow", String.valueOf(page.getStartRow()));
		map.put("endRow", String.valueOf(page.getEndRow()));
		map.put("condtion", request.getParameter("condition"));
		map.put("word", request.getParameter("word"));
		request.setAttribute("page", page);
		
		request.setAttribute("list", MemberServiceImpl
					.getInstance()
					.search(map));
	}
	
	public void retrive(HttpServletRequest request) {
		request.setAttribute("member", MemberServiceImpl.getInstance().retrieve(request.getParameter("condition").toUpperCase()));
	}
	
	public void count(HttpServletRequest request) {
		request.getSession().setAttribute("count", MemberServiceImpl.getInstance().count());
	}
	
	public void update(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("memId", ((MemberBean) request.getSession().getAttribute("user")).getMemId());
		System.out.println("stock ID:" + member.getMemId());
		map.put("passWord",request.getParameter("new_pw"));
		map.put("TeamId", request.getParameter("teamid"));
		map.put("Roll", request.getParameter("roll"));
		MemberServiceImpl.getInstance().modify(map);
		request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retrieve("###"));
	}
	
	public void delete(HttpServletRequest request) {
		member = new MemberBean();
		member.setMemId(((MemberBean)request.getSession().getAttribute("user")).getMemId());
		member.setPassWord(request.getParameter("pw1"));
		MemberServiceImpl.getInstance().remove(member);
		request.getSession().invalidate();
	}
	
	public void login(HttpServletRequest request) {
		String id="", pw="";
		id = request.getParameter("id").toUpperCase();
		pw = request.getParameter("pw");
		
		if(MemberServiceImpl.getInstance().login(member)) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retrieve(id+"/"+pw));
		}else {
			request.setAttribute("match", "FALSE");
		}
	}
}
