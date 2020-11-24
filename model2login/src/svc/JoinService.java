package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.LoginDAO;
import vo.Member;

public class JoinService {
	
		public int joinMember(Member member) {
			
			LoginDAO loginDAO = LoginDAO.getInstance();
			Connection conn = getConnection();
			loginDAO.setConnection(conn);
			int joinMember = loginDAO.insertMember(member);
			close(conn);
			return joinMember;
		}

}
