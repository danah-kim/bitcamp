package com.spring5.web.brd;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring5.web.cmm.Util;
import com.spring5.web.cmm.Util2;
import com.spring5.web.page.PageProxy;
import com.spring5.web.page.Pagination;


@RestController
public class BoardCtrl {
	static final Logger logger = LoggerFactory.getLogger(BoardCtrl.class); 
	@Autowired Board brd;
	@Autowired BoardMapper brdmapper;
	@Autowired Util2 util2;
	@Autowired Pagination page;
	
	@RequestMapping("/boards/{pageNo}")
	public @ResponseBody List<Board> list(@PathVariable int pageNo) {
		logger.info("BoardContoller :","list..");
		Util.log.accept("page:"+pageNo);
		PageProxy pxy = new PageProxy();
		Map<String, Object> map = new HashMap<>();
		map.put("pageNum", (pageNo==1)? 1 : pageNo);
		map.put("totalRecode", brdmapper.count());
//		map.put("totalRecode", (column.equals("")) ? 
//					brdmapper.count()
//					: brdmapper.listAll(page).size());
		pxy.carraryOut(map);
		page = pxy.getPagination();
		return brdmapper.listAll(page);
	}
}
