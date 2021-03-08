package io.agileintelligence.ppmtool.security;

import io.agileintelligence.ppmtool.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import static io.agileintelligence.ppmtool.security.SecurityConstants.EXPIRATION_TIME;
import static io.agileintelligence.ppmtool.security.SecurityConstants.SECRET;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    // generate the token

    public String generateToken(Authentication authentication){
        User user= (User) authentication.getPrincipal();

        Date now= new Date(System.currentTimeMillis());
        Date expireDate= new Date(now.getTime()+EXPIRATION_TIME);

        String userId=Long.toString(user.getId());

        Map<String, Object> claims=new HashMap<>();
        claims.put("id", Long.toString(user.getId()));
        claims.put("username", user.getUsername());
        claims.put("fullName", user.getFullName());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,SECRET)
                .compact();
    }
}
