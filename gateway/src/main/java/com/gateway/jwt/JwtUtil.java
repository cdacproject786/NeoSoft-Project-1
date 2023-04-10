package com.gateway.jwt;


import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final long EXPIRATION_DURATION = 20 * 60 * 60 * 1000; //24 HOURS

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    private String SECRET_KEY = "SECRET_KEY";



    public boolean validateAccessToken(String token)
    {
        try
        {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        }
        catch(ExpiredJwtException e)
        {
            LOGGER.error("JWT expired",e.getMessage());
        }
        catch(IllegalArgumentException e)
        {
            LOGGER.error("Token is null or empty",e.getMessage());
        }
        catch(MalformedJwtException e)
        {
            LOGGER.error("JWT is invalid",e.getMessage());
        }
        catch(UnsupportedJwtException e)
        {
            LOGGER.error("JWT is not suported",e.getMessage());
        }
        catch(SignatureException e)
        {
            LOGGER.error("Signature validation failed",e.getMessage());
        }

        return false;
    }

    public String getSubject(String token)
    {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token)
    {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
