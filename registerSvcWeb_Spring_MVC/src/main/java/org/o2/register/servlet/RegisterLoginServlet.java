package org.o2.register.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o2.register.beans.loginReqBean;
import org.o2.register.beans.loginResBean;
import org.o2.register.svc.client.RegisterServiceClient;
import org.o2.register.svc.client.beans.RegisterSvcLoginReq;
import org.o2.register.svc.client.beans.RegisterSvcLoginRes;
import org.o2.register.svc.client.impl.RegisterServiceClientImpl;
import org.o2.register.util.RequestBuilder;



@WebServlet("/loginServlet")
public class RegisterLoginServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestBuilder reqBuilder=new RequestBuilder();
		RequestDispatcher rd=null;
		//get the login formdata, and save to the loginReq bean
		loginReqBean loginBean=reqBuilder.loginReqBeanBuild(req);
		
		
		//with this login details , invoke the client method, tht is going to invoke the login api.
		//use RegisterServiceClient obj to call verifyLogin() method also make the RegisterSvcLoginReq
		RegisterServiceClient client=new RegisterServiceClientImpl();
		
		RegisterSvcLoginReq clientLoginReq = reqBuilder.clientloginReqBuilder(loginBean);
		RegisterSvcLoginRes clientLoginRes = client.verifyLogin(clientLoginReq);
		//if clientLoginresp code  is 000 then move to register page. else show the login fail
		//as per now create the clientresp
		
		if("0000".equals(clientLoginRes.getRespCode())){
			req.setAttribute("accNo", loginBean.getAccNo());
			rd=req.getRequestDispatcher("/home.jsp");
			rd.forward(req, resp);			
		}
		else{
			loginResBean loginBeanResp=new loginResBean();
			req.setAttribute("loginRespFail", clientLoginRes.getRespmsg());
			System.out.println("loginRespFail  "+clientLoginRes.getRespmsg() );
			rd=req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
		
	}
	
	
	
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
