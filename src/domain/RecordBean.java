package domain;

import lombok.Data;

@Data
public class RecordBean {
	protected String recordSeq, avg, grade;

	@Override
	public String toString() {
		return "RecordBean [recordSeq=" + recordSeq + ", avg=" + avg + ", grade=" + grade + "]";
	}

	public String getRecordSeq() {
		return recordSeq;
	}

	public void setRecordSeq(String recordSeq) {
		this.recordSeq = recordSeq;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
