//package com.inetum.controllers;
//
//import com.inetum.exceptions.CustomAuthException;
//import com.inetum.models.AuthentificationRequest;
//import com.inetum.models.AuthentificationResponse;
//import com.inetum.services.MyUserDetailService;
//import com.inetum.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:4200")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private MyUserDetailService userDetailService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @PostMapping(path = "/signin")
//    public ResponseEntity<AuthentificationResponse> createAuthentificationToken(@RequestBody AuthentificationRequest authentificationRequest) throws CustomAuthException {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword())
//            );
//        }catch (BadCredentialsException e){
//            throw new CustomAuthException("Incorrect username or password");
//        }
//
//        final UserDetails userDetails = userDetailService.loadUserByUsername(authentificationRequest.getUsername());
//
//        final String jwt = jwtUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthentificationResponse(jwt));
//
//    }
//
//}
