package com.spring5.web.brd;


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
	@Autowired Map<String, Object> map;
	
	@RequestMapping("/boards/{pageNo}")
	public @ResponseBody Map<String, Object> list(@PathVariable String pageNo) {
		logger.info("BoardContoller :","list..");
		Util.log.accept("page:"+pageNo);
		PageProxy pxy = new PageProxy();
		map.clear();
		map.put("pageNum", (pageNo.equals("undefined"))? 1 : Integer.parseInt(pageNo));
		map.put("totalRecode", brdmapper.countAll());
		pxy.carraryOut(map);
		page = pxy.getPagination();
		map.clear();
		map.put("list", brdmapper.listAll(page));
		map.put("page", page);
		return map;
	}
}