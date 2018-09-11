package com.spring5.web.mbr;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface MemberService {
	public void add(Member p);
	public List<?> list(Map<?, ?> p);
	public List<?> search(Map<?, ?> p);
	public Member retrieve(Map<?, ?> p);
	public int count(Map<?, ?> p);
	public void modify(Map<?, ?> p);
	public void remove(Map<?, ?> p);
	public boolean login(Member p);
}
