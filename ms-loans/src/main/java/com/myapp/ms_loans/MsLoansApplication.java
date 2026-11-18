package com.myapp.ms_loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RefreshScope
public class MsLoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLoansApplication.class, args);
	}

}
