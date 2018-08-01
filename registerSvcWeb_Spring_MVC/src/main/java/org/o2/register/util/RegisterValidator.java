package org.o2.register.util;

import org.o2.register.beans.RegisterFormBean;
import org.o2.register.beans.loginReqBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> claz) {
		
		return claz.isAssignableFrom(RegisterFormBean.class);
	}

	@Override
	public void validate(Object cmd, Errors err) {
		// write the code to validate the request fields
		//typecast cmd to loginReqBean
		RegisterFormBean regForm=(RegisterFormBean)cmd;
		if(regForm.getCardNum()==null || "".equals(regForm.getCardNum().trim()))
				err.rejectValue("cardNum", "cardNum.required");
		
		if(regForm.getCvv()==null || "".equals(regForm.getCvv().trim()))
			err.rejectValue("cvv", "cvv.required");
		
		if(regForm.getNameOnCard()==null || "".equals(regForm.getNameOnCard().trim()))
			err.rejectValue("nameOnCard", "nameOnCard.required");
		
		if(regForm.getExpDate()==null || "".equals(regForm.getExpDate().trim()))
			err.rejectValue("expDate", "expDate.required");
		
		if(regForm.getMobNum()==null || "".equals(regForm.getCvv().trim()))
			err.rejectValue("mobNum", "mobNum.required");
		
		if(regForm.getMobNum()!=null){
			if( "".valueOf(regForm.getMobNum()).trim().length()!=10)
				err.rejectValue("mobNum", "mobNum_length");
		}
		

	}

}
