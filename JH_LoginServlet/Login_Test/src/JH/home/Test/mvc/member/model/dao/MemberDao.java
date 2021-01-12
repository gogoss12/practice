package JH.home.Test.mvc.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JH.home.Test.mvc.common.jdbc.JDBCTemplate;
import JH.home.Test.mvc.member.model.vo.Member;

public class MemberDao {

	public MemberDao() {
	}

	public Member findMemberInfo(Connection conn, String id, String pwd) {
		
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("SELECT TEST_NO, test_guid, TEST_ID, TEST_PWD, TEST_ROLL, TEST_NAME, PHONE, ADDRESS, ENROLL_DATE, MODIFY_DATE, STATUS"
					+ "  FROM TEST WHERE TEST_ID = ? AND TEST_PWD = ? AND STATUS = 'Y'");
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member(
					rs.getInt("TEST_NO"),
					rs.getString("TEST_GUID"),
					rs.getString("TEST_ID"),
					rs.getString("TEST_PWD"),
					rs.getString("TEST_ROLL"),
					rs.getString("TEST_NAME"),
					rs.getString("PHONE"),
					rs.getString("ADDRESS"),
					rs.getString("STATUS"),
					rs.getDate("ENROLL_DATE"),
					rs.getDate("MODIFY_DATE")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);

		}
		
		return member;
	}

	public int insertMember(Connection conn, Member member) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO TEST VALUES(SEQ_UNO.NEXTVAL, SYS_GUID(), ?, ?,'ROLE_USER', ?, ?, ?, SYSDATE, SYSDATE, DEFAULT)");
			
			pstmt.setString(1, member.getTestId());
			pstmt.setString(2, member.getTestPwd());
			pstmt.setString(3, member.getTestName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
