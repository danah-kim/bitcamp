package serviceImpl;

import java.util.*;

import domain.*;
import service.*;

public class MemberServiceImpl implements MemberService {
	private Map<String, MemberBean> map; // interface

	public MemberServiceImpl() {
		map = new HashMap<>(); // class
	}

	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		map.put(user.getUid(), user);

	}

	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		map.put(staff.getUid(), staff);
	}

	@Override
	public Map<String, MemberBean> list() {
		return map;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp = new ArrayList<>();
		Set<MemberBean> set = new HashSet<>();
		for(Map.Entry<String, MemberBean> e : map.entrySet()) {
			if(name.equals(e.getValue().getName())) {
				set.add(e.getValue());	
			}
		}
		Iterator<MemberBean> it = set.iterator();
		while(it.hasNext()) {
			temp.add(it.next());
		}
		return temp;
	}

	@Override
	public MemberBean findById(MemberBean member) {
		System.out.println("찾는 아이디에 해당하는 이름 :" + map.get(member.getUid()));
		return map.get(member.getUid());
	}

	@Override
	public void updatePassWord(MemberBean member) {
		String id = member.getUid();
		String oldPw = member.getPass().split("/")[0];
		String newPw = member.getPass().split("/")[1];
		MemberBean mem = map.get(member.getUid());
		if (mem == null) {
			System.out.println("수정하려는 ID가 없음!!");
		}
		if (oldPw.equals(mem.getPass())) {
			mem.setPass(newPw);
			map.put(id, mem);
		}
	}

	@Override
	public void deleteMember(MemberBean member) {
		map.remove(member.getUid());

	}

}
