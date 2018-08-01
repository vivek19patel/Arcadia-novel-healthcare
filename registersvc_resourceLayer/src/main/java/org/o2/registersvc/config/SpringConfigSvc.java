package org.o2.registersvc.config;


import org.o2.registersvc.service.builder.RegisterServiceReqBuilder;
import org.o2.registersvc.service.builder.RegisterServiceResBuilder;
import org.o2.registersvc.service.validator.RegisterServiceValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={org.o2.registersvc.config.SpringConfigProcs.class})
@ComponentScan(basePackages={"org.o2.registersvc.service.builder","org.o2.registersvc.service.validator"})
//@PropertySource(value="classpath:db_details.properties") 	

public class SpringConfigSvc {
	
	//get RegisterServiceValidator
	@Bean(name="wsReqValidator")
	public RegisterServiceValidator get_wsReqValidator(){
		return new RegisterServiceValidator();
		
	}
	//get RegisterServiceReqBuilder
	@Bean(name="reqBuilder")
	public RegisterServiceReqBuilder get_reqBuilder(){
		return new RegisterServiceReqBuilder();
		
	}
	
	//get RegisterServiceResBuilder
	@Bean(name="resBuilder")
	public RegisterServiceResBuilder get_resBuilder(){
		return new RegisterServiceResBuilder();
		
	}
}
