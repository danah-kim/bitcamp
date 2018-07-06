package dao;

import java.util.List;

import domain.ProjectTeamBean;

public class ProjectTeamDaoImple implements ProjectTeamDao{
	private static ProjectTeamDaoImple instance = new ProjectTeamDaoImple();
	public static ProjectTeamDaoImple getInstance () {return instance;}
	private ProjectTeamDaoImple() {}
	@Override
	public void insertProjectTeam(ProjectTeamBean ProjectTeam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ProjectTeamBean> selectAllProjectTeam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProjectTeamBean> selectBySearchWord(ProjectTeamBean word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProjectTeamBean selectBySeq(ProjectTeamBean id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countProjectTeam() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateProjectTeam(ProjectTeamBean ProjectTeam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteProjectTeam(ProjectTeamBean ProjectTeam) {
		// TODO Auto-generated method stub
		
	}
	
	
}
