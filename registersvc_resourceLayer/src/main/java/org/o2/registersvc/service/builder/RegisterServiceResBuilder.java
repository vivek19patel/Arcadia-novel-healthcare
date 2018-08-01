package org.o2.registersvc.service.builder;

import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.schema.res.CreditCheckType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;
import org.springframework.stereotype.Component;
@Component
public class RegisterServiceResBuilder {
	
	public RegisterServiceResType buildProcessResp(RegisterSvcProcessVBRes vbResp){
		// Prepare the service layer wsResp from process layer vbResp
				StatusBlockType stBlock=new StatusBlockType();
				stBlock.setRespCode(vbResp.getRespCode());
				stBlock.setRespMsg(vbResp.getRespMsg());
				CreditCheckType creidtCheck=new CreditCheckType();
				creidtCheck.setCreditstatus(vbResp.getCreditstatus());
				creidtCheck.setRateofper(vbResp.getRateofper());
				
				

				RegisterServiceResType wsResp = new RegisterServiceResType();
				wsResp.setCreditCheck(creidtCheck);
				wsResp.setStatusBlock(stBlock);
		
		
		return wsResp;
		
	}

}
