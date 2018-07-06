package controller;

import java.lang.reflect.Member;

import javax.swing.JOptionPane;

import domain.ExamBean;
import service.*;

public class ExamController {
	
	public static void main(String[] args) {		
		while(true) {
			switch(String.valueOf(JOptionPane.showInputDialog("0. 종료\n 1.정보입력\n 2.점수입력"))) {
			case "0" :
				return;
			case "1" :
				// ExamServiceImpl.getInstance().("이름과 월을 입력하세요. Ex.이름/월");
				break;
			case "2" :
				JOptionPane.showInputDialog("과목 순서대로 갑을 입력하시오. 자바/SQL/HTML5/R/PYTHON");
				break;
			default :
				break;
			
			}
		}
	}	
	
}
