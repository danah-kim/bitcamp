package domain;

import lombok.Data;

@Data
public class ExamBean {
	private String examSeq, memId, subjectSeq, score, month, recordSeq;
	public static final String TEST="TEST";

	@Override
	public String toString() {
		return "시험정보 [examSeq=" + examSeq 
				+ ", 학생Id=" + memId 
				+ ", 과목Seq=" + subjectSeq 
				+ ", 과목=" + score
				+ ", 월=" + month 
				+ ", 성적Seq=" + recordSeq + "]";
	}
	
}
