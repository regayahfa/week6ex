package com.example.exc1.Config;

import com.example.exc1.Servis.UserServis;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SpringConfig {

private final UserServis userSiervis;
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userSiervis);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //1st stop attauk
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests()
                //اعطاء الصلاحيات لليوزر والادمن فقط هي اللي تتغير
                .requestMatchers("/api/v1/user/reggister").permitAll()
                .requestMatchers("/api/v1/user/admin").hasAuthority("ADMIN")
                .requestMatchers("/api/v1/user/user").hasAuthority("costumer")
                .anyRequest().authenticated()
                .and()
                //for logout
                .logout().logoutUrl("/api/v1/user/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
        return http.build();
    }

}
