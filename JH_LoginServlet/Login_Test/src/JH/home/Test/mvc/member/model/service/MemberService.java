package JH.home.Test.mvc.member.model.service;

import java.sql.Connection;

import static JH.home.Test.mvc.common.JDBCTemplate.*;
import JH.home.Test.mvc.member.model.dao.MemberDao;
import JH.home.Test.mvc.member.model.vo.Member;

public class MemberService {

	private MemberDao dao = new MemberDao();
	
	public Member login(String id, String pwd) {
		
		Connection conn = getConnection();
		
		Member member = dao.findMemberInfo(conn, id, pwd);
		
		close(conn);
		
		return member;
	}
	
}
