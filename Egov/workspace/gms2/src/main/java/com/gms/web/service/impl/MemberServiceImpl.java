package com.gms.web.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.web.common.Calc;
import com.gms.web.domain.MemberDTO;
import com.gms.web.mapper.MemberMapper;
import com.gms.web.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	@Autowired MemberMapper mapper;
	@Autowired Calc calc;
	@Override
	public void add(MemberDTO p) {
		logger.info("MemberService add");
		p.setSsn(p.getAge()+"-"+p.getGender());
		p.setGender(calc.gender(p.getGender()));
		p.setAge(calc.age(p.getAge()));
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
	public MemberDTO retrieve(Map<?, ?> p) {
		logger.info("MemberService retrieve");
		return mapper.selectOne(p);
	}

	@Override
	public int count(Map<?, ?> p) {
		return mapper.count(p);
	}

	@Override
	public void modify(Map<?, ?> p) {
		logger.info("MemberService modify");
		mapper.update(p);
	}

	@Override
	public void remove(Map<?, ?> p) {
		logger.info("MemberService remove");
		mapper.delete(p);
	}

	@Override
	public boolean login(MemberDTO p) {
		logger.info("MemberService login");
		return mapper.login(p)==1;
	}
	
}
