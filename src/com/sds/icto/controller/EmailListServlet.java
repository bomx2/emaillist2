package com.sds.icto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.emaillist.action.ActionFactory;
import com.sds.icto.emaillist.action.FormAction;
import com.sds.icto.emaillist.action.IndexAction;
import com.sds.icto.emaillist.action.InsertAction;
import com.sds.icto.web.Action;

@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmailListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{	
			request.setCharacterEncoding( "utf-8" );
			
			String a = request.getParameter( "a" );

			ActionFactory af = ActionFactory.getInstance();	
			Action action = af.getAction( a );
			
			action.execute(request, response);	
			
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
	}

}
