package com.spring4.web.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring4.web.domain.ArticleDTO;
import com.spring4.web.mapper.BoardMapper;
import com.spring4.web.service.BoardService;
import com.spring4.web.service.MemberService;

@Service
public class BoardServiceImpl implements BoardService{
	static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	@Autowired BoardMapper mapper;
	@Override
	public void add(ArticleDTO p) {
		mapper.insert(p);
	}

	@Override
	public List<?> list(Map<?, ?> p) {
		return mapper.selectList(p);
	}

	@Override
	public List<?> search(Map<?, ?> p) {
		return mapper.selectSome(p);
	}

	@Override
	public ArticleDTO retrieve(Map<?, ?> p) {
		return mapper.selectOne(p);
	}

	@Override
	public int count(Map<?, ?> p) {
		return mapper.count(p);
	}

	@Override
	public void modify(Map<?, ?> p) {
		mapper.update(p);
	}

	@Override
	public void remove(Map<?, ?> p) {
		mapper.delete(p);
	}

}
