package JH.home.Test.mvc.member.model.service;

import java.sql.Connection;

import static JH.home.Test.mvc.common.jdbc.JDBCTemplate.*;
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

	public int EnrollMember(Member member) {
		
		Connection conn = getConnection();
		
		int result = dao.insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	
}
