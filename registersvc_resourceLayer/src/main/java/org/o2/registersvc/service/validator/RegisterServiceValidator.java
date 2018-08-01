package org.o2.registersvc.service.validator;

import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.service.util.RegisterSvcReqInvalidException;
import org.springframework.stereotype.Component;

@Component
public class RegisterServiceValidator {
	
	public void validateWsReq(RegisterServiceReqType wsReq) throws RegisterSvcReqInvalidException{
		//checking the given objs are null or not
		if(wsReq==null || wsReq.getClientDetails() == null || wsReq.getCardDetails() == null ||
				          wsReq.getAccountDetails() == null || wsReq.getServiceDetails() == null){
			throw new RegisterSvcReqInvalidException("reg001","Req Obj must not null");
		}
		
		
		//now validate the elements of each obj 	//validating ClientDetailsType class elements
		//getting obj of ClientDetailsType
		
		
		if(wsReq.getClientDetails().getClientId() == null || " ".equals(wsReq.getClientDetails().getClientId()) ){
			throw new RegisterSvcReqInvalidException("reg002","ClientID should not empty");
		}
		
		if(wsReq.getClientDetails().getChannelId() == null || " ".equals(wsReq.getClientDetails().getChannelId()) ){
			throw new RegisterSvcReqInvalidException("reg003","ChannelId should not empty");
		}
		
		if(wsReq.getClientDetails().getReqId() == null || " ".equals(wsReq.getClientDetails().getReqId()) ){
			throw new RegisterSvcReqInvalidException("reg004","ReqId should not empty");
		}
		
		//valiation CardDetailsType class properties
		
		if(wsReq.getCardDetails().getCardNum() == null || " ".equals(wsReq.getCardDetails().getCardNum()) ){
			throw new RegisterSvcReqInvalidException("reg005","CardNo should not empty");
		}
		if(wsReq.getCardDetails().getCvv() == null || " ".equals(wsReq.getCardDetails().getCvv()) ){
			throw new RegisterSvcReqInvalidException("reg006","CVV should not empty");
		}
		if(wsReq.getCardDetails().getExpDate() == null || " ".equals(wsReq.getCardDetails().getExpDate()) ){
			throw new RegisterSvcReqInvalidException("reg007","ExpDate should not empty");
		}
		if(wsReq.getCardDetails().getNameOnCard() == null || " ".equals(wsReq.getCardDetails().getNameOnCard()) ){
			throw new RegisterSvcReqInvalidException("reg008","NameOnCard should not empty");
		}
		//validate AccountDetailsTypes
		
		if(wsReq.getAccountDetails().getAccountNum() == null || " ".equals(wsReq.getAccountDetails().getAccountNum())){
			
			throw new RegisterSvcReqInvalidException("reg009","Accnt No should not empty");
		}
		if( wsReq.getAccountDetails().getMobileNum() == 0 ){
			throw new RegisterSvcReqInvalidException("reg010","MObile No should not empty");
		}
		
		if(Long.toString( wsReq.getAccountDetails().getMobileNum()).length()<10 || Long.toString( wsReq.getAccountDetails().getMobileNum()).length()>10){
			throw new RegisterSvcReqInvalidException("reg010","Mobile No should not less than 10 digit");
		}
		
		//Validate the ServiceDetailsType
		if(wsReq.getServiceDetails().getServiceName() == null || " ".equals(wsReq.getServiceDetails().getServiceName()) ){
			throw new RegisterSvcReqInvalidException("reg011","Service Name should not empty");
		}
		if(wsReq.getServiceDetails().getApiname() == null || " ".equals(wsReq.getServiceDetails().getApiname()) ){
			throw new RegisterSvcReqInvalidException("reg012","API Name should not empty");
		}
		if(wsReq.getServiceDetails().getVersion() == null || " ".equals(wsReq.getServiceDetails().getVersion()) ){
			throw new RegisterSvcReqInvalidException("reg013","Version  should not empty");
		}
		
	}
	

}
