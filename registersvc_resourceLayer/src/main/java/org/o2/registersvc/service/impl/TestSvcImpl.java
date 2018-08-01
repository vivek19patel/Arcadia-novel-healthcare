package org.o2.registersvc.service.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.o2.registersvc.schema.req.RegisterSvcReqBean;

public class TestSvcImpl {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		RegisterServiceImpl svcImpl=new RegisterServiceImpl();
		//svcImpl.checkDI();
		RegisterSvcReqBean_Json();

	}
	
	public static void RegisterSvcReqBean_Json() throws JsonGenerationException, JsonMappingException, IOException{
		RegisterSvcReqBean myReqBean=new RegisterSvcReqBean();
		myReqBean.setAccountNum("accnt no");
		myReqBean.setApiname("apiname");
		myReqBean.setCardNum("cardno");
		myReqBean.setChannelId("chanelId");
		myReqBean.setClientId("clint Id");
		myReqBean.setCvv("cvv");
		myReqBean.setExpDate("expDate");
		myReqBean.setMobileNum(8750722329l);
		myReqBean.setNameOnCard("ABhYA");
		myReqBean.setReqId("reqId");
		myReqBean.setServiceName("Svc Name");
		myReqBean.setVersion("version id");
		ObjectMapper mapper=new ObjectMapper();
		System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(myReqBean));
	}

}
