package dao;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public interface ImageDao {
	public void inseart(ImageBean image);
	public List<ImageBean> selectSome(Map<?, ?> param);
	public ImageBean selectOne(String word);
	public int count();
	public void update(Map<?, ?> param);
	public void delete(ImageBean image);
}
