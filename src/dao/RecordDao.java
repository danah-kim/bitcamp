package dao;

import java.util.List;

import domain.*;

public interface RecordDao {
	public void insertRecord (RecordBean Record);
	public List<RecordBean> selectAllRecord();
	public List<RecordBean> selectBySearchWord(RecordBean word);
	public RecordBean selectBySeq(RecordBean id);
	public int countRecord();
	public void updateRecord(RecordBean Record);
	public void deleteRecord(RecordBean Record);
}
