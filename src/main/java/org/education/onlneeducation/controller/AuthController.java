package org.education.onlneeducation.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.education.onlneeducation.config.SecurityConfig;
import org.education.onlneeducation.jwt.JwtUtils;
import org.education.onlneeducation.jwt.UserDetailsImpl;
import org.education.onlneeducation.models.dto.JwtResponse;
import org.education.onlneeducation.models.dto.LoginRequest;
import org.education.onlneeducation.models.dto.MessageResponse;
import org.education.onlneeducation.models.dto.SignupRequest;
import org.education.onlneeducation.models.entity.User;
import org.education.onlneeducation.models.enums.Role;
import org.education.onlneeducation.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public JwtResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return new JwtResponse(jwt, userDetails.getId() , userDetails.getUsername(), roles);
    }


    @PostMapping("/createUser")
    public MessageResponse registerUser(@Valid @RequestBody SignupRequest signupRequest){
        if(userRepository.existsByUsername(signupRequest.getUsername())){
            throw new RuntimeException ("Error: Username is already in use");
        }
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        if(strRoles == null || strRoles.isEmpty()){
            roles.add(Role.STUDENT);
        }else {
            strRoles.forEach(role -> {
                if(role.equalsIgnoreCase("admin")){
                    roles.add(Role.ADMIN);
                }else if(role.equalsIgnoreCase("teacher")){
                    roles.add(Role.TEACHER);
                }else{
                    roles.add(Role.STUDENT);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return new MessageResponse("User registered successfully!");
    }
}
