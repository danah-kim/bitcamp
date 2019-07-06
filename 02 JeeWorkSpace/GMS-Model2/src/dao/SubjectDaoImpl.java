package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectDaoImpl implements SubjectDao{
	private static SubjectDao instance = new SubjectDaoImpl();
	public static SubjectDao getInstance() {return instance;}
	private SubjectDaoImpl () {}
	@Override
	public void insertSubject(SubjectBean Subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<SubjectBean> selectAllSubject() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectBean> selectBySearchWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SubjectBean selectByID(SubjectBean id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countSubject() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateSubject(SubjectBean Subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteSubject(SubjectBean Subject) {
		// TODO Auto-generated method stub
		
	};
	
}
