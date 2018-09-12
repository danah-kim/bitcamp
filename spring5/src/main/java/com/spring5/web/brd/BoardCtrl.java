package com.spring5.web.brd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring5.web.mbr.MemberCtrl;

@Controller
@RequestMapping("/board")
public class BoardCtrl {
	static final Logger logger = LoggerFactory.getLogger(MemberCtrl.class);
	@Autowired Article article;
	@Autowired BoardService boardService;
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("article") Article article) {
		logger.info("BoardController add");
		return "redirect:/move/auth/member/login";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		logger.info("BoardController list");
		return "";
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search() {
		logger.info("BoardController search");
		return "";
	}
	@RequestMapping(value="/retrieve", method=RequestMethod.GET)
	public String retrieve() {
		logger.info("BoardController retrieve");
		return "";
	}
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public String count(Model model) {
		logger.info("BoardController count");
		return ":";
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("article") Article member, Model model) {
		logger.info("BoardController modify");
		return "redirect:";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("article") Article member) {
		logger.info("BoardController remove");
		return "redirect:";
	}
}
