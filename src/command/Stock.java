package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
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
		MemberServiceImpl.getInstance().createMember(member);
	}
	
	public void list(HttpServletRequest request) {
		/*request.setAttribute("list", MemberServiceImpl.getInstance().memberList());*/
		request.setAttribute("count", MemberServiceImpl.getInstance().countMember());
		
		int totalRecode = MemberServiceImpl.getInstance().countMember();
		int recodeSize = 5;
		int totalPage = (totalRecode-1)/recodeSize+1;
		int pageSize = 5;
		int pageNum = (request.getParameter("pageNum")==null) ? 1 : Integer.parseInt(request.getParameter("pageNum"));
		int startPage = 1 + (int) (Math.ceil((pageNum-1)/pageSize)) * pageSize;
		int endPage = (totalPage < startPage + pageSize  - 1) ? totalPage : (startPage + pageSize -1);
		
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPage", totalPage);

		System.out.println("**시작:"+startPage+"/총페이지수:" + totalPage+"/끝:" + endPage+"/현재페이지:" + pageNum+"****");	
		
		Map<String, Object> map = new HashMap<>();
		int startRow = 1 + ((pageNum-1) * recodeSize);
		int endRow = (totalRecode < startRow + recodeSize - 1) 
										? totalRecode 
										: pageNum*(recodeSize);
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));
		request.setAttribute("list", MemberServiceImpl.getInstance().getList(map));
		
		int prevBlock = startPage - pageSize;
		int nextBlock = startPage + pageSize;
		
		boolean existPrev = false;
		if(prevBlock >= 0) {
			existPrev = true;
		}
		boolean existNext = false;
		if(nextBlock <= recodeSize) {
			existNext = true;
		}
		
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
		
		request.setAttribute("list", MemberServiceImpl.getInstance().findByWord(condtion.toUpperCase()+"/"+word.toUpperCase()));
	}
	
	public void retrive(HttpServletRequest request) {
		member = new MemberBean();
		member.setMemId(request.getParameter("condition").toUpperCase());
		request.setAttribute("member", MemberServiceImpl.getInstance().findByID(member));
	}
	
	public void count(HttpServletRequest request) {
		request.getSession().setAttribute("count", MemberServiceImpl.getInstance().countMember());
	}
	
	public void update(HttpServletRequest request) {
		member = new MemberBean();
		member.setMemId(((MemberBean)request.getSession().getAttribute("user")).getMemId());
		System.out.println("stock ID:" + member.getMemId());
		member.setPassWord(request.getParameter("new_pw"));
		member.setTeamId(request.getParameter("teamid"));
		member.setRoll(request.getParameter("roll"));
		MemberServiceImpl.getInstance().modifyMember(member);
		request.getSession().setAttribute("user", MemberServiceImpl.getInstance().findByID(member));
	}
	
	public void delete(HttpServletRequest request) {
		member = new MemberBean();
		member.setMemId(((MemberBean)request.getSession().getAttribute("user")).getMemId());
		member.setPassWord(request.getParameter("pw1"));
		MemberServiceImpl.getInstance().removeMember(member);
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
