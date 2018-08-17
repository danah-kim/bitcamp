package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ModifyCommand extends Command {
	
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())){
			case MEMBER :
				Map<String, Object> map = new HashMap<>();
				String[] arr1 = {"memId", "passWord", "teamId", "roll"};
				String[] arr2 = {((MemberBean) request.getSession().getAttribute("user")).getMemId(),
									(String) request.getParameter("newPw"),
									(String) request.getParameter("teamId"),
									(String) request.getParameter("roll")};
				for(int i = 0; i < arr1.length; i++){
					map.put(arr1[i],arr2[i]);
				}
				MemberServiceImpl.getInstance().modify(map);
				request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retrieve((String) map.get("memId")));
				break;
			case ADMIN :
				break;
			default :
				break;
		}
		super.execute();
	}
}
