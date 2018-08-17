package proxy;

import java.util.HashMap;

import lombok.Data;

@Data
public class Proxy implements Capable{
	private Pagination pagination;
	private ParamMap paramMap;

	@Override
	public void carrayOut(Object o) {
		@SuppressWarnings("unchecked")
		HashMap<String,Object> map = (HashMap<String,Object>) o;
		String mission = (String)map.get("mission");
		switch (mission) {
		case "pagination":
			this.pagination= new Pagination();
			pagination.carrayOut(o);
			break;
		case "checkbox":
			this.paramMap= new ParamMap();
			paramMap.carrayOut(o);	
			break;
		default:
			break;
		}
	}
}
