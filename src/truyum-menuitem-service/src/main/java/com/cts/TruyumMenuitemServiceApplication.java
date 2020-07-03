package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.cts")
@ComponentScan(basePackages = "com.cts")
public class TruyumMenuitemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumMenuitemServiceApplication.class, args);
	System.out.println("servert started menu item at 8000");
	}

}
