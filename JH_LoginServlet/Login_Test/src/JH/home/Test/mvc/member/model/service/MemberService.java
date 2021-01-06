package JH.home.Test.mvc.member.model.service;

import java.sql.Connection;

import JH.home.Test.mvc.member.model.dao.MemberDao;
import JH.home.Test.mvc.member.model.vo.Member;

public class MemberService {

	private MemberDao dao = new MemberDao();
	
	public Member login(String id, String pwd) {
		
		Connection conn = new getConnection();
		
		Member member = dao.findMemberInfo(conn, id, pwd);
		
		
		
		return member;
	}
	
}
