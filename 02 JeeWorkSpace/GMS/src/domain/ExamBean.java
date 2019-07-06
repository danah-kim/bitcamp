package domain;

public class ExamBean {
	protected String examSeq, memId, subjectSeq, score, month, recordSeq;

	public String getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(String examSeq) {
		this.examSeq = examSeq;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getSubjectSeq() {
		return subjectSeq;
	}

	public void setSubjectSeq(String subjectSeq) {
		this.subjectSeq = subjectSeq;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getRecordSeq() {
		return recordSeq;
	}

	public void setRecordSeq(String recordSeq) {
		this.recordSeq = recordSeq;
	}

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
