package com.ziyi.config;

import com.ziyi.model.ResultData;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry.requestMatchers("/api/auth/**")
                        .permitAll().anyRequest().authenticated())
                .formLogin(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry.loginProcessingUrl("/api/auth/login")
                        .successHandler(this::AuthenticationSuccessHandler)
                )
                .csrf(AbstractHttpConfigurer::disable).build();
    }

    public void AuthenticationSuccessHandler(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //解决乱码
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(ResultData.success(null).asJsonString());
    }
}
