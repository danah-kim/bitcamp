package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.ImageBean;
import enums.Domain;
import template.CountQuery;
import template.DeleteQuery;
import template.InsertQuery;
import template.QueryTemplate;
import template.RetrieveQuery;
import template.SearchQuery;
import template.UpdateQuery;

public class ImageDaoImpl implements ImageDao{
	private static ImageDao instance = new ImageDaoImpl();
	public static ImageDao getInstance() {return instance;}
	private ImageDaoImpl() {}
	private QueryTemplate query = null;
	
	@Override
	public void inseart(ImageBean image) {
		System.out.println("IMAGE DAO IMPLE");
		query = new InsertQuery();
		HashMap<String, Object> param = new HashMap<>();
		String[] arr1 = {"table", "imgname", "extension", "memId"};
		String[] arr2 = {Domain.IMAGE.toString(), (String) image.getImgname(),
							(String) image.getExtension(), (String)image.getMemId()};
		for(int i=0; i<arr1.length; i ++) {
			param.put(arr1[i], arr2[i]);
		}
		query.play(param);
	}
	@Override
	public List<ImageBean> selectSome(Map<?, ?> param) {
		HashMap<String, Object> map = new HashMap<>();
		List<ImageBean> list = new ArrayList<>();
		String[] arr1 = {"table", "column", "startRow", "endRow"};
		String[] arr2 = {Domain.IMAGE.toString(), (String) param.get("column"),
							(String) param.get("value"), String.valueOf(param.get("startRow")),
							String.valueOf(param.get("endRow"))
						};
		for(int i = 0; i < arr1.length; i++){
			map.put(arr1[i],arr2[i]);
		}
		query= new SearchQuery();
		query.play(map);
		for(Object e: query.getList()) {
			list.add((ImageBean)e);
		}
		return list;
	}
	@Override
	public ImageBean selectOne(String word) {
		ImageBean image = new ImageBean();
		query = new RetrieveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE);
		map.put("value", word);
		query.play(map);
		image = (ImageBean) query.getO();
		return image;
	}
	@Override
	public int count() {
		int count = 0;
		query = new CountQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE);
		query.play(map);
		count = query.getNum();
		return count;
	}
	@Override
	public void update(Map<?, ?> param) {
		query = new UpdateQuery();
		HashMap<String, Object> map = new HashMap<>();
		String[] arr1 = {"table", "imgName", "imgExtension", "memId"};
		String[] arr2 = {Domain.IMAGE.toString(),
							(String) param.get("imgName"),
							(String) param.get("imgExtension"),
							(String) param.get("memId")};
		for(int i = 0; i < arr1.length; i++){
			map.put(arr1[i],arr2[i]);
		}
		query.play(map);
	}
	@Override
	public void delete(ImageBean image) {
		query = new DeleteQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE.toString());
		map.put("memId", image.getMemId());
		query.play(map);
	}
	
}
