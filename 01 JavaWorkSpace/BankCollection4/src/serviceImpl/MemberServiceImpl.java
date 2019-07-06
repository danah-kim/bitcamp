package serviceImpl;

import java.util.*;
import domain.*;
import repository.MemberDAO;
import repositoryImpl.MemberDAOImpl;
import service.*;

public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	
	
	@Override
	public void createUser(MemberBean member) {
		System.out.println("========== 멤버 서비스 ==========");
		System.out.println("화면에서 넘어온 객체 : " + member);
		((UserBean) member).setCreditRating("7등급");
		MemberDAOImpl.getInstance().insertMember(member);

		
	}
	
	@Override
	public String login(MemberBean member) {
		MemberBean mbr = new MemberBean();
		/*for (MemberBean e : list) {
			if (member.getUid().equals(e.getUid())) {
				mbr = e;
				break;
			}
		}*/
		return "";
	}

	@Override
	public void updatePassWord(MemberBean member) {
		String id = member.getUid();
		String oldPw = member.getPass().split("/")[0];
		String newPw = member.getPass().split("/")[1];
		/*MemberBean mem = map.get(member.getUid());
		if (mem == null) {
			System.out.println("수정하려는 ID가 없음!!");
		}
		if (oldPw.equals(mem.getPass())) {
			mem.setPass(newPw);
			map.put(id, mem);
		}*/
	}

	@Override
	public void deleteMember(MemberBean member) {
		//map.remove(member.getUid());

	}

}
