package domain;

import lombok.Data;

@Data
public class SubjectBean {
	protected String subjectSeq, subName;

	@Override
	public String toString() {
		return "SubjectBean [subjectSeq=" + subjectSeq + ", subName=" + subName + "]";
	}
}
