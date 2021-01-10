package JH.home.Test.mvc.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JH.home.Test.mvc.member.model.service.MemberService;
import JH.home.Test.mvc.member.model.vo.Member;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginServlet() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");		
		Member member = null;
		System.out.println("userId : " + userId + ", userPwd : " + userPwd);
		member = new MemberService().login(userId, userPwd);
		System.out.println(member);
		
		if(member != null) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginMember", member);
			request.setAttribute("msg", "로그인성공!");
			
			response.sendRedirect(request.getContextPath() + "/");
		}else {
			request.setAttribute("msg", "아이디 비밀번호 틀림");
			request.setAttribute("location", "/");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/common/msg.jsp");
			
			dispatcher.forward(request, response);
		}
		
	}
}
