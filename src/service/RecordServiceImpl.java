package service;

import java.util.List;

import domain.RecordBean;

public class RecordServiceImpl implements RecordService{
	private static RecordServiceImpl instance = new RecordServiceImpl();
	public static RecordServiceImpl getInstance() {return instance;}
	private RecordServiceImpl() {}
	@Override
	public void createRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<RecordBean> recordList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RecordBean> findByWord(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RecordBean findByRecord(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countRecord() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	
	
}
