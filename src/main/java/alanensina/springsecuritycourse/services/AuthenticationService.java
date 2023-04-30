package alanensina.springsecuritycourse.services;

import alanensina.springsecuritycourse.dtos.AuthenticationRequest;
import alanensina.springsecuritycourse.dtos.AuthenticationResponse;
import alanensina.springsecuritycourse.dtos.RegisterRequest;
import alanensina.springsecuritycourse.enums.Role;
import alanensina.springsecuritycourse.models.User;
import alanensina.springsecuritycourse.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<AuthenticationResponse> register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        repository.save(user);

        var response = AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = repository.findByEmail(request.getEmail()).orElseThrow();

        var response = AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();

        return ResponseEntity.ok(response);
    }
}
