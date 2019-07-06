package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateLabel {
	JLabel idLab;
	JPanel idPan;
	public void create() {
		idLab = new JLabel("ID : ", JLabel.CENTER);
		idPan = new JPanel();
		idPan.add(idLab);
	}
}
