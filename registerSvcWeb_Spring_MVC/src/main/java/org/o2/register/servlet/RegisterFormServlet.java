package org.o2.register.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o2.register.beans.RegisterFormBean;
import org.o2.register.util.RequestBuilder;



@WebServlet("/registerformServlet")
public class RegisterFormServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//fetch the form data and store in the formBean, use builder
		RequestBuilder builder=new RequestBuilder();
		RegisterFormBean formBean=builder.formBeanBuild(req);
		String regParamValue=req.getParameter("register").toLowerCase().trim();
		//keep the data in the session scope
		HttpSession ses = req.getSession();
		ses.setAttribute("formBean", formBean);
		if((regParamValue==null) || (!regParamValue.contains("continue")) || (!regParamValue.contains("register")) ){
			System.out.println("in null check and validste if user edit some thing in browser before sending the req");
			RequestDispatcher rd=req.getRequestDispatcher("/reg_confirm.jsp");
			rd.forward(req, resp);

		}
		if("continue".equals(regParamValue)){
		System.out.println("in continueee");
		RequestDispatcher rd=req.getRequestDispatcher("/reg_confirm.jsp");
		rd.forward(req, resp);
		}
		if("register".equals(regParamValue)){
			//write logic to call client.enroll
			System.out.println("in register form");
		}
		
	}
	
	
	
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
