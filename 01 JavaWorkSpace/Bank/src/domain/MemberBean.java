package domain;

public class MemberBean {
	public static final String DEPT = "인턴쉽";
	protected String dept, name;
	protected int salary, bonus, total;

	public MemberBean(String name, String salary) {
		this.name = name;
		this.salary = Integer.parseInt(salary);
		dept = DEPT;
	}

	public void setBonus() {
		bonus = (int)(salary*0.1);
	}

	public void setTotal() {
		total = salary + bonus;
	}

	public String getDept() {
		return dept;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public int getBonus() {
		return bonus;
	}

	public int getTotal() {
		return total;
	}

	public String toString() {
		return String.format("%d%d %s만원 지급", name,dept,total);
	}
}
