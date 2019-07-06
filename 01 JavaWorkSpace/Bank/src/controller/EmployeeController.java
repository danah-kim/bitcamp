package controller;

/**
이름, 본봉 입력하면 총금액표시 
김길동, 100 > 김인턴 100만원 지급 
김길동, 100 > 김직원 110만원 지급 
김길동, 100 > 김이사 1100만원 지급 // (sal + bonus) * 10
 */
import javax.swing.JOptionPane;

enum EmployeeButt {
	EXIT, INTERN, STAFF, OWNER, LIST
}

public class EmployeeController {
	public static void main(String[] args) {
		while (true) {
			switch ((EmployeeButt) JOptionPane.showInputDialog(null, "Choice of Employee Type", "Select Menu",
					JOptionPane.QUESTION_MESSAGE, null, new EmployeeButt[] { EmployeeButt.EXIT, EmployeeButt.INTERN,
							EmployeeButt.STAFF, EmployeeButt.OWNER, EmployeeButt.LIST },
					null)) {
			case EXIT:
				return;
			case INTERN:
				//service.createSalary(JOptionPane.showInputDialog("이름"),JOptionPane.showInputDialog("급여"));
				break;
			case STAFF:
				JOptionPane.showInputDialog("이름");
				JOptionPane.showInputDialog("급여");
				break;
			case OWNER:
				JOptionPane.showInputDialog("이름");
				JOptionPane.showInputDialog("급여");
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, "");
				break;
			default:
				break;
			}
		}
	}
}
