package com.spring5.web.cmm;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Calc {
	static final Logger logger = LoggerFactory.getLogger(Calc.class);
	public String age(String ssn){
		String year = new SimpleDateFormat("yyyy").format(new Date());
		String birth = 19 + ssn.substring(0, 2);
		int age = Integer.parseInt(year) - Integer.parseInt(birth) + 1 ;
		return String.valueOf(age);
	}
	
	public String gender(String gender) {
		String result = "";
		switch (gender) {
		case "1" : case "3" : case "5" :
			result = "남자";
			break;
		case "2" : case "4" : case "6" :
			result = "여자";
			break;
		default:
			break;
		}
		return result;
	}
}
