package com.enterprise.config;

import com.enterprise.entities.enterprise.UserApi;
import com.enterprise.hash.Hash;
import com.enterprise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class JwtAuthenticationController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {
//		System.out.println("User received on controller: "+authenticationRequest);
		//Verify if the autheticate is ok
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
//				System.out.println("=============");
//				System.out.println(userDetails);
		List<UserApi> found =userService.getUserByName(authenticationRequest.getUsername());
		//Generate a token with user credentials
		final String token = "Bearer "+jwtTokenUtil.generateToken(userDetails, found.stream().iterator().next().getAdmin());

		return ResponseEntity.ok(token);
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		System.out.println("Authenticate: "+username+" "+password);

		//Search user on database
		List<UserApi> found =userService.getUserByName(username);
		System.out.println("found "+found);
		AtomicBoolean ok = new AtomicBoolean(false);

		//Create a hash with password send by user
		String securePassword = Hash.getSecurePassword(password);
		System.out.println("pass to hash"+ securePassword);
		if(!found.isEmpty()){
			//Verify if the hash generated with the password send by user is equal to the hash saved
			found.stream().forEach(x->{
				ok.set(x.getUsername().equals(username) && x.getPassword().equals(securePassword));
			});
		}
		//If there isen't user on db
		if(found.isEmpty() || !ok.get()) {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			} catch (DisabledException e) {
				throw new Exception("USER_DISABLED", e);
			} catch (BadCredentialsException e) {
				throw new Exception("INVALID_CREDENTIALS", e);
			}
		}
	}
}
