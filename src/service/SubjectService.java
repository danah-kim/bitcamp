package service;

import java.util.List;

import domain.SubjectBean;

public interface SubjectService {
	public void createSubject(SubjectBean subject);
	public List<SubjectBean> subjcetList();
	public List<SubjectBean> findByWord(SubjectBean subject);
	public SubjectBean findBySubject(SubjectBean subject);
	public int countSubject();
	public void modifySubject(SubjectBean subject);
	public void removeSubject(SubjectBean subject);
}
