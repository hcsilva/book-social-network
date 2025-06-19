package com.code.book_network.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private long jwtExpiration;
    private String secretKey;

    public String generationToken(UserDetails userDetails) {
        return generationToken(new HashMap<>(), userDetails);
    }

    private String generationToken(Map<String, Object> claims, UserDetails userDetails) {
        return buildToken(claims, userDetails, jwtExpiration);
    }

    private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, long jwtExpiration) {
        var now = Instant.now();
        var expirationInstant = now.plusMillis(jwtExpiration);
        var authorities = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        JwtBuilder builder = Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(now))
                .expiration(Date.from(expirationInstant))
                .claim("authorities", authorities)
                .signWith(getSignInKey());

        for (Map.Entry<String, Object> entry : extraClaims.entrySet()) {
            builder.claim(entry.getKey(), entry.getValue());
        }

        return builder.compact();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
