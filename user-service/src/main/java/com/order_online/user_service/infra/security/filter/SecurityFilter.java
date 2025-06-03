package com.order_online.user_service.infra.security.filter;

import com.order_online.user_service.infra.security.services.TokenService;
import com.order_online.user_service.adapter.utils.UserMapper;
import com.order_online.user_service.domain.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromHeaderAuthorization(request);

        if(token != null) {
            String email = tokenService.getSubject(token);
            UserDetails userByEmail = userMapper.toEntity(userService.findByEmail(email));
            UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(userByEmail, null, userByEmail.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(userAuthToken);
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromHeaderAuthorization(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if(authorization == null || authorization.isBlank() || !authorization.startsWith("Bearer ")) {
            return null;
        }

        return authorization.substring(7);
    }
}
