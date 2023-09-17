package com.sgcib.documentservice;

import com.sgcib.documentservice.infrastructure.proxy.cics.api.CicsApiClient;
import com.sgcib.documentservice.infrastructure.proxy.fgad.api.FgadBddfApiClientCredentials;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = {
		CicsApiClient.class,
		FgadBddfApiClientCredentials.class
})
@EnableSgMonitoring
@EnableSwagger2
@EnableExceptionHandler
public class DocumentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentServiceApplication.class, args);
	}

}
