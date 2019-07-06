package com.spring5.web.tx;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring5.web.brd.Board;
import com.spring5.web.brd.BoardMapper;
import com.spring5.web.cmm.Util;
import com.spring5.web.cmm.Util2;
import com.spring5.web.point.PointMapper;

@Service
@Transactional
public class TxService {
	@Autowired BoardMapper brdMapper;
	@Autowired PointMapper poMapper;
	@Autowired Board brd;
	@Autowired Util2 util2;
	@Autowired Map<String, Object> map;
	
	@Transactional
	public void write(Map<?,?> p){
		map.clear();
		brd = (Board) p.get("brd");
		brdMapper.create((Board) p.get("brd"));
		map.put("userid", brd.getWriter());
		map = (Map<String, Object>) poMapper.get(map);
		map.put("allpoint", (int)map.get("allpoint")-30);
		map.put("mbrpoint", (int)map.get("mbrpoint")+30);
		poMapper.update(map);
	}
	
	@Transactional
	public Boolean delete(Map<?,?> p){
		map.clear();
		brd.setBno((int)p.get("boardNo"));
		brdMapper.delete(brd);
		map = (Map<String, Object>) poMapper.get(p);
		map.put("allpoint", (int)map.get("allpoint")+30);
		map.put("mbrpoint", (int)map.get("mbrpoint")-30);
		poMapper.update(map);
		//Util.log.accept("삭제확인!"+brdMapper.listOne(p).size());
		return brdMapper.listOne(p).size()==0;
	}
}
