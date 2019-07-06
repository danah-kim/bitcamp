package enums;

public enum Path {
	WEBPATH, MAIN, UPLOADPATH;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case WEBPATH :
			result = "/WEB-INF/view/";
			break;
		case MAIN :
			result = "/main.jsp";
			break;
		case UPLOADPATH :
			result = "/Users/danah/MVCWorkspace/GMS-Model2/WebContent/resources/img/upload/";
			break;
		default:
			break;
		}
		return result;
	}
}