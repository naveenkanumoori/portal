package com.naveen.portal.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.portal.models.AuthResponse;
import com.naveen.portal.models.JwtRequest;
import com.naveen.portal.models.JwtResponse;
import com.naveen.portal.models.Profile;
import com.naveen.portal.models.Register;
import com.naveen.portal.models.User;
import com.naveen.portal.services.JwtUserDetailsService;
import com.naveen.portal.services.ProfileService;
import com.naveen.portal.utils.EmailUtil;
import com.naveen.portal.utils.EmailUtil;
import com.naveen.portal.utils.JwtTokenUtil;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	EmailUtil emailUtil;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<AuthResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		HttpStatus status = HttpStatus.OK;
		String message = null;
		AuthResponse response = null;
		String token = null;
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
			final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

			token = jwtTokenUtil.generateToken(userDetails);
		} catch (DisabledException e) {
			status = HttpStatus.UNAUTHORIZED;
			message = "USER_DISABLED";
		} catch (BadCredentialsException e) {
			status = HttpStatus.UNAUTHORIZED;
			message = "INVALID_CREDENTIALS";
		} catch (Exception e) {
			status = HttpStatus.UNAUTHORIZED;
			message = "SERVER_FAILURE";
		}
		response = new AuthResponse(status,message, token);
		return new ResponseEntity<AuthResponse>(response,status);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Register register) throws Exception {
		Profile profile = new Profile();
		profile.fromRegister(register);
		
		profileService.save(profile);
		User user = userDetailsService.save(register);
		try {
			emailUtil.sendActivationEmail(profile, user);
		} catch (Exception e) {
			System.out.println("Error sending email.");
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(user);
	}

	private void authenticate(String username, String password) throws Exception {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
}