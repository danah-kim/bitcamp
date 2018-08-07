package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PageProxy implements Proxy{
	HttpServletRequest request;

	@Override
	public Map<?, ?> CarraryOut(Map<?, ?> param) {
		Map<String, Object> map = new HashMap<>();
		/*request = (HttpServletRequest) param.get("request");
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		map.put("request", request);
		
		return null;
	}
	
}
