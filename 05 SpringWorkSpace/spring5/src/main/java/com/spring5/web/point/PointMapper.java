package com.spring5.web.point;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface PointMapper {
	public Map<?, ?> get(Map<?,?> p);
	public void update(Map<?,?> p);
}
