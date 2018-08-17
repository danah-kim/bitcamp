package command;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import proxy.Pagination;
import proxy.Proxy;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
		case ADMIN :
			Proxy pxy = new Proxy();
			Map<String, Object> map = new HashMap<>();
			map.put("mission", "pagination");
			map.put("request", request);
			map.put("column", (request.getParameter("condition")==null)? "": request.getParameter("condition"));
			map.put("value", request.getParameter("word"));
			map.put("pageNum", (request.getParameter("pageNum")==null) ?
					1
					: Integer.parseInt(request.getParameter("pageNum")));
			if(map.get("column").equals("")) {
				map.put("totalRecode", MemberServiceImpl.getInstance().count());
			}else {
				request.setAttribute("column", map.get("column"));
				request.setAttribute("value", map.get("value"));
				map.put("startRow", 1);
				map.put("endRow", MemberServiceImpl.getInstance().count());
				map.put("totalRecode", MemberServiceImpl.getInstance().search(map).size());
			}
			pxy.carrayOut(map);
			Pagination page = pxy.getPagination();
			map.put("startRow", page.getStartRow());
			map.put("endRow", page.getEndRow());

			List<MemberBean> list = MemberServiceImpl.getInstance().search(map);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			break;
		default:
			break;
		}
		super.execute();
	}
}
