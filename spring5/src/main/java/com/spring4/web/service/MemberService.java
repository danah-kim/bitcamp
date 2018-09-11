package com.spring4.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spring4.web.domain.MemberDTO;

@Component
public interface MemberService {
	public void add(MemberDTO p);
	public List<?> list(Map<?, ?> p);
	public List<?> search(Map<?, ?> p);
	public MemberDTO retrieve(Map<?, ?> p);
	public int count(Map<?, ?> p);
	public void modify(Map<?, ?> p);
	public void remove(Map<?, ?> p);
	public boolean login(MemberDTO p);
}
