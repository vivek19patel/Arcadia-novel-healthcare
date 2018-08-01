package org.o2.register.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.o2.register.beans.RegisterFormBean;
import org.o2.register.beans.loginReqBean;
import org.o2.register.svc.client.RegisterServiceClient;
import org.o2.register.util.LoginValidator;
import org.o2.register.util.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("regFrm")
@RequestMapping("/wizardForm")
public class RegistrationController  {
	@Autowired
	private RegisterValidator regValidator;
	
	@Autowired
	private RegisterServiceClient svcClient;
	
	@RequestMapping(params="register_form")
	public String showForm(Map<String, Object> map){
		System.out.println("1. RegistrationController.showForm()");
		RegisterFormBean regFormBean=new RegisterFormBean();
		map.put("regFrm", regFormBean);
		return "register_form";
	}
	
	@RequestMapping(params="continue")
	public String submitForm_1(Map<String, Object> map, @ModelAttribute("regFrm") RegisterFormBean regFormBean, 
			HttpServletRequest req,BindingResult be){
		
		if(regValidator.supports(RegisterFormBean.class)){
			regValidator.validate(regFormBean, be);
			if(be.hasErrors()){
				return "register_form"; 
			}
		}
		return "reg_confirm";
	}
	
	@RequestMapping(params="_cancel")
	public String submitForm_cancel(Map<String, Object> map, @ModelAttribute("regFrm") RegisterFormBean regFormBean, 
			HttpServletRequest req,BindingResult be){
		HttpSession session=((HttpSession)req.getSession());
		session.invalidate();
		loginReqBean lognReqBean=new loginReqBean();
		map.put("lognReqBean", lognReqBean);
		
		return "login";
	}
	@RequestMapping(params="_back")
	public String submitForm_back(Map<String, Object> map, @ModelAttribute("regFrm") RegisterFormBean regFormBean, 
			HttpServletRequest req,BindingResult be){
		return "register_form";
	}
	@RequestMapping(params="_proceed")
	public String submitForm_proceed(Map<String, Object> map, @ModelAttribute("regFrm") RegisterFormBean regFormBean, 
			HttpServletRequest req,BindingResult be){
		System.out.println("RegistrationController.submitForm_proceed()");
		//here call the client method to invoke the servc layer
		return "register_form";
	}
	

}
