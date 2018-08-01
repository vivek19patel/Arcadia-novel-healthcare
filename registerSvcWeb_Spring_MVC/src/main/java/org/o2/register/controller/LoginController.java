package org.o2.register.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.o2.login.verification.dao.beans.LoginRegSvcDAORes;
import org.o2.login.verification.dao.impl.LoginRegSvcDaoImpl;
import org.o2.register.beans.loginReqBean;
import org.o2.register.util.LoginValidator;
import org.o2.register.util.RequestBuilder;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	/*@Autowired
	private LoginRegSvcDaoImpl loginDaoImpl;
	*/
	@Autowired
	private LoginValidator validator;
	
	@Autowired
	private RequestBuilder reqBuilder;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginFormView(Map<String, Object> map){
		System.out.println("1. LoginController.loginFormView()");
		loginReqBean lognReqBean=new loginReqBean();
		map.put("lognReqBean", lognReqBean);
		return "login";
	}
	
	@RequestMapping(value="/loginForm", method=RequestMethod.POST)
	public String loginVerification(Map<String, Object> map, @ModelAttribute("lognReqBean") loginReqBean lognReqBean, 
										HttpServletRequest req,BindingResult be){
		System.out.println("2. LoginController.loginVerification()"+lognReqBean);
		
		if(validator.supports(loginReqBean.class)){
			validator.validate(lognReqBean, be);
			if(be.hasErrors()){
				return "login"; 
			}
		}
		//goto dao layer to call auth
		//1. use builder class to build the daologinReq
		try {
			LoginRegSvcDaoImpl loginDaoImpl=new LoginRegSvcDaoImpl(new JdbcTemplate());
			LoginRegSvcDAORes loginRegSvcDaoRes=loginDaoImpl.loginCheck(reqBuilder.loginReqDaoBuilder(lognReqBean));
			return "home";
		} catch (BusinessException e) {
			be.rejectValue("accNo", "accNo_invalid");
			be.rejectValue("mobNo", "mobNo_invalid");
			//be.rejectValue("pwd", "mobNo_invalid");
			return "login";
		} catch (Exception e) {
			return "error";
		}
	}

}
