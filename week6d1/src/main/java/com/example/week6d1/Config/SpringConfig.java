package com.example.week6d1.Config;


import com.example.week6d1.servis.MyuserDitilsServis;
import lombok.RequiredArgsConstructor;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableCaching
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringConfig {
    public final MyuserDitilsServis myuserDitilsServis;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myuserDitilsServis);
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
                .requestMatchers("/api/v1/user/username").hasAuthority("USER")
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