package com.spring5.web.brd;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {
	public void insert(Article p);
	public List<?> selectList(Map<?, ?> p);
	public List<?> selectSome(Map<?, ?> p);
	public Article selectOne(Map<?, ?> p);
	public int count(Map<?, ?> p);
	public void update(Map<?, ?> p);
	public void delete(Map<?, ?> p);
	public int countPaging();
	public Article listCriteria();
	public Article listPage();
	public List<Article> listSearch();
}
