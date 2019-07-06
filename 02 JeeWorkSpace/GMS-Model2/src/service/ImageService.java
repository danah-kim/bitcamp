package service;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public void add(ImageBean image);
	public List<ImageBean> search(Map<?, ?> param);
	public ImageBean retrieve(String word);
	public int count();
	public void modify(Map<?, ?> param);
	public void remove(ImageBean image);
}
