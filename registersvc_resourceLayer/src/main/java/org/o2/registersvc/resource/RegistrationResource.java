package org.o2.registersvc.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.CreditCheckType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;

import com.sun.jersey.api.uri.UriComponent.Type;

@Path("/resource")
public class RegistrationResource {
	//url: http://localhost:8454/registersvc_ResourceWeb/rest/resource/getEnroll?x-clientId=111&x-channelId=111&x-reqId=11&cardNum=123
	@GET
	@Path("/getEnroll")
	@Produces({"application/xml","application/json"})
	public RegisterServiceResType enrollment(@HeaderParam ("x-clientId") String clientId,
											@HeaderParam ("x-channelId") String channelId,
											@HeaderParam ("x-reqId") String reqId,
											@QueryParam ("cardNum") String cardNum,
											@QueryParam ("cvvNum") String cvvNum,
											@QueryParam ("expDate") String expDate,
											@QueryParam ("nameOnCard") String nameOnCard,
											@QueryParam ("accNum") String accNum,
											@QueryParam ("mobileNum") String mobileNum
											){
		
		//need to get the query params value and print those data  here.
		System.out.println("client_id: "+clientId);
		System.out.println("channelId: "+channelId);
		System.out.println("x-reqId: "+reqId);
		System.out.println("cardNum: "+cardNum);
		System.out.println("cvvNum: "+cvvNum);
		System.out.println("expDate: "+expDate);
		System.out.println("nameOnCard: "+nameOnCard);
		System.out.println("accNum: "+accNum);
		System.out.println("mobileNum: "+mobileNum);
		
		
		
		//here making the resp obj manually, and return to the caller
		RegisterServiceResType res=new RegisterServiceResType();
		CreditCheckType ccType=new CreditCheckType();
		ccType.setRateofper(60.0f);
		ccType.setCreditstatus("valid");
		
		StatusBlockType sbType=new StatusBlockType();
		sbType.setRespCode("0000");
		sbType.setRespMsg("success");
		
		res.setCreditCheck(ccType);
		res.setStatusBlock(sbType);
		
		return res;
		
	}
	
	//url: http://localhost:8454/registersvc_ResourceWeb/rest/resource/postEnroll
	@POST
	@Path("/postEnroll")
	@Produces({"application/xml","application/json"})
	@Consumes(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public RegisterServiceResType enrollmentPost(@HeaderParam ("x-clientId") String clientId,
											@HeaderParam ("x-channelId") String channelId,
											@HeaderParam ("x-reqId") String reqId,RegisterServiceReqType req											
											){
		
		//need to get the query params value and print those data  here.
		
		
		//here making the resp obj manually, and return to the caller
		RegisterServiceResType res=new RegisterServiceResType();
		CreditCheckType ccType=new CreditCheckType();
		ccType.setRateofper(60.0f);
		ccType.setCreditstatus("valid");
		
		StatusBlockType sbType=new StatusBlockType();
		sbType.setRespCode("0000");
		sbType.setRespMsg("success");
		
		res.setCreditCheck(ccType);
		res.setStatusBlock(sbType);
		
		return res;
		
	}

}
