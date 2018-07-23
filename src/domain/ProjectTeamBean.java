package domain;

import lombok.Data;

@Data
public class ProjectTeamBean {
	protected String teamId, teamName;

	@Override
	public String toString() {
		return "ProjectTeamBean [teamId=" + teamId + ", teamName=" + teamName + "]";
	}

}
