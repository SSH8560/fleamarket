package com.ssh8560.fleamarket.config.security;

import com.ssh8560.fleamarket.config.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JWTTokenValidatorFilter extends OncePerRequestFilter {
    private final String jwtKey;

    public JWTTokenValidatorFilter(String jwtKey) {
        this.jwtKey = jwtKey;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtHeader = request.getHeader(Constants.JWT_HEADER);

        if (jwtHeader == null || !jwtHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }


        String jwt = jwtHeader.substring(7);
        try{
            SecretKey key = Keys.hmacShaKeyFor(jwtKey.getBytes(StandardCharsets.UTF_8));
            Claims claims = (Claims) Jwts.parser()
                .verifyWith(key)
                .build()
                .parse(jwt)
                .getPayload();

            String id = String.valueOf(claims.get("id"));
            String authorities = (String) claims.get("authorities");

            Authentication authentication = new UsernamePasswordAuthenticationToken(id, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (JwtException e){
            e.printStackTrace();
        } finally {
            filterChain.doFilter(request,response);
        }


    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().equals("/login");
    }
}
