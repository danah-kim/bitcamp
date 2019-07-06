package service;

import java.util.List;

import domain.ProjectTeamBean;

public interface ProjectTeamService {
	public void createProjectTeam(ProjectTeamBean projectTeam);
	public List<ProjectTeamBean> projectList();
	public List<ProjectTeamBean> findByWord(String word);
	public ProjectTeamBean findByID(ProjectTeamBean id);
	public int countProjectTeam();
	public void modifyProjectTeam(ProjectTeamBean projectTeam);
	public void removeProjectTeam(ProjectTeamBean projectTeam);
}
