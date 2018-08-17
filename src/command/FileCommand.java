package command;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import domain.ImageBean;
import domain.MemberBean;
import enums.Path;
import service.ImageServiceImpl;

public class FileCommand extends Command{
	
	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("=====[1]=====");
		if(!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("업로드파일이 없습니다.");
			return;
		}
		System.out.println("=====[2]=====업로드파일이존재");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax (1024 * 1024 * 40); // 40MB
		upload.setSizeMax(1024 * 1024 * 50); // 50MB
		List<FileItem> items = null;
		try {
			System.out.println("=====[3]====try내부로진입");
			File file = null;
			items = upload.parseRequest(new ServletRequestContext(request));
			System.out.println("=====[4]====items생성 ");
			Iterator<FileItem> iter = items.iterator();				
			while (iter.hasNext()) {
				System.out.println("=====[5]===while 진입");
				FileItem item = (FileItem)iter.next();
				if(!item.isFormField()) {
					System.out.println("=====[6]===if 진입");
					String fileName = item.getName();
					file = new File(Path.UPLOADPATH+fileName);
					item.write(file);
					System.out.println("=====[7]===파일업로드 성공");
					ImageBean image = new ImageBean();
					image.setImgname(fileName.substring(0, fileName.indexOf(".")));
					image.setExtension(fileName.substring(fileName.lastIndexOf('.')+1, fileName.length()));
					image.setMemId(((MemberBean) request.getSession().getAttribute("user")).getMemId());
					System.out.println(image.getImgname()+"//"+image.getExtension()+"//"+image.getMemId());
					ImageServiceImpl.getInstance().add(image);
					System.out.println("성공적입니다!!! 디비확인하세요!!!");
					System.out.println(image.getImgname()+"."+image.getExtension());
					request.getSession().setAttribute("profile", "upload/"+fileName);
					System.out.println("주소확인해볼까요?"+request.getSession().getAttribute("img")+"/"
										+request.getSession().getAttribute("profile"));
					System.out.println("적용되었나요?!?!");
					
				}else {
					System.out.println("=====[8]===파일업로드 실패");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=====[10]=====");
	}
}
