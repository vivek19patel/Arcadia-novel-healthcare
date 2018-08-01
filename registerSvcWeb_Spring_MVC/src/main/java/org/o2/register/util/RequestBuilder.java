package org.o2.register.util;

import javax.servlet.http.HttpServletRequest;

import org.o2.login.verification.dao.beans.LoginRegSvcDAOReq;
import org.o2.register.beans.RegisterFormBean;
import org.o2.register.beans.loginReqBean;
import org.o2.register.svc.client.beans.RegisterSvcLoginReq;
import org.springframework.stereotype.Component;

@Component
public class RequestBuilder {
	public RegisterSvcLoginReq clientloginReqBuilder( loginReqBean loginBean){
		
		RegisterSvcLoginReq loginReq= new RegisterSvcLoginReq();
		loginReq.setAccNo(loginBean.getAccNo());
		loginReq.setMobNo("".valueOf(loginBean.getMobNo()));
		loginReq.setPwd(loginBean.getPwd());
		return loginReq;
		
	}
	
	public loginReqBean loginReqBeanBuild(HttpServletRequest req){
		loginReqBean loginBean=new loginReqBean();
		loginBean.setAccNo(req.getParameter("accNo"));
		loginBean.setMobNo(Long.parseLong(req.getParameter("mobNo")));
		loginBean.setPwd(req.getParameter("pwd"));
		return loginBean;
		
	}
	
	public RegisterFormBean formBeanBuild(HttpServletRequest req){
		
		RegisterFormBean formBean=new RegisterFormBean();
		//to do.. apply validator
		formBean.setCardNum(req.getParameter("cardNum"));
		formBean.setCvv(req.getParameter("cvv"));
		formBean.setNameOnCard(req.getParameter("nameOnCard"));
		formBean.setExpDate(req.getParameter("expDate"));
		formBean.setMobNum(req.getParameter("mobNum"));
		return formBean;
	}
	
	//to build the dao.loginCheck(LoginRegSvcDAOReq loginReq)
	public LoginRegSvcDAOReq loginReqDaoBuilder(loginReqBean lognReqBean){
		LoginRegSvcDAOReq loginDaoReq=new LoginRegSvcDAOReq();
		loginDaoReq.setAccntNo(lognReqBean.getAccNo());
		loginDaoReq.setPassword(lognReqBean.getPwd());
		loginDaoReq.setMobileNo(lognReqBean.getMobNo());
		return loginDaoReq;
	}

}
