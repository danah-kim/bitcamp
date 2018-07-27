package command;

import javax.servlet.http.HttpServletRequest;

// checkBox 가져오는 utill
public class ParamMap {
	public static String getValues(HttpServletRequest request, String name) {
		String[] values = request.getParameterMap().get(name);
		StringBuffer buff = new StringBuffer();
		for(String s : values) {
			buff.append(s+",");
		}
		return buff.toString().substring(0,buff.toString().length()-1);
	}
}
