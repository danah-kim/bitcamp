package com.spring5.web.cmm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomeCtrl {
	static final Logger logger = LoggerFactory.getLogger(HomeCtrl.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		model.addAttribute("context", Util.ctx.apply(request));
		return "main";
	}
	@RequestMapping("/move/{prefix}/{dir}/{page}")
	public String move(
			@PathVariable String prefix,
			@PathVariable String dir,
			@PathVariable String page) {
		logger.info("homeContoller move :: prefix : " + prefix);
		logger.info("homeContoller move :: dir : " + dir);
		logger.info("homeContoller move :: page : " + page);
		return prefix+":" + dir + "/" + page + ".tiles";
	}
}