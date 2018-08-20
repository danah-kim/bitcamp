package com.gms.web.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Member {
	protected String memId, passWord, name, ssn, age, teamId, roll, gender, subject;
}
