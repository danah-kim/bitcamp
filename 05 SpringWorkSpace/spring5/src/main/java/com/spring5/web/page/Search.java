package com.spring5.web.page;

import java.util.HashMap;
import java.util.Map;

public class Search {
	public void test() {

		
		/*Proxy pxy = new Proxy();
		Map<String, Object> map = new HashMap<>();
		map.put("column", (request.getParameter("condition")==null)? 
								""
								: request.getParameter("condition"));
		map.put("value", request.getParameter("word"));
		map.put("pageNum", (request.getParameter("pageNum")==null) ?
								1
								: Integer.parseInt(request.getParameter("pageNum")));
		map.put("startRow", (map.get("column").equals(""))? "" : 1);
		map.put("endRow", (map.get("column").equals("")) ?
							""
							: MemberServiceImpl.getInstance().count());
		map.put("totalRecode", (map.get("column").equals("")) ? 
									MemberServiceImpl.getInstance().count()
									: MemberServiceImpl.getInstance().search(map).size());
		pxy.carrayOut(map);
		Pagination page = pxy.getPagination();
		map.put("startRow", page.getStartRow());
		map.put("endRow", page.getEndRow());
		List<MemberBean> list = MemberServiceImpl.getInstance().search(map);
		request.setAttribute("column", map.get("column"));
		request.setAttribute("value", map.get("value"));
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		*/
	}
}
