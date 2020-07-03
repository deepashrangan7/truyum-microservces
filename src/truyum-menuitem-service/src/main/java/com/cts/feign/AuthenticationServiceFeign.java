package com.cts.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.modal.Users;
@FeignClient("truyum-zuul-gateway")
//@FeignClient("truyum-authentication-service")
//@RibbonClient(name="truyum-authentication-service")
public interface AuthenticationServiceFeign {
	@PostMapping("truyum-authentication-service/authenticate")
	public String getToken(@RequestBody Users user);
	@PostMapping("truyum-authentication-service/validate")
	public boolean validate(@RequestBody String token);
}
