package com.spring5.web.mbr;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring5.web.cmm.Calc;
import com.spring5.web.cmm.Util;

@RestController
@RequestMapping("/member")
public class MemberCtrl {
	@Autowired Member member;
	@Autowired MemberMapper mapper;
	@Autowired Calc calc;
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute Member member) {
		Util.log.accept("MemberContoller add");
		if(Util.chkNull.negate().test(mapper.exist(member))) {
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
		Util.log.accept("MemberContoller list");
		return "";
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search() {
		Util.log.accept("MemberContoller search");
		return "";
	}
	@RequestMapping(value="/retrieve", method=RequestMethod.GET)
	public String retrieve() {
		Util.log.accept("MemberContoller retrieve");
		return "";
	}
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public String count(Model model) {
		Util.log.accept("MemberContoller count");
		Map<String, String> map = new HashMap<>();
		map.put("column", "MEMBER");
		model.addAttribute("count", mapper.count(map));
		return "";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("user") Member user,
						@RequestParam Map<String, String> map,
							Model model) {
		Util.log.accept("MemberContoller modify");
		map.put("userid", user.getUserid());
		Util.log.accept("확인중" + map);
		mapper.update(map);
		model.addAttribute("user", mapper.selectOne(user));
		return "redirect:/move/member/member/retrieve";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("user") Member user) {
		Util.log.accept("MemberContoller remove");
		Map<String, String> map = new HashMap<>();
		map.put("userid", user.getUserid());
		map.put("password", user.getPassword());
		mapper.delete(map);
		return "redirect:/move/public/common/content";
	}
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Util.log.accept("MemberContoller login");
		String view = "redirect:/move/auth/member/login";
		if(Util.chkNull.negate().test(mapper.exist(member))) {
			Function<Member, String> f1 = (t) -> {
				return mapper.login(t);
			};
			if(Predicate.isEqual(f1.apply(member)).test("1")) {
				Function<Member, String> f2 = (t) -> {
					model.addAttribute("user", mapper.selectOne(t));
					return "";
				};
				view = f2.apply(member);
			}
		}
		Util.log.accept(view);
		return view;
	}
	@RequestMapping(value="/logout")
	public String logout(Model model) {
		Util.log.accept("MemberContoller logout");
		model.addAttribute("user", member);
		return "redirect:/move/public/common/content";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}
