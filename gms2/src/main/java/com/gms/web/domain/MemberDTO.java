package com.gms.web.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MemberDTO {
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
