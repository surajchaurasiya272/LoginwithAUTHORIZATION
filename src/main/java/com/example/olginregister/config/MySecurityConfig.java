package com.example.olginregister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // .csrf().disable()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                // .antMatchers("/public/**").permitAll()
                .antMatchers("/signin").permitAll()
                .antMatchers("/public/**").hasRole("NORMAL")
                .antMatchers("/users/").hasRole("ADMIN")

                .anyRequest().authenticated()
                .and()
                // .httpBasic();    
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/users/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("jonny")
                .password(this.passwordEncoder().encode("jonny")) // Encode password using BCryptPasswordEncoder

                // .password(passwordEncoder().encode("jonny")) // Encode password using
                // BCryptPasswordEncoder
                .roles("NORMAL"); // Use roles without the "ROLE_" prefix

        auth.inMemoryAuthentication()
                .withUser("ankit")
                .password(this.passwordEncoder().encode("ankit")) // Encode password using BCryptPasswordEncoder

                // .password(passwordEncoder().encode("jonny")) // Encode password using
                // BCryptPasswordEncoder
                .roles("ADMIN"); // Use roles without the "ROLE_" prefix

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
