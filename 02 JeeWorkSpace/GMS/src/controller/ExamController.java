package controller;

import java.util.List;

import javax.swing.JOptionPane;

import dao.SubjectDao;
import dao.SubjectDaoImpl;
import domain.*;
import service.*;

public class ExamController {
	
	public static void main(String[] args) {
		ExamBean exam = null;
		MemberBean mem = null;
		SubjectBean subject = null;
		while(true) {
			switch(String.valueOf(JOptionPane.showInputDialog("0. 종료\n 1.정보입력\n 2.점수입력"))) {
			case "0" :
				return;
			case "1" :
				exam = new ExamBean();
				mem = new MemberBean();
				String[] arr = JOptionPane.showInputDialog("이름과 월을 입력하세요. Ex.이름/월").split("/");
				exam.setMonth("7");
				exam.setMemId("저스티스4");
				
				/*exam.setMonth(arr[1]);
				List<MemberBean> list = MemberServiceImpl.getInstance().findByWord(arr[0]);
				if(list.size()==0) {
					System.out.println("해당 이름의 학생이 없음");
				}else if(list.size()==1){
					exam.setMemId(list.get(0).getMemId());
				}else {
					System.out.println("list");
				}*/
				break;
			case "2" :
				exam.setScore(JOptionPane.showInputDialog("과목 순서대로 갑을 입력하시오. JAVA / SQL / HTML5 / R / PYTHON"));
				ExamServiceImpl.getInstance().createExam(exam);
				break;
			case "3" :
				break;
				
			default :
				break;
			
			}
		}
	}	
	
}
