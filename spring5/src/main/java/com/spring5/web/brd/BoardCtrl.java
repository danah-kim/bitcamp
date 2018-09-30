package com.spring5.web.brd;


import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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
		//logger.info("BoardContoller :","list..");
		//Util.log.accept("page:"+pageNo);
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
	
	@RequestMapping("/boards/{id}/{pageNo}")
	public @ResponseBody Map<String, Object> mylist(@PathVariable String id, @PathVariable String pageNo) {
		PageProxy pxy = new PageProxy();
		map.clear();
		Function<String[], Object> f = (x) -> {
			String[] arr = {"startRow", "endRow", "userid"};
			for(int i = 0; i < arr.length; i++){
				map.put(arr[i],(x[i].equals(""))? "" : (i==2) ? x[i] : Integer.parseInt(x[i]));
			}
			return (x[0].equals("")) ? brdmapper.listOne(map).size() : brdmapper.listOne(map);
		};
		map.put("pageNum", (pageNo.equals("undefined"))? 1 : Integer.parseInt(pageNo));
		map.put("totalRecode", f.apply(new String[] {"", "", id}));
		pxy.carraryOut(map);
		page = pxy.getPagination();
		map.clear();
		map.put("list", f.apply(new String[] {String.valueOf(page.getStartRow()), String.valueOf(page.getEndRow()), id}));
		map.put("page", page);
		return map;
	}
}