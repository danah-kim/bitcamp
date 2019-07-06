package command;

import javax.servlet.http.HttpServletRequest;

import enums.Path;
import lombok.Data;
@Data
public class Command implements Order{
	protected HttpServletRequest request;
	protected String action, domain, view;

	@Override
	public void execute() {
		this.view = Path.WEBPATH.toString() + domain + "/main.jsp";
	}
}
