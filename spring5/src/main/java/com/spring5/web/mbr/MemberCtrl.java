package com.spring5.web.mbr;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

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
import com.spring5.web.cmm.Util;

@Controller
@RequestMapping("/member")
@SessionAttributes("user")
public class MemberCtrl {
	@Autowired Member member;
	@Autowired MemberMapper mapper;
	@Autowired Calc calc;
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute Member member) {
		Util.Log.accept("MemberContoller add");
		if(Util.ChkNull.negate().test(mapper.exist(member))) {
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
		Util.Log.accept("MemberContoller list");
		return "member:member/list.tiles";
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search() {
		Util.Log.accept("MemberContoller search");
		return "member:member/search.tiles";
	}
	@RequestMapping(value="/retrieve", method=RequestMethod.GET)
	public String retrieve() {
		Util.Log.accept("MemberContoller retrieve");
		return "member:member/retrieve.tiles";
	}
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public String count(Model model) {
		Util.Log.accept("MemberContoller count");
		Map<String, String> map = new HashMap<>();
		map.put("column", "MEMBER");
		model.addAttribute("count", mapper.count(map));
		return "member:member/count.tiles";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("user") Member user,
						@RequestParam Map<String, String> map,
							Model model) {
		Util.Log.accept("MemberContoller modify");
		map.put("userid", user.getUserid());
		Util.Log.accept("확인중" + map);
		mapper.update(map);
		model.addAttribute("user", mapper.selectOne(user));
		return "redirect:/move/member/member/retrieve";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("user") Member user,
							SessionStatus sessionStatus) {
		Util.Log.accept("MemberContoller remove");
		Map<String, String> map = new HashMap<>();
		map.put("userid", user.getUserid());
		map.put("password", user.getPassword());
		mapper.delete(map);
		sessionStatus.setComplete();
		return "redirect:/move/public/common/content";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Member member, Model model) {
		Util.Log.accept("MemberContoller login");
		
		String view = "redirect:/move/auth/member/login";
		if(Util.ChkNull.negate().test(mapper.exist(member))) {
			Function<Member, String> f1 = (t) -> {
				return mapper.login(t);
			};
			if(Predicate.isEqual(f1.apply(member)).test("1")) {
				Function<Member, String> f2 = (t) -> {
					model.addAttribute("user", mapper.selectOne(t));
					return "member:member/retrieve.tiles";
				};
				view = f2.apply(member);
			}
		}
		Util.Log.accept(view);
		return view;
	}
	@RequestMapping(value="/logout")
	public String logout(Model model) {
		Util.Log.accept("MemberContoller logout");
		model.addAttribute("user", member);
		return "redirect:/move/public/common/content";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}
