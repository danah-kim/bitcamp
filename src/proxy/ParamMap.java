package proxy;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class ParamMap implements Capable{
	private String text;

	@Override
	public void carrayOut(Object o) {
		@SuppressWarnings("unchecked")
		HashMap<String,Object> map = (HashMap<String, Object>) o;
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String[] values = request.getParameterMap().get("subject");
		StringBuffer buff = new StringBuffer();
		
		for(String s : values){
			buff.append(s+",");
		}
		this.text = buff.toString().substring(0,buff.toString().length()-1);
		System.out.println(text);
	}
}
