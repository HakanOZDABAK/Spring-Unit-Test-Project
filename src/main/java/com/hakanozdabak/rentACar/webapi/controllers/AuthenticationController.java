package com.hakanozdabak.rentACar.webapi.controllers;

import com.hakanozdabak.rentACar.business.abstracts.AuthService;
import com.hakanozdabak.rentACar.business.abstracts.RefreshTokenService;
import com.hakanozdabak.rentACar.security.jwt.JwtService;
import com.hakanozdabak.rentACar.business.requests.AuthenticationRequest;
import com.hakanozdabak.rentACar.business.requests.RefreshTokenRequest;
import com.hakanozdabak.rentACar.business.requests.RegisterRequest;
import com.hakanozdabak.rentACar.business.responses.AuthenticationResponse;
import com.hakanozdabak.rentACar.entities.concretes.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest registerRequest
    ) {
         authService.register(registerRequest);
         return "User Successfully Added";
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse register(
            @RequestBody AuthenticationRequest authenticationRequest
    ) {
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(authenticationRequest.getEmail());

        return AuthenticationResponse.builder()
                .accessToken(String.valueOf(authService.authenticate(authenticationRequest).getToken()))
                .token(refreshToken.getToken()).build();


    }
    @PostMapping("/refresh")
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return refreshTokenService.findByToken(refreshTokenRequest.getToken())
                 .map(refreshTokenService::verifyExpiration)
                 .map(RefreshToken::getUser)
                 .map(user ->{String accessToken = jwtService.generateToken(user.getEmail());
                   return AuthenticationResponse.builder()
                         .accessToken(accessToken)
                         .token(refreshTokenRequest.getToken())
                         .build();
                 }).orElseThrow(()->new RuntimeException("Refresh token is not in database'"));

    }
}
