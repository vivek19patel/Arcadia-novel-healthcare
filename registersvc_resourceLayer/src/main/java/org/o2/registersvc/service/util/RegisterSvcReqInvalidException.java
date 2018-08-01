package org.o2.registersvc.service.util;

public class RegisterSvcReqInvalidException extends Exception {
	private String respCode;
	private String respmsg;

	//whenwver we r throwing the this exception class obj, then respcode and respmsg will be set into this obj.
	public RegisterSvcReqInvalidException(String respCode, String respmsg) {
		this.respCode = respCode;
		this.respmsg = respmsg;
	}

	//to set the RegisterServiceResType wsResp.RespCode and wsResp.respMsg, then we need getter method of this class
	public String getRespCode() {
		return respCode;
	}

	public String getRespmsg() {
		return respmsg;
	}

	
	
}
