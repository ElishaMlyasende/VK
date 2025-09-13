package com.example.AUTH_SERVICE.JWT;

import com.example.shareDTO.commonDTO.userResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class jwtUtil {

    private final String SECRET_KEY = "c9d51d18b1ef47ea9f1a3d47f0e297e89f3b0b9a786e4b6c92b58a9c4a5d3e7f5fc09e9e3d75b1a46e6c8a7e3cf4c9fd";
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Generate JWT token from userResponse including Roles with Permissions and Menus
     */
    public String generateToken(userResponse userResponse) {

        // Prepare Roles with permissions
        List<Map<String, Object>> rolesWithPermissions = userResponse.getRoles().stream()
                .map(role -> Map.of(
                        "name", role.getName(),
                        "Permissions", role.getPermissions() // already List<String>
                ))
                .collect(Collectors.toList());

        // Prepare Menus (direct list)
        List<?> menus = userResponse.getMenus();

        return Jwts.builder()
                .setSubject(userResponse.getUsername())
                .claim("Roles", rolesWithPermissions)
                .claim("Menus", menus)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Extract username from JWT token
     */
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Validate token against userResponse
     */
    public boolean validateToken(String token, userResponse userResponse) {
        final String username = extractUsername(token);
        return username.equals(userResponse.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Check if token is expired
     */
    public boolean isTokenExpired(String token) {
        final Date expiration = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }

    /**
     * Extract all claims from token
     */
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Extract Menus from token
     */
    public List<userResponse.MenuResponse> extractMenus(String token) {
        Claims claims = extractAllClaims(token);
        return objectMapper.convertValue(claims.get("Menus"), new TypeReference<List<userResponse.MenuResponse>>() {});
    }

    /**
     * Extract Roles from token
     */
    public List<userResponse.RoleResponse> extractRoles(String token) {
        Claims claims = extractAllClaims(token);
        return objectMapper.convertValue(claims.get("Roles"), new TypeReference<List<userResponse.RoleResponse>>() {});
    }
}
