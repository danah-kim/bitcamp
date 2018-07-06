package service;

import java.util.List;

import domain.ProjectTeamBean;

public interface ProjectTeamService {
	public void createProjectTeam(ProjectTeamBean projectTeam);
	public List<ProjectTeamBean> projectList();
	public List<ProjectTeamBean> findByName(ProjectTeamBean projectTeam);
	public ProjectTeamBean findByID(ProjectTeamBean projectTeam);
	public int countProjectTeam();
	public void modifyProjectTeam(ProjectTeamBean projectTeam);
	public void removeProjectTeam(ProjectTeamBean projectTeam);
}
