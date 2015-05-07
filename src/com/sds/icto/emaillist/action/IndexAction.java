package com.sds.icto.emaillist.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.emaillist.dao.EmailListDAO;
import com.sds.icto.emaillist.vo.EmailListVO;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, ClassNotFoundException, ServletException, IOException {
		try {
			EmailListDAO dao = new EmailListDAO();
			List<EmailListVO> list = dao.fetchList();
			request.setAttribute( "list", list );
			WebUtil.forward( "/view/show_emaillist.jsp", request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
