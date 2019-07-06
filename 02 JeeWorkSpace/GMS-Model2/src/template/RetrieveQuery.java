package template;

import java.sql.ResultSet;

import domain.ImageBean;
import domain.MemberBean;
import enums.ImageQuery;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "MEMBER" :
			map.put("sql", String.format(MemberQuery.RETRIEVE.toString(),
					map.get("table")));
			break;
		case "IMAGE" :
			map.put("sql", String.format(ImageQuery.RETRIEVE.toString(),
					 map.get("table")));
			break;
		default:
			break;
		}
		
	}
	@Override
	void startPlay() {
		try {
				pstmt.setString(1, (String) map.get("value"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean member = null;
			//SubjectBean subject = null;
			ImageBean image = null;
			switch (map.get("table").toString()) {
				case "MEMBER":
					while(rs.next()) {
						member = new MemberBean();
						//subject = new SubjectBean();
						member.setMemId(rs.getString("MEM_ID"));
						member.setTeamId(rs.getString("TEAM_ID"));
						member.setName(rs.getString("NAME"));
						member.setAge(rs.getString("AGE"));
						member.setRoll(rs.getString("ROLL"));
						member.setPassWord(rs.getString("PASS_WORD"));
						member.setSsn(rs.getString("SSN"));
						member.setGender(rs.getString("GENDER"));
						//member.setSubject(subject);
						//member.getSubject().setSubjectSeq(rs.getString("SUBJECT"));
					}
					o = member;
					break;
				case "IMAGE":
					while(rs.next()) {
						image = new ImageBean();
						image.setImgname(rs.getString("IMG_NAME"));
						image.setExtension(rs.getString("EXTENSION"));
					}
					o = image;
					break;
				default:
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
