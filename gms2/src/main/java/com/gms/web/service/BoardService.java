package com.gms.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gms.web.domain.ArticleDTO;

@Component
public interface BoardService {
	public void add(ArticleDTO p);
	public List<?> list(Map<?, ?> p);
	public List<?> search(Map<?, ?> p);
	public ArticleDTO retrieve(Map<?, ?> p);
	public int count(Map<?, ?> p);
	public void modify(Map<?, ?> p);
	public void remove(Map<?, ?> p);
}
