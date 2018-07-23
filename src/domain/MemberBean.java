package domain;

import lombok.Data;

@Data
public class MemberBean {
	protected String memId, teamId, name, age, roll, passWord, ssn;
	
	@Override
	public String toString() {
		return "MemberBean [memId=" + memId + ", teamId=" + teamId + ", name=" + name + ", age=" + age + ", roll="
				+ roll + ", passWord=" + passWord + ", ssn=" + ssn + "]";
	}
}
