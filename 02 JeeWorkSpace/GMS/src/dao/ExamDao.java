package dao;

import java.util.List;

import domain.ExamBean;

public interface ExamDao {
	public void insertExam (ExamBean exam);
	public List<ExamBean> selectAllexam();
	public List<ExamBean> selectBySearchWord(ExamBean word);
	public ExamBean selectBySeq(ExamBean id);
	public int countExam();
	public void updateExam(ExamBean exam);
	public void deleteExam(ExamBean exam);
}
