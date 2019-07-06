package view;

import java.awt.GridLayout;

import javax.swing.*;

public class CreateComboBox {
	JPanel centerPan;
	JComboBox<?> combo;
	String[] menu = { "사용자 등록", "직원 추가" };

	public void create() {
		centerPan = new JPanel();
		combo = new JComboBox<>(menu);
		centerPan.add(combo);
	}
}
