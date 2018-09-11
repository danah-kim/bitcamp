package com.spring5.web.mbr;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring5.web.cmm.Calc;

@Controller
@RequestMapping("/member")
@SessionAttributes("user")
public class MemberCtrl {
	static final Logger logger = LoggerFactory.getLogger(MemberCtrl.class);
	@Autowired Member member;
	@Autowired MemberMapper mapper;
	@Autowired Calc calc;
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute Member member) {
		logger.info("MemberContoller add");
		Predicate<String> p = s -> !s.equals("");
		if(p.test(mapper.exist(member))) {
			member.setSsn(member.getAge()+"-"+member.getGender());
			member.setGender(calc.gender(member.getGender()));
			member.setAge(calc.age(member.getAge()));
			mapper.insert(member);
			return "redirect:/move/auth/member/login";
		}else {
			return "";
		}
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		logger.info("MemberContoller list");
		return "member:member/list.tiles";
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search() {
		logger.info("MemberContoller search");
		return "member:member/search.tiles";
	}
	@RequestMapping(value="/retrieve", method=RequestMethod.GET)
	public String retrieve() {
		logger.info("MemberContoller retrieve");
		return "member:member/retrieve.tiles";
	}
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public String count(Model model) {
		logger.info("MemberContoller count");
		Map<String, String> map = new HashMap<>();
		map.put("column", "MEMBER");
		model.addAttribute("count", mapper.count(map));
		return "member:member/count.tiles";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("user") Member user,
							@RequestParam Map<String, String> map,
							Model model) {
		logger.info("MemberContoller modify");
		map.put("userid", user.getUserid());
		logger.info("확인중" + map);
		mapper.update(map);
		model.addAttribute("user", mapper.selectOne(map));
		return "redirect:/move/member/member/retrieve";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("user") Member user,
							SessionStatus sessionStatus) {
		logger.info("MemberContoller remove");
		Map<String, String> map = new HashMap<>();
		map.put("userid", user.getUserid());
		map.put("password", user.getPassword());
		mapper.delete(map);
		sessionStatus.setComplete();
		return "redirect:/move/public/common/content";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Member member, Model model) {
		logger.info("MemberContoller login");
		Predicate<String> p = s -> !s.equals("");
		String view = "redirect:/move/auth/member/login";
		if(p.test(mapper.exist(member))) {
			Function<Member, String> f = (t) -> {
				return mapper.login(member);
			};
			if(f.apply(member).equals("1")) {
				Map<String, String> map = new HashMap<>();
				map.put("userid", member.getUserid());
				model.addAttribute("user", mapper.selectOne(map));
				view = "member:member/retrieve.tiles";
			}
		}
		return view;

	}
	@RequestMapping(value="/logout")
	public String logout(Model model) {
		logger.info("MemberContoller logout");
		model.addAttribute("user", member);
		return "redirect:/move/public/common/content";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}
