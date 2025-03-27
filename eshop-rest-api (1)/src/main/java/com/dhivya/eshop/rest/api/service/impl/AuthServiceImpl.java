//package com.thevarungupta.eshop.rest.api.service.impl;
//
//import entity.com.dhivya.eshop.rest.api.Role;
//import entity.com.dhivya.eshop.rest.api.User;
//import payload.com.dhivya.eshop.rest.api.LoginDto;
//import payload.com.dhivya.eshop.rest.api.RegisterDto;
//import repository.com.dhivya.eshop.rest.api.RoleRepository;
//import repository.com.dhivya.eshop.rest.api.UserRepository;
//import service.com.dhivya.eshop.rest.api.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class AuthServiceImpl implements AuthService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public String login(LoginDto loginDto) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword())
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return "User logged in successfully!";
//    }
//
//    @Override
//    public String register(RegisterDto registerDto) {
//        // check for username exist in database
//        if(userRepository.existsByUsername(registerDto.getUsername())){
//            return "Username is already taken!";
//        }
//
//        // check for email exist in database
//        if(userRepository.existsByEmail(registerDto.getEmail())){
//            return "Email is already taken!";
//        }
//
//        // create new user
//        User user = new User();
//        user.setName(registerDto.getName());
//        user.setUsername(registerDto.getUsername());
//        user.setEmail(registerDto.getEmail());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//
//        // assign role to user
//        Set<Role> roles = new HashSet<>();
//        Role role = roleRepository.findByName("ADMIN").get();
//        roles.add(role);
//        user.setRoles(roles);
//
//        // save user
//        userRepository.save(user);
//        return "User registered successfully!";
//    }
//}
