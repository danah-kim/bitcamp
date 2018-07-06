package service;

import java.util.List;

import domain.RecordBean;

public interface RecordService {
	public void createRecord(RecordBean record);
	public List<RecordBean> recordList();
	public List<RecordBean> findByWord(RecordBean record);
	public RecordBean findByRecord(RecordBean record);
	public int countRecord();
	public void modifyRecord(RecordBean record);
	public void removeRecord(RecordBean record);
}
