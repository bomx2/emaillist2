package com.sds.icto.emaillist.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.emaillist.dao.EmailListDAO;
import com.sds.icto.emaillist.vo.EmailListVO;
import com.sds.icto.web.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		// 이메일을 등록합니다.
		String firstName = request.getParameter("fn");
		String lastName = request.getParameter("ln");
		String email = request.getParameter("email");

		EmailListVO vo = new EmailListVO();
		vo.setFirstname(firstName);
		vo.setLastname(lastName);
		vo.setEmail(email);

		EmailListDAO dao = new EmailListDAO();
		dao.insert(vo);

		response.sendRedirect("/EmailList2/el");
	}

}
