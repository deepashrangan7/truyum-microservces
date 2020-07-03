package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class TruyumZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumZuulGatewayApplication.class, args);
	System.out.println("zuul server started at 8765");
	}
//	@Bean
//    public PreFilter preFilter() {
//        return new PreFilter();
//    }
//    @Bean
//    public PostFilter postFilter() {
//        return new PostFilter();
//    }
//    @Bean
//    public ErrorFilter errorFilter() {
//        return new ErrorFilter();
//    }
//    @Bean
//    public RouteFilter routeFilter() {
//        return new RouteFilter();
//    }
}
