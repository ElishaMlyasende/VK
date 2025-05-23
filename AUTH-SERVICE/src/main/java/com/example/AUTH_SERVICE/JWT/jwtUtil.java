package com.example.AUTH_SERVICE.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.example.shareDTO.commonDTO.userResponse;

import java.util.Date;

import static javax.crypto.Cipher.SECRET_KEY;

@Component
public class jwtUtil {
    private final  String Secret_Key="c9d51d18b1ef47ea9f1a3d47f0e297e89f3b0b9a786e4b6c92b58a9c4a5d3e7f5fc09e9e3d75b1a46e6c8a7e3cf4c9fd";
    public String generateToken( userResponse userResponse){
        return Jwts.builder()
                .setSubject(userResponse.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(Keys.hmacShaKeyFor(Secret_Key.getBytes()), SignatureAlgorithm.HS256)
                .compact();

    }

    public String extractToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(Secret_Key.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateToken(String token, userResponse userResponse){
        final  String username=extractToken(token);
        return (username.equals(userResponse.getUsername())&& !isTokenExpired(token));
    }
    public boolean isTokenExpired(String token){
        final Date expiration= Jwts.parserBuilder()
                .setSigningKey(Secret_Key.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return  expiration.before(new Date());
    }

}
