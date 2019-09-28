package com.naveen.portal.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.portal.models.Profile;
import com.naveen.portal.models.Response;
import com.naveen.portal.services.ProfileService;
import com.naveen.portal.utils.JwtTokenUtil;

@RestController
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@RequestMapping({"/profile"})
	public ResponseEntity<Response> firstPage(@RequestHeader (name="Authorization") String token) {
		String username = new JwtTokenUtil().getUsernameFromToken(token.split(" ")[1]);
		Profile profile = profileService.findByUsername(username);
		
		HttpStatus status = HttpStatus.OK;
		String message = null;
		
		if (profile == null) {
			message = "Problem fetching Profile. Please retry after sometime.";
		}
		
		Response response = new Response(status, message, profile);
		
		return new ResponseEntity<Response>(response,status);
	}

}
