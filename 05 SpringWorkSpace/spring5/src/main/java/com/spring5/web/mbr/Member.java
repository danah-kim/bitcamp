package com.spring5.web.mbr;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Member {
	String userid,
			ssn, 
			name,
			gender,
			age,
			roll, 
			teamid,
			password,
			email,
			phone,
			subject;
}
