package com.spring5.web.brd;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface BoardService {
	public void add(Article p);
	public List<?> list(Map<?, ?> p);
	public List<?> search(Map<?, ?> p);
	public Article retrieve(Map<?, ?> p);
	public int count(Map<?, ?> p);
	public void modify(Map<?, ?> p);
	public void remove(Map<?, ?> p);
}
