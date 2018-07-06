package service;

import java.util.List;

import domain.ExamBean;

public interface ExamService {
	public void createExam (ExamBean exam);
	public List<ExamBean> examList();
	public List<ExamBean> findByWord(ExamBean word);
	public ExamBean findBySeq(ExamBean id);
	public int countExam();
	public void modifyExam(ExamBean exam);
	public void removeExam(ExamBean exam);
}
