package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.*;
import domain.*;

public class OpenAccount extends JFrame{
	private static final long serialVersionUID = 1L;
	JLabel topLab, idLab, pwLab, nameLab, accountNameLab, accountNoLab, accountTypeLab, createDateLab;
	JTextField idTxt, pwTxt, nameTxt;
	JButton addBtn;
	JPanel bottomPan, centerPan, idPan, pwPan, namePan, accountNamePan, accountNoPan, accountTypePan, createDatePan;
	JComboBox<?> combo;
	String[] menu = { "기본 통장", "마이너스 통장" };
	public OpenAccount() {
		makeGui(); //화면구성
		this.setSize(400, 300);
		setLocation(100, 100);
		setVisible(true);
	}
	// money, name, id, pw, accountNo, accountType, createDate
	public void makeGui() {
		topLab = new JLabel("통장생성", JLabel.CENTER);
		
		combo = new JComboBox<>(menu);
		idLab = new JLabel("아이디 : ", JLabel.CENTER);
		idTxt = new JTextField(15);
		idPan = new JPanel();
		idPan.add(idLab);
		idPan.add(idTxt);
		
		pwLab = new JLabel("비밀번호 : ");
		pwTxt = new JTextField(15);
		pwPan = new JPanel();
		pwPan.add(pwLab);
		pwPan.add(pwTxt);

		nameLab = new JLabel("이 름 : ");
		nameTxt = new JTextField(15);
		namePan = new JPanel();
		namePan.add(nameLab);
		namePan.add(nameTxt);
		
		/*accountNameLab = new JLabel("은행이름 : ");
		accountNamePan = new JPanel();
		accountNamePan.add(accountNameLab);

		accountTypeLab = new JLabel("통장종류 : ");
		accountTypePan = new JPanel();
		accountTypePan.add(accountTypeLab);
		
		accountNoLab = new JLabel("계좌번호 : ");
		accountNoPan = new JPanel();
		accountNoPan.add(accountNoLab);

		createDateLab = new JLabel("생성일 : ");
		createDatePan = new JPanel();
		createDatePan.add(createDateLab);*/

	

		centerPan = new JPanel();
		centerPan.setLayout(new GridLayout(8, 1));
		centerPan.add(combo);
		centerPan.add(idPan);
		centerPan.add(pwPan);
		centerPan.add(namePan);
		/*centerPan.add(accountNamePan);
		centerPan.add(accountTypePan);
		centerPan.add(accountNoPan);
		centerPan.add(createDatePan);*/
		

		addBtn = new JButton("추가");
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AccountBean account = new AccountBean();
				//account.setId(idTxt.getText());
				//account.setPw(pwTxt.getText());
				//account.setName(nameTxt.getText());
				if(((String) combo.getSelectedItem()).equals(menu[0])) {
					AccountController.getInstance().createAccount(account);
				}
				else {
					//new AdminServiceImpl().createStaff(staff);
				}
			}
		});
		

		bottomPan = new JPanel();
		bottomPan.add(addBtn);
		
		add(topLab, "North");
		add(centerPan, "Center");
		add(bottomPan, "South");
	}

}
