package org.o2.registersvc.resource;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.req.RegisterSvcReqBean;

public class JAXBMarshaller {

	public static void main(String[] args) throws JAXBException, JsonGenerationException, JsonMappingException, IOException {
		
		JAXBContext ctxt = JAXBContext.newInstance(RegisterServiceReqType.class);
		
		 Marshaller marsh = ctxt.createMarshaller();
		 
		 /*RegisterServiceReqType req = new RegisterServiceReqType();
		 CardDetailsType cardD=new CardDetailsType();
		 cardD.setCardNum("1234505");
		 cardD.setCvv("123");
		 cardD.setExpDate("20/01/2023");
		 cardD.setNameOnCard("Abhay");
		 req.setCardDetails(cardD);
		 AccountDetailsType accntDet=new AccountDetailsType();
		 accntDet.setAccountNum("521236987");
		 accntDet.setMobileNum(8750722329l);
		 req.setAccountDetails(accntDet);*/
		 
		 RegisterSvcReqBean req=new RegisterSvcReqBean();
		 req.setAccountNum("accnt NO");
		 req.setApiname("apiname");
		 req.setCardNum("cardno");
		 req.setChannelId("chanelid");
		 req.setClientId("client id");
		 req.setCvv("cvv");
		 req.setExpDate("expDate");
		 req.setMobileNum(8750722329l);
		 req.setNameOnCard("Abhay");
		 req.setReqId("req id");
		 ObjectMapper mapper= new ObjectMapper();
		 String jsn=mapper.defaultPrettyPrintingWriter().writeValueAsString(req);
		 System.out.println(jsn);
		// marsh.marshal(req, System.out);

	}

}
