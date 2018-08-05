package command;

import javax.servlet.http.HttpServletRequest;

import enums.Term;
import lombok.Data;
@Data
public class Command implements Order{
	protected HttpServletRequest request;
	protected String action, domain, page, view;

	@Override
	public void execute() {
		this.view = Term.WEBPATH.toString() + domain + "/" + page + ".jsp";
		
	}
}
