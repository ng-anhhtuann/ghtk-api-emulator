package com.example.GHTK.Ultilities;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWT {
    public static String EncodeString(String string) {
        String toReturn = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(string);
            toReturn = com.auth0.jwt.JWT.create().sign(algorithm);
        } catch (JWTCreationException e) {
            toReturn = e.getMessage();
        }
        return toReturn;
    }

}
