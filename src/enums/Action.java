package enums;

import java.util.List;

import domain.MemberBean;
import service.MemberServiceImpl;

public enum Action {
	MOVE, JOIN, LIST, SEARCH, RETRIVE, COUNT, UPDATE, DELETE, LOGIN;
	
	/*public String toString() {
		String page = request.getParameter("page");
		MemberBean member = null;
		List<MemberBean> list = null;
		switch(this) {
		case MOVE :
			request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);
			break;
		case JOIN :
			MemberServiceImpl.getInstance().createMember(member);
			break;
		case LIST :
			MemberServiceImpl.getInstance().memberList();
			break;
		case SEARCH :
			list = MemberServiceImpl.getInstance().findByWord("TEAM_ID"+"/"+request.getParameter("search_team_id"));
			break;
		case RETRIVE:
			member = MemberServiceImpl.getInstance().findByID(member);
			break;
		case COUNT :
			list = MemberServiceImpl.getInstance().memberList();
			break;
		case UPDATE :
			MemberServiceImpl.getInstance().modifyMember(member);
			break;
		case DELETE :
			MemberServiceImpl.getInstance().removeMember(member);
			break;
		case LOGIN :
			break;
		default :
			break;
		return action;
	}
	}*/

}
