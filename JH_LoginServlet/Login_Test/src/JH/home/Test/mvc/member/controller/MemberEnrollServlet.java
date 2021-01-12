package JH.home.Test.mvc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JH.home.Test.mvc.member.model.service.MemberService;
import JH.home.Test.mvc.member.model.vo.Member;

@WebServlet(name = "enroll", urlPatterns = "/member/enroll")
public class MemberEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberEnrollServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/member/enroll.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = null;
		String location = null;
		Member member = new Member();
		
		member.setTestId(request.getParameter("userId"));
		member.setTestPwd(request.getParameter("userPwd"));
		member.setTestName(request.getParameter("userName"));
		member.setPhone(request.getParameter("phone"));
		member.setAddress(request.getParameter("address"));
		
		int result = new MemberService().EnrollMember(member);
		
		if(result > 0) {
			msg = "회원가입을 성공했습니다.";
			location ="/";
		}else {
			msg = "회원가입 실패!!";
			location ="/";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", location);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}
}
