package alanensina.springsecuritycourse.controllers;

import alanensina.springsecuritycourse.dtos.AuthenticationRequest;
import alanensina.springsecuritycourse.dtos.AuthenticationResponse;
import alanensina.springsecuritycourse.dtos.RegisterRequest;
import alanensina.springsecuritycourse.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return service.register(request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
        return service.authenticate(request);
    }
}
