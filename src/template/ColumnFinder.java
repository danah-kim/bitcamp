package template;

import java.lang.reflect.Field;

import domain.MemberBean;
import enums.Domain;

public class ColumnFinder {
	public static String find(Domain dom) {
		String s = "", upper = "", temp = "";
		Class<MemberBean> clazz = null;
		switch (dom) {
		case MEMBER :
			// Class<MemberBean> clazz = MemberBean.class; 과 동일!
			clazz = MemberBean.class;
			break;
		default :
			break;
		}
		Field[] f = clazz.getDeclaredFields();
		for (int i=0; i<f.length; i++) {
			upper = "";
            char[] arr = f[i].getName().toCharArray();
            for(int j = 0 ; j < arr.length ; j++ ) {
                if(String.valueOf(arr[j]).equals(String.valueOf(arr[j]).toUpperCase())) {
                    upper = f[i].getName().replaceAll(String.valueOf(arr[j]), "_"+String.valueOf(arr[j]).toLowerCase());
                }
            }
            temp = (upper.equals(""))? f[i].getName().toUpperCase() : upper.toUpperCase();
            s += (i!=(f.length-1))? temp + " , " : temp;
			/*s += (i != (f.length-1)) ? 
					(f[i].getName().equals("teamId") ?
							"TEAM_ID"
							: (f[i].getName().equals("memId") ? "MEM_ID" 
									: (f[i].getName().equals("passWord") ? "PASS_WORD" : f[i].getName().toUpperCase()))) + "," 
					: (f[i].getName().equals("teamId") ?
							"TEAM_ID"
							: (f[i].getName().equals("memId") ? "MEM_ID" 
									: (f[i].getName().equals("passWord") ? "PASS_WORD" : f[i].getName().toUpperCase())));*/
		}
		return s;
	}
}
