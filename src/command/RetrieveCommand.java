package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {
	
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
			MemberBean member = new MemberBean();
			member = MemberServiceImpl.getInstance().retrieve(request.getParameter("condition"));
			request.setAttribute("user", member);
			ImageBean image = new ImageBean();
			image = ImageServiceImpl.getInstance().retrieve((member.getMemId()));
			request.getSession().setAttribute("profile", (image==null)? null :"upload/"+image.getImgname()+"."+image.getExtension());
			break;
		case ADMIN :
			break;
		default:
			break;
		}
		super.execute();
	}
}