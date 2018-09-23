package com.spring5.web.mbr;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring5.web.cmm.Util;
import com.spring5.web.cmm.Util2;

@RestController
@RequestMapping("/mbr")
public class MemberCtrl {
	@Autowired Member member;
	@Autowired MemberMapper mapper;
	@Autowired Util2 util2;
	
	@PostMapping("/add")
	public @ResponseBody void add(@RequestBody Member param) {
		Util.log.accept("MemberContoller add");
		Util.log.accept(param.toString());
		String[] s = param.subject.split(",");
		if(mapper.count(param)==0) {
			param.setSsn(param.getAge()+"-"+param.getGender());
			param.setGender(util2.gender.apply(param));
			param.setAge(util2.age.apply(param));
			//mapper.post(param);
		}else {
		}
	}
	@GetMapping("/list")
	public Map<String, Object> list(@RequestBody Map param) {
		Util.log.accept("MemberContoller list");
		return param;
	}
	@GetMapping("/search")
	public Map<String, Object> search(@RequestBody Map param) {
		Util.log.accept("MemberContoller search");
		return param;
	}
	@GetMapping("/retrieve")
	public Map<String, Object> retrieve(@RequestBody Member param) {
		Util.log.accept("MemberContoller retrieve");
		Map<String, Object> map = new HashMap<>();
		return map;
	}
	@GetMapping("/count")
	public Map<String, Object> count(@RequestBody Member param) {
		Util.log.accept("MemberContoller count");
		Map<String, Object> map = new HashMap<>();
		map.put("count", mapper.count(param)+"");
		return map;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("user") Member user,
						@RequestParam Map<String, String> map,
							Model model) {
		Util.log.accept("MemberContoller modify");
		map.put("userid", user.getUserid());
		Util.log.accept("확인중" + map);
		//mapper.put(map);
		//model.addAttribute("user", mapper.selectOne(user));
		return "redirect:/move/member/member/retrieve";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("user") Member user) {
		Util.log.accept("MemberContoller remove");
		Map<String, String> map = new HashMap<>();
		map.put("userid", user.getUserid());
		map.put("password", user.getPassword());
		//mapper.delete(map);
		return "redirect:/move/public/common/content";
	}
	@PostMapping("/login")
	public @ResponseBody Map<String, Object> login(@RequestBody Member param){
		Util.log.accept("MemberContoller login");
		Map<String, Object> map = new HashMap<>();
		if(mapper.count(param)!=0) {
			Function<Member, Member> f = (t) -> {
				return mapper.get(t);
			};
			member = f.apply(param);
			if(member != null) {
				map.put("user", member);
			}else {
				map.put("msg","비밀번호가 일치하지 않음");
			}
		}else {
			map.put("msg","아이디가 존재하지 않음");	
		}
		return map;
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}
