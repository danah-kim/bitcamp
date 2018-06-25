package repository;
import domain.*;
import java.util.List;

public interface MemberDAO {
	public void insertMember(MemberBean member);
	public List<MemberBean> selectMemberList();
	public List<MemberBean> selectMemberByName(String name);
	public MemberBean selsectMemberByID(String id);
	public MemberBean login(MemberBean member);
	public int countMembers();
	public String updateMember(MemberBean member);
	public String deleteMember(MemberBean member);
}
