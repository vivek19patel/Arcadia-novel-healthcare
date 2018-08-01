package org.o2.registersvc.service.builder;

import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.springframework.stereotype.Component;
@Component
public class RegisterServiceReqBuilder {
	
	public RegisterSvcProcessVBReq buildProcessReq(RegisterServiceReqType wsReq){
		
		RegisterSvcProcessVBReq processReq = new RegisterSvcProcessVBReq();
		// insert data coming from the clien(wsReq) (ClientId,ChannelId) into
		// the RegisterSvcProcessVBReq(req)

		processReq.setClientId(wsReq.getClientDetails().getClientId());
		processReq.setChannelId(wsReq.getClientDetails().getChannelId());

		// from CardDetailsType (xsdwsdl) cardNum,cvv,expDate,nameOnCard;
		processReq.setCardNum(wsReq.getCardDetails().getCardNum());
		processReq.setCvv(wsReq.getCardDetails().getCvv());
		processReq.setExpDate(wsReq.getCardDetails().getExpDate());
		processReq.setNameOnCard(wsReq.getCardDetails().getNameOnCard());

		// from AccountDetailsType (xsdwsdl) accountNum, mobileNum;
		processReq.setAccountNum(wsReq.getAccountDetails().getAccountNum());
		processReq.setMobileNum(wsReq.getAccountDetails().getMobileNum());
		return processReq;
		
	}

}
