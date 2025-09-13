package com.example.AUTH_SERVICE.JWT;

import com.example.AUTH_SERVICE.FEIGN.userClient;
import com.example.shareDTO.commonDTO.userResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private jwtUtil jwtUtil;

    @Autowired
    private userClient userClient;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        String username = jwtUtil.extractUsername(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            userResponse user = userClient.getUserByUsername(username);

            if (jwtUtil.validateToken(token, user)) {

                // Collect authorities from all roles + permissions
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();

                if (user.getRoles() != null) {
                    for (var role : user.getRoles()) {
                        // Add permissions (avoid null)
                        if (role.getPermissions() != null) {
                            authorities.addAll(
                                    role.getPermissions().stream()
                                            .map(SimpleGrantedAuthority::new)
                                            .collect(Collectors.toList())
                            );
                        }
                    }
                }

                // Optional: add a default authority if list is empty
                if (authorities.isEmpty()) {
                    authorities.add(new SimpleGrantedAuthority("DEFAULT_PERMISSION"));
                }

                // Create Authentication token
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(user, null, authorities);

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
