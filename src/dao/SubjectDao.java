package dao;

import java.util.List;

import domain.*;

public interface SubjectDao {
	public void insertSubject (SubjectBean Subject);
	public List<SubjectBean> selectAllSubject();
	public List<SubjectBean> selectBySearchWord(String word);
	public SubjectBean selectByID(SubjectBean id);
	public int countSubject();
	public void updateSubject(SubjectBean Subject);
	public void deleteSubject(SubjectBean Subject);
}
