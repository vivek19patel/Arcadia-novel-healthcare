package org.o2.registersvc.spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages={"org.o2.login.verification.dao.impl","org.o2.register.util","org.o2.registersvc.spring.config"})
@Import( value={LoginDaoSpringConfig.class})
@PropertySource(value="classpath:db_details.properties") 	
public class SpringConfig {
	
}
