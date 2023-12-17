package com.hakanozdabak.rentACar.business.abstracts;

import com.hakanozdabak.rentACar.business.requests.AuthenticationRequest;
import com.hakanozdabak.rentACar.business.requests.RegisterRequest;
import com.hakanozdabak.rentACar.business.responses.AuthenticationResponse;

public interface AuthService {

    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest registerRequest);

}
