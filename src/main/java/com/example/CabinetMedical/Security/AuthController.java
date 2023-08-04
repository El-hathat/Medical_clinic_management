package com.example.CabinetMedical.Security;

import com.example.CabinetMedical.Models.Medcin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CabinetMedical.Services.MedcinService;


@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private MedcinService medcinService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {
    	System.out.println(signInRequest.getPassword());
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
        

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        UserDetails userDetails = medcinService.loadUserByUsername(signInRequest.getUsername());
        String token = tokenUtil.generateToken(userDetails);
        Medcin md=medcinService.getByEmail(userDetails.getUsername());
        JwtResponse response = new JwtResponse(md,token);
        System.out.println(token);
        return response;
    }
}
