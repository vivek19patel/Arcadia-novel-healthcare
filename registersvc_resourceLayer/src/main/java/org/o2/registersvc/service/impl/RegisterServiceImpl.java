package org.o2.registersvc.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.o2.registersvc.config.SpringConfigSvc;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.process.RegisterServiceProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;
import org.o2.registersvc.service.builder.RegisterServiceReqBuilder;
import org.o2.registersvc.service.builder.RegisterServiceResBuilder;
import org.o2.registersvc.service.util.RegisterSvcReqInvalidException;
import org.o2.registersvc.service.validator.RegisterServiceValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Path("/svc_resource")
public class RegisterServiceImpl  {
	
	// this method will get the request frm the consumer.
	@Path("/postEnrollment")
	@Produces({"application/xml","application/json"})
	@Consumes(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public RegisterServiceResType enrollment(@HeaderParam ("x-clientId") String clientId,
												@HeaderParam ("x-channelId") String channelId,
														@HeaderParam ("x-reqId") String reqId) {
		System.out.println(clientId+" "+channelId+" "+reqId);
	 	//apply LookUp dependecny injection
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfigSvc.class);
		RegisterServiceValidator wsReqValidator=ctx.getBean("wsReqValidator",RegisterServiceValidator.class);
		RegisterServiceProcess process=ctx.getBean(RegisterServiceProcess.class);
		RegisterServiceReqBuilder reqBuilder =ctx.getBean("reqBuilder",RegisterServiceReqBuilder.class);
		RegisterServiceResBuilder resBuilder=ctx.getBean("resBuilder",RegisterServiceResBuilder.class);
		RegisterSvcProcessVBReq processReq=null;
		RegisterSvcProcessVBRes vbResp=null;
		RegisterServiceResType wsResp=null;
		
		
		//System.out.println("wsReq   "+wsReq);
		RegisterServiceReqType wsReq=new RegisterServiceReqType();
		//validate the wsReq
//=>lookup injected =>//wsReqValidator = new RegisterServiceValidator(); =>lookup injected
		try {
			wsReqValidator.validateWsReq(wsReq);			
			// prepare the process layer object
//=>lookup injected =>//process = new RegisterServiceProcessImpl();
			// prepare the process layer req
			//get RegisterServiceReqBuilder obj and call method to get the  processReq
//=>lookup injected =>//reqBuilder = new RegisterServiceReqBuilder();
			processReq = reqBuilder.buildProcessReq(wsReq);
			
			// calling process layer
			vbResp = process.enrollment(processReq);
			
			//prepare the service layer response by using the processLayer resp(RegisterSvcProcessVBRes)
			//get RegisterServiceResBuilder obj and call method to get the service layer resp(wsResp)
//=>lookup injected =>//resBuilder = new RegisterServiceResBuilder();
			wsResp = resBuilder.buildProcessResp(vbResp);
		} catch (RegisterSvcReqInvalidException e) {
			// create the wsResp obj having respCode respMsg as same as given by
			// the RegisterSvcReqInvalidException obj
			StatusBlockType statusBlk = new StatusBlockType();
			statusBlk.setRespCode(e.getRespCode());
			statusBlk.setRespMsg(e.getRespmsg());
			wsResp = new RegisterServiceResType();
			wsResp.setStatusBlock(statusBlk);
		} catch (BusinessException be) {
			// create the wsResp obj having respCode respMsg as same as given by
			// the RegisterSvcReqInvalidException obj
			StatusBlockType statusBlk = new StatusBlockType();
			statusBlk.setRespCode(be.getRespCode());
			statusBlk.setRespMsg(be.getRespmsg());
			wsResp = new RegisterServiceResType();
			wsResp.setStatusBlock(statusBlk);
		} catch (SystemException se) {
			// create the wsResp obj having respCode respMsg as same as given by
			// the RegisterSvcReqInvalidException obj
			StatusBlockType statusBlk = new StatusBlockType();
			statusBlk.setRespCode(se.getRespCode());
			statusBlk.setRespMsg(se.getRespmsg());
			wsResp = new RegisterServiceResType();
			wsResp.setStatusBlock(statusBlk);
		} /*catch (UnkownException ue) {
			// create the wsResp obj having respCode respMsg as same as given by
			// the RegisterSvcReqInvalidException obj
			StatusBlockType statusBlk = new StatusBlockType();
			statusBlk.setRespCode(ue.getRespCode());
			statusBlk.setRespMsg(ue.getRespmsg());
			wsResp = new RegisterServiceResType();
			wsResp.setStatusBlock(statusBlk);
		}*/catch (Exception e) {
			StatusBlockType statusBlk = new StatusBlockType();
			statusBlk.setRespCode("reg014");
			statusBlk.setRespMsg("Unkown Issue");
			wsResp = new RegisterServiceResType();
			wsResp.setStatusBlock(statusBlk);
		}
		
		return wsResp;

	}
	
	
	public void checkDI(){
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfigSvc.class);
		RegisterServiceValidator wsReqValidator=ctx.getBean("wsReqValidator",RegisterServiceValidator.class);
		RegisterServiceProcess process=ctx.getBean(RegisterServiceProcess.class);
		RegisterServiceReqBuilder reqBuilder =ctx.getBean("reqBuilder",RegisterServiceReqBuilder.class);
		RegisterServiceResBuilder resBuilder=ctx.getBean("resBuilder",RegisterServiceResBuilder.class);
		RegisterSvcProcessVBReq processReq=null;
		RegisterSvcProcessVBRes vbResp=null;
		RegisterServiceResType wsResp=null;
		
		System.out.println("wsReqValidator  "+wsReqValidator);
		System.out.println("process  "+process);
		System.out.println("reqBuilder  "+reqBuilder);
		System.out.println("resBuilder  "+resBuilder);
	}
}
