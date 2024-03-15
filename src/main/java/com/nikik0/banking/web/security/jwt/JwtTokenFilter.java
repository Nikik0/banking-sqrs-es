package com.nikik0.banking.web.security.jwt;

import io.github.ilyalisov.jwt.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final UserDetailsService userDetailsService;
    private final TokenService jwtService;

    @Override
    @SneakyThrows
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            String token = getToken((HttpServletRequest) servletRequest);
            if (!token.isEmpty()
                    && jwtService.getType(token).equals(TokenType.ACCESS.name())
                    && !jwtService.isExpired(token)){
                Authentication auth = getAuthentication(token);
                if (auth != null){
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }catch (Exception ignored){}
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Authentication getAuthentication(String token) {
        String subject = jwtService.getSubject(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
        if (userDetails != null){
            return new UsernamePasswordAuthenticationToken(
                    userDetails,
                    "",
                    userDetails.getAuthorities()
            );
        }
        return null;
    }

    private String getToken(HttpServletRequest servletRequest) {
        String bearerToken = servletRequest.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return "";
    }
}
