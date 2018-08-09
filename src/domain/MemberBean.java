package domain;

import lombok.Data;

@Data
public class MemberBean {
	protected String memId, passWord, name, ssn, age, teamId, roll, gender, subject;
}
