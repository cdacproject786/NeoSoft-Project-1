package com.authservice.jwt;

import com.authservice.config.CustomAuthUserObject;
import com.authservice.entity.AuthUser;
import com.authservice.pojo.Admin;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final long EXPIRATION_DURATION = 20 * 60 * 60 * 1000; //24 HOURS

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    private String SECRET_KEY = "SECRET_KEY";

    public String generateAccessToken(CustomAuthUserObject admin)
    {
        return Jwts.builder()
                .setSubject(String.format("%s",admin.getEmail()))
                .setIssuer("Auth-Service")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DURATION))
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
    }


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
