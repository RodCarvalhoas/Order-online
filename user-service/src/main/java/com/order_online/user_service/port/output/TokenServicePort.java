package com.order_online.user_service.port.output;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.order_online.user_service.domain.model.UserModel;

public interface TokenServicePort {

    String generateToken(UserModel user);

    DecodedJWT verifyToken(String token);

    String getSubject(String token);
}
