package org.o2.svc.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class registersvc_clientLayer_Get {
	public static void clientGetEnroll_directUri(){
		//create the vlient obj
		String uri="http://localhost:8181/registersvc_ResourceWeb/rest/resource/getEnroll?x-clientId=111&x-channelId=111&x-reqId=11&cardNum=123";
		Client client=Client.create();
		WebResource resource=client.resource(uri);
		ClientResponse response=resource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
		String res=response.getEntity(String.class);
		System.out.println("res is: "+res);
	}
	
	public static void clientGetEnroll_dynamicUri(RegisterServiceClientReq clientReq){
		//create the vlient obj
		String uri="http://localhost:8181/registersvc_ResourceWeb/rest/resource/getEnroll?x-clientId=111&x-channelId=111&x-reqId=11&cardNum=123";
		Client client=Client.create();
		WebResource resource=client.resource(uri);
		ClientResponse response=resource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
		String res=response.getEntity(String.class);
		System.out.println("res is: "+res);
	}
	
	public static void main(String[] args) {
		clientGetEnroll_directUri();
	}
	
}
