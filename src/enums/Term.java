package enums;

public enum Term {
	WEBPATH, MAIN;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case WEBPATH :
			result = "/WEB-INF/view";
			break;
		case MAIN :
			result = "/main.jsp";
			break;
		default:
			break;
		}
		return result;
	}
}
