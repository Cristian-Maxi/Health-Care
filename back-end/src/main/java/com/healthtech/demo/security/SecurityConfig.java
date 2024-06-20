package com.healthtech.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AutenticationService autenticationService;

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                //.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    // EndPoints públicos
                    http.requestMatchers(HttpMethod.GET, "/csrf-token").permitAll();
                    http.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    http.requestMatchers(HttpMethod.POST, "/auth/sign-up").permitAll();
                    // EndPoints privados Pacientes
                    http.requestMatchers(HttpMethod.GET, "/paciente/listarPacientes").authenticated();
                    http.requestMatchers(HttpMethod.GET, "/paciente/seleccionar/{id}").authenticated();
                    http.requestMatchers(HttpMethod.DELETE, "/paciente/eliminar/{id}").authenticated();
                    http.requestMatchers(HttpMethod.PUT, "/paciente/modificar").authenticated();
                    // EndPoints privados Psicologos
                    http.requestMatchers(HttpMethod.GET, "/psicologo/listarPsicologos").authenticated();
                    http.requestMatchers(HttpMethod.GET, "/psicologo/seleccionar/{id}").authenticated();
                    http.requestMatchers(HttpMethod.POST, "/psicologo/crear").authenticated();
                    http.requestMatchers(HttpMethod.DELETE, "/psicologo/eliminar/{id}").authenticated();
                    // EndPoint privado Consulta
                    http.requestMatchers(HttpMethod.POST, "/consulta/crear").authenticated();
                    http.requestMatchers(HttpMethod.GET, "/consulta/listarConsultas").authenticated();
                    http.requestMatchers(HttpMethod.GET, "/consulta/seleccionar/{id}").authenticated();
                    // EndPoint privado Emocion
                    http.requestMatchers(HttpMethod.POST, "/emocion/crear").authenticated();
                    http.requestMatchers(HttpMethod.GET, "/emocion/listarEmociones").authenticated();
                    http.requestMatchers(HttpMethod.GET, "/emocion/seleccionar/{id}").authenticated();
                    http.requestMatchers(HttpMethod.DELETE, "/emocion/eliminar/{id}").authenticated();
                    http.requestMatchers(HttpMethod.PUT, "/emocion/modificar").authenticated();
                    // Swagger-ui
                    http.requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll(); //Necesario para Swagger UI
                    // Permitir solicitudes OPTIONS para CORS
                    http.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    http.anyRequest().denyAll();
                })
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(autenticationService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
