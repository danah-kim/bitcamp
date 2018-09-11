package com.spring5.web.mbr;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
	public void insert(Member p);
	public List<?> selectList(Map<?, ?> p);
	public List<?> selectSome(Map<?, ?> p);
	public Member selectOne(Map<?, ?> p);
	public int count(Map<?, ?> p);
	public void update(Map<?, ?> p);
	public void delete(Map<?, ?> p);
	public String login(Member p);
	public String exist(Member p);
}
