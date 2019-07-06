package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.*;

import domain.*;
import service.*;

public class AdminServiceImpl implements AdminService {
	private static AdminService instance = new AdminServiceImpl();
	public static AdminService getInstance() {return instance;}
	private AdminServiceImpl() {};
	
	
	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		//System.out.println("실행결과 : " + ((list.add(staff)) ? "등록성공" : "등록실패"));
		
	}

	@Override
	public List<MemberBean> memberList() {
		return null;
	}

	@Override
	public List<MemberBean> memberNameSearch(String name) {
		List<MemberBean> temp = new ArrayList<>();
		/*for(MemberBean e : list) {
			if(name.equals(e.getName())){
				temp.add(e);
			}
		}*/
		return temp;
	}

	@Override
	public MemberBean memberIDSearch(MemberBean member) {
		MemberBean dap = new MemberBean();
		/*for(MemberBean e : list) {
			if(member.getUid().equals(e.getUid())) {
				dap = e;
				break;
			}
		}*/
		return dap;
	}

	@Override
	public List<AccountBean> accountList() {
		return null;
	}

	@Override
	public List<AccountBean> accountSearchByName(String name) {
		List<AccountBean> arr = new ArrayList<>();
		/*for(int i=0; i<list.size(); i++) {
			if(name.equals(list.get(i).getName())) {
				//arr.add(list.get(i));
			}
		}*/
		return arr;
	}

	@Override
	public AccountBean accountSearchId(AccountBean id) {
		AccountBean temp = new AccountBean();
		/*for(int i = 0; i<list.size(); i++) {
			if(id.equals(list.get(i))) {
				//temp = list.get(i);
				break;
			}
		}*/
		return temp;
	}

	public String createAccountNo() {
		String num = "";

		for (int i = 0; i < 3; i++) {
			num += (i == 2) ? String.format("%03d", (int) (Math.random() * 999))
					: String.format("%03d", (int) (Math.random() * 999)) + "-";
		}
		return num;
	}

	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

}