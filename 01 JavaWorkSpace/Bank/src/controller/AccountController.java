package controller;

import javax.swing.JOptionPane;

enum AccountButt {
	EXIT, ACCOUNT, MINUS_ACCOUNT, LIST
}

public class AccountController {
	public static void main(String[] args) {
		while (true) {
			switch ((AccountButt) JOptionPane.showInputDialog(null, "Choice of Account Type", "Select Menu",
					JOptionPane.QUESTION_MESSAGE, null, new AccountButt[] { AccountButt.EXIT, AccountButt.ACCOUNT,
							AccountButt.MINUS_ACCOUNT, AccountButt.LIST },
					null)) {
			case EXIT:
				return;
			case ACCOUNT:
				break;
			case MINUS_ACCOUNT:
				break;
			case LIST:
				break;
			default:
				break;
			}
		}
	}
}
