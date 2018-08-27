package com.gms.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.domain.MemberDTO;
import com.gms.web.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired MemberDTO member;
	@Autowired MemberService memberService;
	@RequestMapping("/add")
	public String add() {
		logger.info("MemberContoller add");
		return "redirect:/move/auth/member/login";
	}
	@RequestMapping("/list")
	public String list() {
		logger.info("MemberContoller list");
		return "member:member/list.tiles";
	}
	@RequestMapping("/search")
	public String search() {
		logger.info("MemberContoller search");
		return "member:member/search.tiles";
	}
	@RequestMapping("/retrieve")
	public String retrieve() {
		logger.info("MemberContoller retrieve");
		return "member:member/retrieve.tiles";
	}
	@RequestMapping("/count")
	public String count() {
		logger.info("MemberContoller count");
		return "member:member/count.tiles";
	}
	@RequestMapping("/modify")
	public String modify() {
		logger.info("MemberContoller modify");
		return "redirect:/move/member/member/retrieve";
	}
	@RequestMapping("/remove")
	public String remove() {
		logger.info("MemberContoller remove");
		return "redirect:/move/member/common/main";
	}
	@RequestMapping("/login")
	public String login() {
		logger.info("MemberContoller login");
		Map<String, String> map = new HashMap<>();
		map.put("userid", "H5");
		MemberDTO m = memberService.retrieve(map);
		System.out.println("-----------");
		System.out.println(m.getName());
		System.out.println("-----------");
		return "member:common/content.tiles";
	}
	@RequestMapping("/logout")
	public String logout() {
		logger.info("MemberContoller logout");
		return "redirect:/";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}
