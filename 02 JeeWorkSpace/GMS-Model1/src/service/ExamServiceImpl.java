package service;


import java.util.List;

import dao.*;
import domain.ExamBean;
import domain.RecordBean;


public class ExamServiceImpl implements ExamService{
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance () {return instance;}
	private ExamServiceImpl() {}
	@Override
	public void createExam(ExamBean exam) {
		System.out.println(exam);
		String[] score = exam.getScore().split("/");
		String[] subName = {"JAVA","SQL","HTML5","R","PYTHON"};
		String[] basic = {exam.getMemId(),exam.getMonth()};

		// RECODE TABLE INSERT
		ExamDaoImpl.getInstance().insertExam(exam);
		RecordBean rec = new RecordBean();
		rec.setAvg("");
		rec.setGrade("");
		RecordDaoImpl.getInstance().insertRecord(rec);
		
		exam = null;
		for(int i=0; i<5; i++) {
			// EXAM SEQ = null
			exam = new ExamBean();
			// SUBJECT SEQ
			exam.setSubjectSeq(SubjectDaoImpl.getInstance().
				selectBySearchWord(subName[i]).
				get(0).getSubjectSeq());
			//RECORD SEQ
			exam.setRecordSeq(RecordDaoImpl.getInstance().selectFistRowNum());
			// MEM_ID
			exam.setMemId(basic[0]);
			// MONTH
			exam.setMonth(basic[1]);
			// SCORE
			exam.setScore(score[i]);
			// DAO 입력
			ExamDaoImpl.getInstance().insertExam(exam);		
		}

	}
	@Override
	public List<ExamBean> examList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> findByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean findByID(ExamBean id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
}
