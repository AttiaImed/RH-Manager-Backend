package com.mission.RHManager.config;

import com.mission.RHManager.Entites.Enum.TypeUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {
            "/v1/auth/**",
            "/**"
    };

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .requestMatchers(DELETE, "/Project/**").hasAnyAuthority(TypeUser.ADMINISTRATEUR.name())
                                .requestMatchers(DELETE, "/Equipe/**").hasAnyAuthority(TypeUser.ADMINISTRATEUR.name())
                                .requestMatchers(PUT, "/Reclamation/**").hasAnyAuthority(TypeUser.RH.name(), TypeUser.EMPLOYE.name())
                                .requestMatchers(DELETE, "/Utilisateur/**").hasAnyAuthority(TypeUser.ADMINISTRATEUR.name())
                                .requestMatchers(PUT, "/Utilisateur/**").hasAnyAuthority(TypeUser.ADMINISTRATEUR.name())
                                .requestMatchers(PUT, "/FeedBack/**").hasAnyAuthority(TypeUser.ADMINISTRATEUR.name(),TypeUser.EMPLOYE.name())
                                .requestMatchers(DELETE, "/FeedBack/**").hasAnyAuthority(TypeUser.ADMINISTRATEUR.name())

                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }
}