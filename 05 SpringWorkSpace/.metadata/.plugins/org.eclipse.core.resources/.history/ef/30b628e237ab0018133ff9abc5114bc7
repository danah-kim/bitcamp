package com.gms.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gms.web.controller.HomeController;
import com.gms.web.domain.MemberDTO;
import com.gms.web.repository.MemberDAO;

@Repository
public class MemberMapper implements MemberDAO{
	static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired SqlSessionFactory factory;
	private static final String ns = "com.gms.web.mapper.MemberMapper";
	@Override
	public void insert(MemberDTO p) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.selectOne(ns + ".insert", p);
	}

	@Override
	public List<?> selectList(Map<?, ?> p) {
		SqlSession sqlSession = factory.openSession();
		return (List<?>) sqlSession.selectOne(ns + ".selectList", p);
	}

	@Override
	public List<?> selectSome(Map<?, ?> p) {
		SqlSession sqlSession = factory.openSession();
		return (List<?>) sqlSession.selectOne(ns + ".selectSome", p);
	}

	@Override
	public MemberDTO selectOne(Map<?, ?> p) {
		logger.info("MemberMapper selectOne");
		SqlSession sqlSession = factory.openSession();
		return sqlSession.selectOne(ns + ".selectOne", p);
	}

	@Override
	public int count(Map<?, ?> p) {
		logger.info("MemberMapper count");
		SqlSession sqlSession = factory.openSession();
		return (Integer) sqlSession.selectOne(ns + ".count", p);
	}

	@Override
	public void update(Map<?, ?> p) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.selectOne(ns + ".update", p);
	}

	@Override
	public void delete(Map<?, ?> p) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.selectOne(ns + ".delete", p);
	}

	@Override
	public boolean login(MemberDTO p) {
		logger.info("MemberMapper login");
		SqlSession sqlSession = factory.openSession();
		return sqlSession.selectOne(ns + ".login", p)!=null;
	}

}
