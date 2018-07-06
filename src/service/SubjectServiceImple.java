package service;

import java.util.List;

import domain.SubjectBean;

public class SubjectServiceImple implements SubjectService{
	private static SubjectService instance = new SubjectServiceImple();
	public static SubjectService getInstance() {return instance;}
	private SubjectServiceImple() {}
	@Override
	public void createSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<SubjectBean> subjcetList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectBean> findByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SubjectBean findByID(SubjectBean id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countSubject() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifySubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}
	
}
