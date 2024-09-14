package org.example.petproj.security.configuration;

import org.example.petproj.security.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService detailsService;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth->
                        auth.requestMatchers("/WEB-INF/view/**", "/registration", "/perform_registration")
                                .permitAll()
                                .requestMatchers("/cheese/**").hasAnyRole("CHEESE_PRODUCER", "ADMIN")
                                .requestMatchers("/materials/**").hasAnyRole("STORAGE_WORKER", "ADMIN")
                                .requestMatchers("/sells/**").hasAnyRole("SELLER", "ADMIN")
                                .requestMatchers("/recipes/**").hasAnyRole("ADMIN")
                                .anyRequest().
                                authenticated()
                ).formLogin(login->
                       login.loginPage("/login").permitAll().defaultSuccessUrl("/shop/stats")
                )
                .logout(logout->logout.logoutUrl("/logout"))
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    AuthenticationManager authenticationManager(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(encoder());
        daoAuthenticationProvider.setUserDetailsService(detailsService);
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(8);
    }
}
