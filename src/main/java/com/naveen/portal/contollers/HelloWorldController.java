package com.naveen.portal.contollers;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.portal.utils.JwtTokenUtil;

@RestController
public class HelloWorldController {
	@RequestMapping({ "/hello" })
	public String firstPage(@RequestHeader (name="Authorization") String token) {
		return "Hello "+ new JwtTokenUtil().getUsernameFromToken(token.split(" ")[1]);
	}
}
