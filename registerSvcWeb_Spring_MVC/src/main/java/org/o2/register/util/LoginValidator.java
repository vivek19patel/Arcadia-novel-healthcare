package org.o2.register.util;

import org.o2.register.beans.loginReqBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> claz) {
		
		return claz.isAssignableFrom(loginReqBean.class);
	}

	@Override
	public void validate(Object cmd, Errors err) {
		// write the code to validate the request fields
		//typecast cmd to loginReqBean
		loginReqBean loginBean=(loginReqBean)cmd;
		if( loginBean.getAccNo()==null|| "".equals(loginBean.getAccNo().trim()))
				err.rejectValue("accNo", "accNo_required");
		
		if( loginBean.getMobNo()==null|| "".equals(loginBean.getMobNo()) )
			err.rejectValue("mobNo", "mobNo_required");
		if(loginBean.getMobNo()!=null){
			if( "".valueOf(loginBean.getMobNo()).trim().length()!=10)
				err.rejectValue("mobNo", "mobNo_length");
		}
		

	}

}
