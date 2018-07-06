package dao;

import java.util.List;

import domain.ExamBean;

public class ExamDaoImpl implements ExamDao{
	private static ExamDaoImpl instance = new ExamDaoImpl();
	public static ExamDaoImpl getInstance() {return instance;}
	private ExamDaoImpl() {}
	
	@Override
	public void insertExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ExamBean> selectAllexam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> selectBySearchWord(ExamBean word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean selectBySeq(ExamBean id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
}
