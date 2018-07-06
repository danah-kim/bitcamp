package service;

import java.util.List;

import domain.ExamBean;

public class ExamServiceImpl implements ExamService{
	private static ExamServiceImpl instance = new ExamServiceImpl();
	public static ExamServiceImpl getInstance () {return instance;}
	private ExamServiceImpl() {}
	@Override
	public void createExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ExamBean> examList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> findByWord(ExamBean exam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean findBySeq(ExamBean exam) {
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
