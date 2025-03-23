package com.example.SportProgam.Authentication.security;
import com.example.SportProgam.ApiConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String FRONT_IP = ApiConfig.FRONT_IP;
    private static final String FRONT_PORT = ApiConfig.FRONT_PORT;


    private static final String[] AUTH_WHITELIST = {
            "/api/authentication/**",
            "/swagger-resources/**", // для Swagger
            "/v3/api-docs", // документация
            "/swagger-ui/**", // UI для Swagger
            // таблица рейтинга,
            "/api/coordinates/all",
            "/api/article/**",
            "/api/image/**"
//            "/api/user/**"

    };
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorization -> authorization
                                .requestMatchers(AUTH_WHITELIST).permitAll() // Открытые эндпоинты
                                .requestMatchers("/api/user/**").hasAnyRole("USER", "VOLUNTEER", "ADMIN")  // Для пользователей с ролью USER
                                .requestMatchers("/volunteer/**").hasAnyRole("VOLUNTEER", "ADMIN") // Для администраторов
                                .requestMatchers("/api/admin/**").hasAnyRole("ADMIN") // Для администраторов
                                .requestMatchers("/admin/**").authenticated() // Любой аутентифицированный пользователь
//                        .anyRequest().denyAll() // Запрещаем все остальное
                )
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
        ; // Добавляем фильтр для JWT

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);    // Разрешить отправку куки/авторизации
        configuration.setAllowedOrigins(List.of(
                "http://localhost:3000/**", "http://" + FRONT_IP + ":" + FRONT_PORT + "/**",
                "http://localhost:3000", "http://" + FRONT_IP + ":" + FRONT_PORT));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);  // данная конфигурация для всех эндпоинтов
        return source;
    }

    @Bean(name = "BCryptPasswordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
