package dao;

import java.util.List;

import domain.*;

public interface ProjectTeamDao {
	public void insertProjectTeam (ProjectTeamBean ProjectTeam);
	public List<ProjectTeamBean> selectAllProjectTeam();
	public List<ProjectTeamBean> selectBySearchWord(ProjectTeamBean word);
	public ProjectTeamBean selectBySeq(ProjectTeamBean id);
	public int countProjectTeam();
	public void updateProjectTeam(ProjectTeamBean ProjectTeam);
	public void deleteProjectTeam(ProjectTeamBean ProjectTeam);
}
