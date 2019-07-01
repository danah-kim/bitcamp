package service;
import java.util.List;
import domain.*;

public interface AdminService {
	public void createStaff(StaffBean staff);
	public List<MemberBean> listMember();
	public List<MemberBean> searchMemberByName(String name);
	public MemberBean searchMemberById(MemberBean id);
	public List<AccountBean> listAccount();
	public List<AccountBean> searchAccountByName(String name);
	public AccountBean searchAccountByID(AccountBean id);
	public String createAccountNo();
	public String createDate();
}
