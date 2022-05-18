package com.example.jwt.authorization.demo.jwt.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.authorization.demo.jwt.authorization.helper.JwtUtil;
import com.example.jwt.authorization.demo.jwt.authorization.model.JwtModel;
import com.example.jwt.authorization.demo.jwt.authorization.model.JwtResponse;
import com.example.jwt.authorization.demo.jwt.authorization.service.CustomUserDetailsService;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtModel jwtModel) throws Exception{
		System.out.println(jwtModel);
		
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtModel.getUsername(), jwtModel.getPassword()));
			
		}catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credencials !!");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtModel.getUsername());
		
		String generatedToken = this.jwtUtil.generateToken(userDetails);
		System.out.println(generatedToken);
		
		return ResponseEntity.ok(new JwtResponse(generatedToken));
		
	}

}
