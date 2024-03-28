package org.example.jwt.security;


import org.example.jwt.security.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomerDetailService customerDetailService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtFilter jwtFilter) throws Exception
    {
        httpSecurity.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                .csrf().disable()
                .cors(cors ->cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests()
                .antMatchers("/api/user/singup","/api/user/login","/api/carreraa")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
{
return authenticationConfiguration.getAuthenticationManager();
}

    @Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(List.of("*"));
        config.setAllowedMethods(List.of("GET","POST","DELETE","PUT"));
        config.setAllowedHeaders(List.of("Authorization","Content-Type"));
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config);
        return  source;
    }


    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter()
    {
        FilterRegistrationBean<CorsFilter>corsBean = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
        corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsBean;

    }
}
