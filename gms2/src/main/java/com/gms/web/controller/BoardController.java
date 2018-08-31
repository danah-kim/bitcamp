package com.gms.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gms.web.domain.ArticleDTO;
import com.gms.web.domain.MemberDTO;
import com.gms.web.service.BoardService;

@Controller
@RequestMapping("/board")
@SessionAttributes("article")
public class BoardController {
	static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired ArticleDTO article;
	@Autowired BoardService boardService;
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("article") ArticleDTO article) {
		logger.info("BoardController add");
		return "redirect:/move/auth/member/login";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		logger.info("BoardController list");
		return "member:member/list.tiles";
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search() {
		logger.info("BoardController search");
		return "member:member/search.tiles";
	}
	@RequestMapping(value="/retrieve", method=RequestMethod.GET)
	public String retrieve() {
		logger.info("BoardController retrieve");
		return ":member/retrieve.tiles";
	}
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public String count(Model model) {
		logger.info("BoardController count");
		return ":";
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("article") ArticleDTO member, Model model) {
		logger.info("BoardController modify");
		return "redirect:";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("article") ArticleDTO member) {
		logger.info("BoardController remove");
		return "redirect:";
	}
}
