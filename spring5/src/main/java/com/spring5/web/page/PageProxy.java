package com.spring5.web.page;

import org.springframework.context.annotation.Lazy;

import lombok.Data;

@Data @Lazy
public class PageProxy implements Proxy{
	private Pagination pagination;

	@Override
	public void carraryOut(Object o) {
		this.pagination = new Pagination();
		pagination.carraryOut(o);
	}

}