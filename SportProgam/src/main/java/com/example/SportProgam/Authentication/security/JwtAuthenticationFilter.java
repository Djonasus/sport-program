package com.example.SportProgam.Authentication.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Извлекаем токен из заголовков запроса
        String token = jwtTokenProvider.resolveToken(request);
        log.info("token is: {}", token);

        // Если токен валиден, аутентифицируем пользователя
        if (token != null && jwtTokenProvider.validateToken(token)) {
            log.info("token is validated");
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            // Устанавливаем аутентификацию в SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        // Продолжаем выполнение цепочки фильтров
        filterChain.doFilter(request, response);
    }
}

