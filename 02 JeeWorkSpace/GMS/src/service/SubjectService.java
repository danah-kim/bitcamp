package service;

import java.util.List;

import domain.SubjectBean;

public interface SubjectService {
	public void createSubject(SubjectBean subject);
	public List<SubjectBean> subjcetList();
	public List<SubjectBean> findByWord(String word);
	public SubjectBean findByID(SubjectBean id);
	public int countSubject();
	public void modifySubject(SubjectBean subject);
	public void removeSubject(SubjectBean subject);
}
