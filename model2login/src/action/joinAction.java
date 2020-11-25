package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.JoinService;
import svc.LoginService;
import vo.ActionForward;
import vo.Member;


public class joinAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		Member member = new Member();
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		int age = Integer.parseInt(request.getParameter("age"));
		String nation = request.getParameter("nation");
		String gender = request.getParameter("gender");
	    String email = request.getParameter("email");
	    member.setAddr(addr);
	    member.setAge(age);
	    member.setEmail(email);
	    member.setGender(gender);
	    member.setId(id);
	    member.setName(name);
	    member.setNation(nation);
	    member.setPasswd(passwd);
	    JoinService joinService = new JoinService();
		int joinMember = joinService.joinMember(member);
		
		if(joinMember > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", member);
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.do");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인실패');history.back();</script>");
		}
		
		return forward;
	}

}
