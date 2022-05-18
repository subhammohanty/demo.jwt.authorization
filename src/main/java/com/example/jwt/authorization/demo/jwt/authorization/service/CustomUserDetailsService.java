package com.example.jwt.authorization.demo.jwt.authorization.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwt.authorization.demo.jwt.authorization.entity.JwtUser;
import com.example.jwt.authorization.demo.jwt.authorization.repository.JwtUserRepository;

@Service
public class CustomUserDetailsService  implements UserDetailsService{
	
	@Autowired
	private JwtUserRepository jwtUserRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUser> findById = jwtUserRepo.findById(username);
		
		
		if(findById.isPresent()) {
			return new User(findById.get().getUserName(), findById.get().getPassword(), new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User Not Found !!");
		}
	}

}
