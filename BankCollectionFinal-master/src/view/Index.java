package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Index extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Index(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("관리자화면");
		this.setLayout(new GridLayout(3, 3,10,10));
		JButton btn1 = new JButton("회원가입");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Register();
			}
		});
		this.add(btn1);
		JButton btn2 = new JButton("통장생성");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OpenAccount();
			}
		});
		this.add(btn2);
		JButton btn3 = new JButton("목록보기");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(btn3);
		JButton btn4 = new JButton("ID 검색");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(btn4);
		JButton btn5 = new JButton("이름 검색");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(btn5);
		JButton btn6 = new JButton("비번 변경");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(btn6);
		JButton btn7 = new JButton("입금");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(btn7);
		JButton btn8 = new JButton("출금");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(btn8);
		JButton btn9 = new JButton("회원 탈퇴");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(btn9);
		setSize(600, 600);
		setLocation(100, 100);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Index();
	}
}