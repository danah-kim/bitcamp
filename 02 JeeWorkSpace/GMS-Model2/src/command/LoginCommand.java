package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		if(action.equals("login")) {
			MemberBean member = new MemberBean();
			ImageBean image = new ImageBean();
			member.setMemId(request.getParameter("userId"));
			member.setPassWord(request.getParameter("passWord"));
			if(MemberServiceImpl.getInstance().login(member)) {
				request.setAttribute("match", "TRUE");
				request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retrieve(member.getMemId()));
				image = ImageServiceImpl.getInstance().retrieve((member.getMemId()));
				request.getSession().setAttribute("profile", (image==null)? null :"upload/"+image.getImgname()+"."+image.getExtension());
			}else {
				request.setAttribute("match", "FALSE");
			}
		}else {
			request.getSession().invalidate();
		}
		super.execute();
	}
}