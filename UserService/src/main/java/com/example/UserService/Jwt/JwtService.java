package com.example.UserService.Jwt;

import com.example.UserService.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY="c9d51d18b1ef47ea9f1a3d47f0e297e89f3b0b9a786e4b6c92b58a9c4a5d3e7f5fc09e9e3d75b1a46e6c8a7e3cf4c9fd";
    public String GenerateToken(CustomUserDetail user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", user.getRoles());
        claims.put("permissions", user.getPermissions());
        claims.put("menus", user.getMenus());
        String token= Jwts.
                builder()
                .setSubject(user.getUsername())
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+24*60*60*1000))
                .signWith(getSignKey())
                .compact();
        return  token;
    }
    private SecretKey getSignKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public Claims extractAllClaims(String token){
        return  Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public <T> T extractClaim(String token, Function<Claims,T> resolver){
        Claims claims=extractAllClaims(token);
        return resolver.apply(claims);
    }
    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }
    public boolean isExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public boolean isValid(String token,CustomUserDetail userDetail){
        String username=extractUsername(token);
        return username.equals(userDetail.getUsername())&& !isExpired(token);
    }

}

