package com.hakanozdabak.rentACar.business.abstracts;

import com.hakanozdabak.rentACar.entities.concretes.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(String email);
    RefreshToken verifyExpiration(RefreshToken token);
    Optional<RefreshToken> findByToken(String token);
}
