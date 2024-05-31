package org.example.Config;

import org.example.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Autowired
    private LoginService loginService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests().requestMatchers("/").permitAll();
        http.authorizeHttpRequests().requestMatchers("/admin","/customer").hasRole("ADMIN");
        http.authorizeHttpRequests().requestMatchers("/customer").hasRole("NOTADMIN");

        http.formLogin()
                .loginPage("/Login")
                .defaultSuccessUrl("/")
                .usernameParameter("adminid")
                .passwordParameter("password");
        http.logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/");
        http.exceptionHandling()
                .accessDeniedPage("/accessDenied");
        http.userDetailsService(loginService);
        return http.build();
    }
    @Bean
    public PasswordEncoder PasswordEncoder () {
        //return new MessageDigestPasswordEncoder("SHA-256");
        return new BCryptPasswordEncoder();
    }


}
