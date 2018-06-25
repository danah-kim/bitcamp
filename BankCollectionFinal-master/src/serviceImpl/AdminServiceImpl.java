package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import domain.*;
import service.*;

public class AdminServiceImpl implements AdminService{
	private static AdminService instance = new AdminServiceImpl();
	public static AdminService getInstance() {return instance;}
	private AdminServiceImpl() {};


	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		//list.add(staff);
	}

	@Override
	public List<MemberBean> listMember() {
		return null;
	}

	@Override
	public List<MemberBean> searchMemberByName(String name) {
		List<MemberBean> arr = new ArrayList<>();

		/*for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				arr.add(list.get(i));
			}
		}*/
		return arr;
	}

	@Override
	public MemberBean searchMemberById(MemberBean id) {
MemberBean temp = new MemberBean();
		
		/*for (MemberBean e : list) {
			if (member.getId().equals(e.getId())) {
				temp = e;
				break;
			}
		}*/
		return temp;
	}

	@Override
	public List<AccountBean> listAccount() {
		return null;
	}

	@Override
	public List<AccountBean> searchAccountByName(String name) {
		List<AccountBean> arr = new ArrayList<>();

		/*for (AccountBean e : list) {
			if (name.equals(e.getName())) {
				arr.add(e);
			}
		}*/
		return arr;
	}

	@Override
	public AccountBean searchAccountByID(AccountBean id) {
		AccountBean temp = new AccountBean();

		/*for (AccountBean e : list) {
			if (account.getId().equals(e.getId())) {
				temp = e;
				break;
			}
		}*/
		return temp;
	}

	@Override
	public String createAccountNo() {
		String num = "";

		for (int i = 0; i < 3; i++) {
			num += (i == 2) ? String.format("%03d", (int) (Math.random() * 999))
					: String.format("%03d", (int) (Math.random() * 999)) + "-";
		}
		return num;
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

}
