package service;

import java.util.List;
import java.util.Map;

import dao.ImageDaoImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService{
	private static ImageService Instance = new ImageServiceImpl();	
	public static ImageService getInstance() {return Instance;}
	private ImageServiceImpl() {}

	@Override
	public void add(ImageBean image) {
		ImageDaoImpl.getInstance().inseart(image);
	}

	@Override
	public List<ImageBean> search(Map<?, ?> param) {
		return ImageDaoImpl.getInstance().selectSome(param);
	}

	@Override
	public ImageBean retrieve(String word) {
		return ImageDaoImpl.getInstance().selectOne(word);
	}

	@Override
	public int count() {
		return ImageDaoImpl.getInstance().count();
	}

	@Override
	public void modify(Map<?, ?> param) {
		ImageDaoImpl.getInstance().update(param);
	}

	@Override
	public void remove(ImageBean image) {
		ImageDaoImpl.getInstance().delete(image);
	}
}
