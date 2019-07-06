package com.spring5.web.cmm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.spring5.web.mbr.Member;
@Component
public class Util2 {
	public Function<Member, String> gender = (Member m)->{
		switch (m.getGender()) {
		case "1" : case "3" : case "5" :
			m.setGender("남자");
			break;
		case "2" : case "4" : case "6" :
			m.setGender("여자");
			break;
		default:
			break;
		}
		return m.getGender();
	};
	public Function<Member, String> age = (Member m)->{
		String year = new SimpleDateFormat("yyyy").format(new Date());
		m.setAge(String.valueOf(Integer.parseInt(year) - Integer.parseInt(19 + m.getAge().substring(0, 2)) + 1));
		return m.getAge();
	};
}
